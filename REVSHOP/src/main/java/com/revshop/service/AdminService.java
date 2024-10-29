package com.revshop.service;

import java.util.List;

import com.revshop.dao.AdminDAOInterface;
import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Retailer;
import com.revshop.utility.DaoFactory;

public class AdminService implements AdminServiceInterface {

	@Override
	public Admin signInService(Admin admin) {
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
		return adminDao.signInDAO(admin);
	}

	@Override
	public Admin signUpService(Admin admin) {
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin"); 
		return adminDao.signUpDAO(admin);
	}
	
	@Override
	public List<Buyer> viewUsers(String userType) {
		// TODO Auto-generated method stub
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
		return adminDao.viewUsersDao(userType);
	}

	@Override
	public List<Retailer> viewRetailer(String userType) {
		// TODO Auto-generated method stub
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
		return adminDao.viewRetailerDao(userType);
	}
	
	@Override
	public boolean blockUser(String userId) {
	    AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
	    return adminDao.blockUser(userId);
	}

	@Override
	public boolean unblockUser(String userId) {
	    AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
	    return adminDao.unblockUser(userId);
	}
	
	@Override
	public boolean blockRetailer(String retailerId) {
	    AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
	    return adminDao.blockRetailer(retailerId);
	}

	@Override
	public boolean unblockRetailer(String retailerId) {
	    AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
	    return adminDao.unblockRetailer(retailerId);
	}
	
	@Override
	public List<Complaints> viewComplaints() {
		// TODO Auto-generated method stub
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
		return adminDao.viewComplaintsDao();
	}

	@Override
	public boolean deleteUser(String email) {
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
			return adminDao.deleteUserDAO(email);
		}
	
	@Override
	public boolean deleteRetailer(String emailaddress) {
		AdminDAOInterface adminDao = DaoFactory.createAdmin("admin");
		return adminDao.deleteRetailerDAO(emailaddress);
		
	}

}
