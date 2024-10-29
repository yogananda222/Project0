package com.revshop.service;

import java.util.List;

import com.revshop.dao.BuyerDAOInterface;
import com.revshop.dao.RetailerDAOInterface;
import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.utility.DaoFactory;

public class RetailerService implements RetailerServiceInterface {
	
		// Handles the retailer login process and communicates with the DAO layer to authenticate the retailer.
	 @Override
	    public Retailer signInService(Retailer retailer) {
	        RetailerDAOInterface retailerDAO = DaoFactory.createRetailer("retailer");
	        return retailerDAO.signInDAO(retailer);
	    }
	// Handles the retailer registration process and communicates with the DAO layer to create a new account.
	    @Override
	    public Retailer signUpService(Retailer retailer) {
	        RetailerDAOInterface retailerDAO = DaoFactory.createRetailer("retailer");
	        return retailerDAO.signUpDAO(retailer);
	    }
	    
	    
	  //  This method communicates with the DAO layer to determine the blocked status of a retailer.
	     
		@Override
		public boolean isRetailerBlocked(String emailaddress) {
			RetailerDAOInterface adminDao = DaoFactory.createRetailer("retailer"); 
			return adminDao.isRetailerBlockedDAO(emailaddress);
		}
		
		 @Override
		    public boolean updatePassword(String emailaddress, String newPassword) {
		        RetailerDAOInterface retailerDao = DaoFactory.createRetailer("retailer");
		        return retailerDao.updatePasswordDAO(emailaddress, newPassword);
	     }
		@Override
		public boolean isEmailExists(String emailaddress) {
		     RetailerDAOInterface retailerDao = DaoFactory.createRetailer("retailer");
		     return retailerDao.isEmailExistsDAO(emailaddress);
		}
		@Override
		public boolean addProductForRetailer(Product product) {
			  RetailerDAOInterface retailerDao = DaoFactory.createRetailer("retailer");
			return retailerDao.addProduct(product);
		}
		@Override
		public List<Product> viewProducts(Product product) {
		 RetailerDAOInterface retailerDao = DaoFactory.createRetailer("retailer");
			return retailerDao.viewProduct(product); 
		}
		
	    @Override
	    public boolean updateProduct(Product product) {
	        RetailerDAOInterface retailerDao = DaoFactory.createRetailer("retailer");
	        return retailerDao.updateProductDAO(product);
	    }

	    @Override
	    public boolean deleteProduct(long productId) {
	        RetailerDAOInterface retailerDao = DaoFactory.createRetailer("retailer");
	        return retailerDao.deleteProductDAO(productId);
	    }


}


