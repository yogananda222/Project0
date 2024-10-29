package com.revshop.entity;

public class cart {
	
	
	private int cartId;
	
	private Buyer email; 
	
	private Product productId; 
	
	private Retailer retailerId; 
	
	private int quantity;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public Buyer getEmail() {
		return email;
	}

	public void setEmail(Buyer email) {
		this.email = email;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Retailer getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Retailer retailerId) {
		this.retailerId = retailerId;
	} 
	
	
	
	
}

