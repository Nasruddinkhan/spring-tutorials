package com.mypractice.service;

import com.mypractice.dao.EmployeeDAO;
import com.mypractice.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO dao;


    public EmployeeServiceImpl(EmployeeDAO dao) {
        this.dao = dao;
    }


    public List<EmployeeDTO> findEmpsByDesg(String desg) throws Exception {
        AtomicInteger row  = new AtomicInteger(1);
        return dao.searchEmpsByDesg(desg).stream().map(bo -> {
            EmployeeDTO dto = new EmployeeDTO();
            BeanUtils.copyProperties(bo, dto);
            dto.setSrNo(row.getAndIncrement() );
            return dto;
        }).collect(Collectors.toList());
    }//method
}//class
