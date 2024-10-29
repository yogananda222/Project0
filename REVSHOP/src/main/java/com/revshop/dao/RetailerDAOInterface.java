package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Product;
import com.revshop.entity.Retailer;

public interface RetailerDAOInterface {
	
	
	// Method to handle retailer login, returns a Retailer object if successful, otherwise null.
	Retailer signInDAO(Retailer retailer);

	// Method to handle retailer register, returns the created Retailer object if successful, otherwise null.
	Retailer signUpDAO(Retailer retailer);

	// Method to check if a retailer is blocked based on their email address, returns true if blocked, otherwise false.
	boolean isRetailerBlockedDAO(String emailaddress);

	boolean updatePasswordDAO(String emailaddress, String newPassword);

	boolean isEmailExistsDAO(String emailaddress);

	boolean addProduct(Product product);

	boolean deleteProductDAO(long productId);

	boolean updateProductDAO(Product product);

	List<Product> viewProduct(Product product);
	
	
	
	



}
