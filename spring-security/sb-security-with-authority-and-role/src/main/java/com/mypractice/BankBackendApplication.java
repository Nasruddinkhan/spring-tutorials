package com.mypractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BankBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("passwordEncoder = " + passwordEncoder.encode("123456"));
	}
}
