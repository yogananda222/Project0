package com.revshop.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class order {
	
	private int orderId; 
	
	private Buyer email; 
	
	private cart cartId; 

	private Retailer retailerId; 
	
	private LocalDate orderDate; 
	
	private LocalTime orderTime;
	
	private double orderAmount;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Buyer getEmail() {
		return email;
	}

	public void setEmail(Buyer email) {
		this.email = email;
	}
	
	
	public cart getCartId() {
		return cartId;
	}

	public void setCartId(cart cartId) {
		this.cartId = cartId;
	}

	public Retailer getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Retailer retailerId) {
		this.retailerId = retailerId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public LocalTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	

}
