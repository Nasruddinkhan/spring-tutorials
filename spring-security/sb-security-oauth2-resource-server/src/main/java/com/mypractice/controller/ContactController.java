package com.mypractice.controller;

import java.sql.Date;
import java.util.Random;

import com.mypractice.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.model.Contact;
import com.mypractice.repository.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	@PostMapping("/contact")
	public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
		contact.setContactId(getServiceReqNumber());
		contact.setCreateDt(new Date(System.currentTimeMillis()));
		return contactRepository.save(contact);
	}

	public String getServiceReqNumber() {
	    Random random = new Random();
	    int ranNum = random.nextInt(999999999 - 9999) + 9999;
	    return "SR"+ranNum;
	}
}
