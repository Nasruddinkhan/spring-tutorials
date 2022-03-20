package com.mypractice.outbound.recive.listener;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.jcraft.jsch.ChannelSftp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
@AllArgsConstructor
public class Publisher {

	private final JmsTemplate jmsTemplate;

	public void sendMessage(final String queueName, final String message) throws IOException {
		//Map map = new Gson().fromJson(message, Map.class);
		//Stirng quuename = map.get("fileName");
		jmsTemplate.send(queueName, session -> {
			TextMessage message1 = session.createTextMessage();
			message1.setText(message);
			return message1;
		});
		//Arrays.stream(sftpSessionFactory.getSession().list("uploadfile")).forEach(System.out::println);
	}
}
