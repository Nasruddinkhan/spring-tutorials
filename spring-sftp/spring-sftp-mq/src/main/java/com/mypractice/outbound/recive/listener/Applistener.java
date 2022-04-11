package com.mypractice.outbound.recive.listener;

import com.google.gson.Gson;
import com.jcraft.jsch.ChannelSftp;
import com.mypractice.outbound.model.FilePayload;
import com.mypractice.outbound.repo.FilePayloadRepo;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

@Component
@AllArgsConstructor
public class Applistener {
    private final SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory;
    private final Jaxb2Marshaller marshaller;
    private final Publisher publisher;
    private final FilePayloadRepo filePayloadRepo;
    @JmsListener(destination = "inbound.queue")
    //@SendTo("outbound.queue")
    public void receiveMessage(final Message jsonMessage) throws JMSException, IOException, JAXBException {
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            String messageData = textMessage.getText();
            System.out.println("messageData" + messageData);
            Map map = new Gson().fromJson(messageData, Map.class);
            System.out.printf("path seprator" + File.pathSeparator);
            InputStream inputStream = sftpSessionFactory.getSession().readRaw("uploadfile/" + map.get("fileName"));
            //  String str = new ObjectMapper().readValue(inputStream, String.class);
            String str = IOUtils.toString(inputStream, Charset.defaultCharset());
            System.out.println("str [" + str + "]");
            boolean isDirectoryExsit = sftpSessionFactory.getSession().exists("/uploadfile/download");
            System.out.println("Applistener.receiveMessage" + isDirectoryExsit);
            if (!isDirectoryExsit)
                sftpSessionFactory.getSession().mkdir("/uploadfile/download/" + map.get("fileName"));
            sftpSessionFactory.getSession().write(new ByteArrayInputStream(str.getBytes()), "/uploadfile/download/" + map.get("fileName"));

            publisher.sendMessage("outbound.queue", str);

           filePayloadRepo.save(FilePayload.builder().payload(str).build());
        }
    }

    @JmsListener(destination = "outbound.queue")
    public void payLoad(String outbound) {
        System.out.printf("outbound [" + outbound + "]");
    }
}
