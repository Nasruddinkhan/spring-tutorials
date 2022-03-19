package com.mypractice.beans;

import java.util.Arrays;
import java.util.Random;

public class InvoiceSystem {
	private Invoice invoice;
	
	

	



	public InvoiceSystem(Invoice invoice) {
		super();
		this.invoice = invoice;
	}







	public InvoiceSystem() {
		super();
		// TODO Auto-generated constructor stub
	}







	public String invoice(String[] item) {
		// TODO Auto-generated method stub
		System.out.println("InvoiceSystem.invoice()");
		float billAmt=0.0f;
		Random invoiceID=null;
		int i=0;
		billAmt=item.length*1000;
		invoiceID=new Random();
		i=invoiceID.nextInt(10000);
		invoice.genrateInvoice(i);
		return Arrays.toString(item)+" Bill Amount:: "+billAmt;
	}
	
}
