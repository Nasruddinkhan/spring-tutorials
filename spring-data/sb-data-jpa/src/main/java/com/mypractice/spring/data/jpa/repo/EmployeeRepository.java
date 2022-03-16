package com.mypractice.spring.data.jpa.repo;

import com.mypractice.spring.data.jpa.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  EmployeeRepository  extends JpaRepository<Employee, Long> {
    Optional<List<Employee>> findByName(String name);
    Page<Employee> findAll(Pageable pageable);
}
