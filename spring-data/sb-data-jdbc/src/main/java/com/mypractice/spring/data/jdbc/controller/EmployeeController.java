package com.mypractice.spring.data.jdbc.controller;

import com.mypractice.spring.data.jdbc.model.Employee;
import com.mypractice.spring.data.jdbc.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository repository;
    @Autowired
    public EmployeeController(final EmployeeRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAllEmployee(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployeeData(@RequestBody final Employee employee){
        return new ResponseEntity<>(repository.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/id")
    public ResponseEntity<Employee> getById(@PathVariable("id") final long empId){
        return new ResponseEntity<>( repository.findById(empId).orElseThrow(()-> new RuntimeException("user not found "+ empId)), HttpStatus.OK);
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<List<Employee>> getByName(@PathVariable  final String name){
        return new ResponseEntity<>( repository.findByName(name).orElseThrow(()-> new RuntimeException("user not found "+ name)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/id")
    public void deleteById(@PathVariable("id") final long empId){
        final var employee = repository.findById(empId).orElseThrow(()-> new RuntimeException("Record Not Found"));
        repository.delete(employee);
    }
    @GetMapping(params = { "page", "size" })
    public  ResponseEntity<Page<Employee>> findAllEmployee(@RequestParam("page") final int page, @RequestParam("size") final int size){
        final var pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(repository.findAll(pageable), HttpStatus.OK);
    }
}
