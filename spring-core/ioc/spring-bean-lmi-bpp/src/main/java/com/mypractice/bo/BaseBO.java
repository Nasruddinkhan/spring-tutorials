package com.mypractice.bo;

import java.util.Date;

import lombok.Data;
@Data
public abstract class BaseBO {
	private String name;
	private String addrs;
	private Date doj;

}
