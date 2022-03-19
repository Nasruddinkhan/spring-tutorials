package com.mypractice.beans;

import java.util.Date;

public class FlipCartInvoice {

	public FlipCartInvoice() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("FlipCartInvoice.FlipCartInvoice() Create Invoice");
	}
	public void genrateInvoice(int invoiceID) {
		System.out.println(invoiceID+"  invoice delivered to customer on "+new Date()+" by HMK");
	}
}
