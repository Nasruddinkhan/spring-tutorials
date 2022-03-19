package com.mypractice.beans;

import java.util.Arrays;
import java.util.Random;

public class InvoiceSystem {
	private AmazonInvoice amazonInvoice;
	private FlipCartInvoice cartInvoice;
	
	public void setAmazonInvoice(AmazonInvoice amazonInvoice) {
		System.out.println("InvoiceSystem.setAmazonInvoice()");
		this.amazonInvoice = amazonInvoice;
	}
	
	public void setCartInvoice(FlipCartInvoice cartInvoice) {
		System.out.println("InvoiceSystem.setCartInvoice()");
		this.cartInvoice = cartInvoice;
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
		cartInvoice.genrateInvoice(i);
		amazonInvoice.genrateInvoice(i);
		return Arrays.toString(item)+" Bill Amount:: "+billAmt;
	}
	
}
