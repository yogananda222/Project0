package com.revshop.service;

import java.util.List;

import com.revshop.dao.BuyerDAOInterface;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Product;
import com.revshop.entity.cart;
import com.revshop.entity.order;
import com.revshop.utility.DaoFactory;

public class BuyerService implements BuyerServiceInterface {

	// Handles the process of login and communicates with the dao layer of the buyer
	@Override
    public Buyer signInService(Buyer user) {
        BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
        return buyerDao.signInServiceDAO(user);
    }

	//Handles the process of registration and communicates with the dao layer of the buyer
	
    @Override
    public Buyer signUpService(Buyer user) {
        BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
        return buyerDao.signUpServiceDAO(user);
    }

    // Handles the user blocking process and communicates with the dao layer of buyer
	@Override
	public boolean isUserBlocked(String email) {
		
		 BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
	     return buyerDao.isUserBlockedDAO(email);	}

	// Handles the updating password for the user and communicates with the dao layer of buyer
	
	 @Override
	    public boolean updatePassword(String email, String newPassword) {
	        BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
	        return buyerDao.updatePasswordDAO(email, newPassword);
	    }
	 
	 // Handles the user email existence and communicates with the dao layer of the buyer

	 @Override
	 public boolean isEmailExists(String email) {
	     BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
	     return buyerDao.isEmailExistsDAO(email);
	 }

	@Override
	public List<Product> viewAllProducts() {
		 BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
		return buyerDao.viewAllProductsDAO();
	}

	
	@Override
	public List<cart> addItemsToCart(cart cart) {
		 BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
		 return buyerDao.addItemsToCartDAO(cart);
	}
	
	@Override
	public boolean deleteItemFromCartService(String email, long productId) {
	    BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
	    return buyerDao.deleteItemFromCartDAO(email, productId);
	}


	@Override
	public List<cart> getCartItems(Buyer email) {
		BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
		return buyerDao.getCartItemsDAO(email);
	}

	@Override
	public boolean UpdateEmail(String email, String newEmail) {
		BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
		return buyerDao.updateEmailDAO(email, newEmail);
	}

	@Override
	public boolean createOrder(cart cart) {
		BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
		return buyerDao.createOrderDAO(cart);
	}

	@Override
	public boolean registerComplaint(Complaints complaint) {
		BuyerDAOInterface buyerDao = DaoFactory.createObject("buyer");
		return buyerDao.CreateComplaint(complaint);

	}


	

}
