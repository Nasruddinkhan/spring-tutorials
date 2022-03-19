package com.mypractice.bean;

import java.util.Date;
import java.util.Set;

public class EmployeeInfo {
	private Set<Long>  phoneNumbers;
	private Set<Date> dates;
	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<Date> getDates() {
		return dates;
	}
	public void setDates(Set<Date> dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [phoneNumbers=" + phoneNumbers + ", dates=" + dates + "]";
	}
	
}
