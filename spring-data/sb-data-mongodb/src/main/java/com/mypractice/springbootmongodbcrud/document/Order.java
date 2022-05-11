/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mypractice.springbootmongodbcrud.document;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;



@Document
public class Order extends AbstractDocument {

	@DBRef
	private Customer customer;
	private Address billingAddress;
	private Address shippingAddress;
	private Set<LineItem> lineItems = new HashSet<LineItem>();


	public Order(Customer customer, Address shippingAddress) {
		this(customer, shippingAddress, null);
	}

	@PersistenceConstructor
	public Order(Customer customer, Address shippingAddress, Address billingAddress) {

		Assert.notNull(customer);
		Assert.notNull(shippingAddress);

		this.customer = customer;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}


	public void add(LineItem lineItem) {
		this.lineItems.add(lineItem);
	}


	public Customer getCustomer() {
		return customer;
	}


	public Address getBillingAddress() {
		return billingAddress != null ? billingAddress : shippingAddress;
	}


	public Address getShippingAddress() {
		return shippingAddress;
	}


	public Set<LineItem> getLineItems() {
		return Collections.unmodifiableSet(lineItems);
	}


	public BigDecimal getTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (LineItem item : lineItems) {
			total = total.add(item.getTotal());
		}

		return total;
	}
}
