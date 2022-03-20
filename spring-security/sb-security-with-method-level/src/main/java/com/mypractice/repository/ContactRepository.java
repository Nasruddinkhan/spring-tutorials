package com.mypractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	
}
