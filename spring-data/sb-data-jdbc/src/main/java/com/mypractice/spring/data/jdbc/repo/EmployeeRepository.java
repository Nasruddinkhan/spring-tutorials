package com.mypractice.spring.data.jdbc.repo;

import com.mypractice.spring.data.jdbc.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  EmployeeRepository  extends PagingAndSortingRepository<Employee, Long>{
    Optional<List<Employee>> findByName(String name);

    @Modifying
    @Query("UPDATE employee SET name = :name WHERE id = :id")
    boolean updateName(@Param("id") Long id, @Param("name") String name);

    Page<Employee> findAll(Pageable pageable);
}
