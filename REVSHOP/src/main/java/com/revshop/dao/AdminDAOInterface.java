package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Retailer;

public interface AdminDAOInterface {

	Admin signInDAO(Admin admin);
	
	Admin signUpDAO(Admin admin);

	List<Buyer> viewUsersDao(String userType);

	List<Retailer> viewRetailerDao(String userType);

	List<Retailer> getPendingRetailerRequests();

	boolean approveRetailer(String emailaddress);

	boolean unblockRetailer(String retailerId);

	boolean blockRetailer(String retailerId);

	boolean unblockUser(String userId);

	boolean blockUser(String userId);

	List<Complaints> viewComplaintsDao();

	boolean deleteUserDAO(String email);

	boolean deleteRetailerDAO(String emailaddress);







}
