package com.mypractice.sb.sftp;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.filters.SftpSimplePatternFileListFilter;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizer;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizingMessageSource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.MessageHandler;

import java.io.File;

@SpringBootApplication
public class SpringSftpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSftpApplication.class, args);
	}

	@Bean
	public SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory() {
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
		factory.setHost("localhost");
		factory.setPort(22);
		factory.setUser("nasruddin");
		factory.setPassword("nasruddin");
		factory.setAllowUnknownKeys(true);
		return new CachingSessionFactory<>(factory);
	}

	@Bean
	public SftpInboundFileSynchronizer sftpInboundFileSynchronizer() {
		SftpInboundFileSynchronizer fileSynchronizer = new SftpInboundFileSynchronizer(sftpSessionFactory());
		fileSynchronizer.setDeleteRemoteFiles(false);
		fileSynchronizer.setRemoteDirectory("uploadfile");
		fileSynchronizer.setFilter(new SftpSimplePatternFileListFilter("*.txt"));
		return fileSynchronizer;
	}

	@Bean
	@InboundChannelAdapter(channel = "sftpChannel", poller = @Poller(fixedDelay = "5000"))
	public MessageSource<File> sftpMessageSource() {
		SftpInboundFileSynchronizingMessageSource source =
				new SftpInboundFileSynchronizingMessageSource(sftpInboundFileSynchronizer());
		source.setLocalDirectory(new File("D:\\Projects/sftp-inbound"));
		source.setAutoCreateLocalDirectory(true);
		source.setLocalFilter(new AcceptOnceFileListFilter<>());
		//source.setMaxFetchSize(2);
		return source;
	}

	@Bean
	@ServiceActivator(inputChannel = "sftpChannel")
	public MessageHandler handler() {
		return message -> System.out.println("payload "+ message.getPayload());
	}

}
