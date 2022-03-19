package com.mypractice.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "employee")
@Entity
//public record Employee(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id,
//                       String email, String password, String role) {
//}
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String role;


}