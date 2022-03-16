package com.mypractice.spring.data.jdbc.model;

import org.springframework.data.annotation.Id;

public record Employee(@Id long id, String name, String address) {
}
