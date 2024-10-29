package com.revshop.service;

import java.util.List;
import com.revshop.entity.Product;
import com.revshop.entity.cart;
import com.revshop.entity.order;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;

public interface BuyerServiceInterface {
	
	// Handles the user login 
	Buyer signUpService(Buyer user);
	
	// Handles the user registration
	Buyer signInService(Buyer user); 
	
	// Used to check the  user is blocked or not
	boolean isUserBlocked(String email);
	
	// used to check the user email exists or not
	 boolean isEmailExists(String email);
	 
	// if user request for forgot password. this method will help to change the password
	boolean updatePassword(String email, String newPassword); 
	
	// to change the user email 
	boolean UpdateEmail(String email,String newEmail); 

	
	// to retrieve the all the product in the user interface
	List<Product> viewAllProducts();
	
	// to add the items in to the cart
	List<cart> addItemsToCart(cart cart);
	
	// to remove the items from the cart
	boolean deleteItemFromCartService(String email, long productId);
	
	List<cart> getCartItems(Buyer email); 
	
	boolean createOrder(cart cart); 
	
	boolean registerComplaint(Complaints complaint);
	
	
	


	
}
