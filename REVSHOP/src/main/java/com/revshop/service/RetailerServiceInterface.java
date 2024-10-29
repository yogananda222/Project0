package com.revshop.service;

import java.util.List;

import com.revshop.entity.Product;
import com.revshop.entity.Retailer;

public interface RetailerServiceInterface {
	
	 // login for retailer
	 Retailer signInService(Retailer retailer);

	 // registration for retailer
	 Retailer signUpService(Retailer retailer);

	 // Method to check the retailer is Blocked or Not.
	 boolean isRetailerBlocked(String emailaddress);
	 
	 // method to update the password
	 boolean updatePassword(String emailaddress, String newPassword);

	 // method to check the email exists or not.
	 boolean isEmailExists(String emailaddress);
	 
	 //method to add the new product by the retailer
	 boolean addProductForRetailer(Product product);
	 
	 List<Product>  viewProducts(Product product);

	   boolean updateProduct(Product product);
	    boolean deleteProduct(long productId);


}
