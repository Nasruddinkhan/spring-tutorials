package com.mypractice.spring.data.jpa.model;


import lombok.Data;

import javax.persistence.*;

//@Entity
//@Table(name = "employee")
//public record  Employee(@Id @GeneratedValue(generator="incrementId")long id, String name, String address) implements Serializable {
//    public  Employee{
//
//    }
//}
@Data
@Entity
@Table(name = "employee")
public class Employee  { //NOPMD - suppressed MissingSerialVersionUID - TODO explain reason for suppression


    @Id
    @GeneratedValue(generator = "incrementId")
    @Column(name = "id")
    private long empId;
    private String name;
    private String address;
}

