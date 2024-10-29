package com.revshop.utility;

import com.revshop.service.AdminService;
import com.revshop.service.AdminServiceInterface;
import com.revshop.service.BuyerService;
import com.revshop.service.BuyerServiceInterface;
import com.revshop.service.RetailerService;
import com.revshop.service.RetailerServiceInterface;

/**
 * ServiceFactory is a factory class responsible for creating and returning instances of service interfaces.
 * It follows the factory design pattern to instantiate the appropriate service object based on the provided type.
 */
public class ServiceFactory {
	
	
	//Creates and returns an instance of BuyerServiceInterface
	public static BuyerServiceInterface createObject(String serviceType) {
        if (serviceType.equals("buyer")) {
            return new BuyerService(); // Return a new instance of BuyerService
        }
        return null; // Return null if serviceType does not match
    }
	
	
	//Creates and returns an instance of RetailerServiceInterface
	public static RetailerServiceInterface createRetailerService(String serviceType) {
		if(serviceType.equals("retailer")) {
			return new RetailerService();// Return a new instance of RetailerService
	}
		return null; // Return null if serviceType does not match
    }
	
	
	//Creates and returns an instance of AdminServiceInterface
	public static AdminServiceInterface createAdminService(String serviceType) {
		if(serviceType.equals("admin")) {
			return new AdminService(); // Return a new instance of AdminService
	} 
		return null; // Return null if serviceType does not match
    }


	
}
