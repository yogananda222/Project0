package com.revshop.entity;

import java.time.LocalDateTime;

public class Product {
	
	
	private long productId; 
	
	private String productName; 
	
	private long productPrice; 
	
	private String productDescription; 
	
	private String imageUrl;
	
	private long inventory_count; 
	
	private String retailerId; 
	




	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getInventory_count() {
		return inventory_count;
	}

	public void setInventory_count(long inventory_count) {
		this.inventory_count = inventory_count;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}



	



}
