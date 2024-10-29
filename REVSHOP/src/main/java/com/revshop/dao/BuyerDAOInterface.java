package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Product;
import com.revshop.entity.cart;
import com.revshop.entity.order;

public interface BuyerDAOInterface {
	
	// it will handle the login process of user, returns a user object if successful, otherwise null.
	Buyer signInServiceDAO(Buyer user);
	
	// it will handle the registration process of user, returns a user object if successful, otherwise null.
    Buyer signUpServiceDAO(Buyer user);
    
	// Method to check if a retailer is blocked based on their email address, returns true if blocked, otherwise false.
	boolean isUserBlockedDAO(String email);
	
	// Method to update the password if a user request for forgot password.
	boolean updatePasswordDAO(String email, String newPassword);

	// method to handle the new registrations with existing email id 
	boolean isEmailExistsDAO(String email);

	List<Product> viewAllProductsDAO();

	List<cart> addItemsToCartDAO(cart cart);

	boolean deleteItemFromCartDAO(String email, long productId);

	List<cart> getCartItemsDAO(Buyer email);

	boolean updateEmailDAO(String email, String newEmail);

	boolean createOrderDAO(cart cart);


	boolean CreateComplaint(Complaints complaint);




	

}
