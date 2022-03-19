package com.mypractice.beans;

import java.util.Date;

public class AmazonInvoice implements Invoice{
	AmazonInvoice(){
		System.out.println("AmazonInvoice.AmazonInvoice()");
	}
	@Override
	public void genrateInvoice(int invoiceID) {
		System.out.println(invoiceID+"  invoice delivered to customer on "+new Date()+" by HMK");
	}
}
