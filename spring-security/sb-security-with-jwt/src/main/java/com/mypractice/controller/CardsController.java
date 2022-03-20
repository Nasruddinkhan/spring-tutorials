package com.mypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.model.Cards;
import com.mypractice.model.Employee;
import com.mypractice.repository.CardsRepository;

@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardsRepository;
	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Employee employee) {
		List<Cards> cards = cardsRepository.findByemployeeId(employee.getId());
		if (cards != null ) {
			return cards;
		}else {
			return null;
		}
	}

}
