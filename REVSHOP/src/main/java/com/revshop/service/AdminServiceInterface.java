package com.revshop.service;

import java.util.List;

import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Retailer;

public interface AdminServiceInterface {
	
	// Admin login
	Admin signInService(Admin admin); 
	
	// Admin register
	Admin signUpService(Admin admin); 

	// To get all the buyers
	List<Buyer>viewUsers(String string);
	
	// To get all the retailers 
	List<Retailer>viewRetailer(String string);

	// To block the buyer by using the userId
	boolean blockUser(String userId);

	// To unblock the buyer by using the  userId
	boolean unblockUser(String userId);

	// To block the retailer by using the retaierId
	boolean blockRetailer(String retailerId);

	// To unblock the retailer by using the retailerId
	boolean unblockRetailer(String retailerId);

	// To get the list of the complaints submitted by the users
	List<Complaints> viewComplaints();
	
	//To delete the user account permanently
	boolean deleteUser(String email); 
	
	//To delete the retailer account permanently
	boolean deleteRetailer(String emailaddress); 
	
	
	


}
