package com.mypractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.model.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
	
	List<Cards> findByemployeeId(int employeeId);

}
