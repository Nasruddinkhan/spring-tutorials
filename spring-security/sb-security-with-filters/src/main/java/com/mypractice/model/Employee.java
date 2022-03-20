package com.mypractice.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int id;
	private String name;
	private String email;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@JsonIgnore
	@Column(name = "pwd")
	private String password;
	private String role;
	@Column(name = "create_dt")
	private String createDt;
	
	@JsonIgnore
	@OneToMany(mappedBy="employee",fetch=FetchType.EAGER)
	private Set<Authority> authorities;


}
