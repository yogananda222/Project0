package com.revshop.utility;

import com.revshop.dao.AdminDAO;
import com.revshop.dao.AdminDAOInterface;
import com.revshop.dao.BuyerDAO;
import com.revshop.dao.BuyerDAOInterface;
import com.revshop.dao.RetailerDAO;
import com.revshop.dao.RetailerDAOInterface;


/**
 * DaoFactory is a factory class responsible for creating and returning instances of DAO (Data Access Object) interfaces.
 * It uses a simple factory design pattern to instantiate the appropriate DAO object based on the provided type.
 */
public class DaoFactory {
	
	
//	Creates and returns an instance of BuyerDAOInterface 
	
	public static BuyerDAOInterface createObject(String daoType) {
        if (daoType.equals("buyer")) {
            return new BuyerDAO(); // Return a new instance of BuyerDAO
        }
        
        return null;  //Return null if daoType does not match
    }
	
//	Creates and returns an instance of RetailerDAOInterface 
	public static RetailerDAOInterface createRetailer(String daoType) {
        if (daoType.equals("retailer")) {
            return new RetailerDAO();   // Return a new instance of RetailerDAO
        }
        
        return null;// Return null if daoType does not match
    }
	
//	Creates and returns an instance of AdminDAOInterface 
	public static AdminDAOInterface createAdmin(String daoType) {
        if (daoType.equals("admin")) {
            return new AdminDAO();// Return a new instance of AdminDAO
        }
        
        return null;  // Return null if daoType does not match
    }
	
	

	
	
	
	
	
	

}
