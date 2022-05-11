package com.mypractice.springbootmongodbcrud.controller;

import com.mypractice.springbootmongodbcrud.document.Order;
import com.mypractice.springbootmongodbcrud.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
}
