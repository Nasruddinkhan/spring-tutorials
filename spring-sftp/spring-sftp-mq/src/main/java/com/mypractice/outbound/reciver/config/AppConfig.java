package com.mypractice.outbound.reciver.config;

import com.jcraft.jsch.ChannelSftp;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;

@Configuration
public class AppConfig {

	String BROKER_URL = "tcp://localhost:61617";
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    connectionFactory.setPassword(BROKER_USERNAME);
	    connectionFactory.setUserName(BROKER_PASSWORD);
	    return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setPubSubDomain(true);
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		   DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	       factory.setConnectionFactory(connectionFactory());
	       factory.setPubSubDomain(true);

	     //  factory.setDestinationResolver(destinationResolver());
	       factory.setSessionTransacted(true);
	       factory.setConcurrency("5");
	       return factory;
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
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("com.mypractice.*");
		jaxb2Marshaller.setMarshallerProperties(new HashMap<String, Object>() {{
			put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// set more properties here...
		}});
		return jaxb2Marshaller;
	}
}
