package com.mypractice.spring.data.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SbDataJdbcApplication  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SbDataJdbcApplication.class, args);
	}

	public void run(String... args) throws Exception {
			jdbcTemplate.execute("INSERT INTO Employee(name,address) VALUES('PQR', 'Vikhroli')");
			jdbcTemplate.execute("INSERT INTO Employee(name,address) VALUES('ABC', 'Sakinaka')");
			jdbcTemplate.execute("INSERT INTO Employee(name,address) VALUES('MNO', 'Ghatopar')");
			jdbcTemplate.execute("INSERT INTO Employee(name,address) VALUES('PQR', 'Andheri')");
	}
}
