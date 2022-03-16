package com.mypractice.spring.data.ldap.sbdataldap;

import com.mypractice.spring.data.ldap.sbdataldap.model.User;
import com.mypractice.spring.data.ldap.sbdataldap.repo.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapUtils;
@EnableLdapRepositories
@SpringBootApplication
public class SbDataLdapApplication implements CommandLineRunner {
   @Autowired
	UserRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(SbDataLdapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var password = DigestUtils.sha256Hex("nasruddin");
		System.out.println("password = " + password);

		User newUser = new User();
		newUser.setUsername("nasruddin");
		newUser.setPassword("nasruddin");
		newUser.setId(LdapUtils.newLdapName("cn=config"));
		//repository.save(newUser);
		repository.findAll();
	}
}
