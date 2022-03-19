package com.mypractice.beans;

import java.util.Date;

public class AmazonInvoice {
	AmazonInvoice(){
		System.out.println("AmazonInvoice.AmazonInvoice()");
	}
	public void genrateInvoice(int invoiceID) {
		System.out.println(invoiceID+"  invoice delivered to customer on "+new Date()+" by HMK");
	}
}
