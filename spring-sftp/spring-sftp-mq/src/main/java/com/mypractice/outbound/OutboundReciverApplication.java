package com.mypractice.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import com.mypractice.outbound.recive.listener.Publisher;

@EnableJms
@SpringBootApplication
public class OutboundReciverApplication implements CommandLineRunner{

	@Autowired
	Publisher publisher;
	public static void main(String[] args) {
		SpringApplication.run(OutboundReciverApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		String msg ="{\"fileName\":\"101_MYFILE.txt\"}";
		publisher.sendMessage("inbound.queue", msg);
	}

}
