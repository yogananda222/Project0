package com.revshop.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revshop.dao.BuyerDAOInterface;
import com.revshop.entity.Buyer;
import com.revshop.entity.Product;
import com.revshop.utility.DaoFactory;

public class BuyerDAOTest {
	
	 private BuyerDAOInterface buyerDAO;

	@Before
	public void setUp() throws Exception {
		
		  buyerDAO = DaoFactory.createObject("buyer");
	}

	@After
	public void tearDown() throws Exception {
		
		buyerDAO = null;
	}

	@Test
	public void testSignInServiceDAO() {
		
		 Buyer testBuyer = new Buyer();
	     testBuyer.setEmail("devendra222@gmail.com");
	     testBuyer.setPassword("Deva@123");
	        
	     Buyer result = buyerDAO.signInServiceDAO(testBuyer);
	     
	     assertNotNull("User should be signed in successfully", result);
	     assertEquals("Emails should match", "bhagya@gmail.com", result.getEmail());
	}

	@Test
	public void testSignUpServiceDAO() {
        Buyer newBuyer = new Buyer();
        newBuyer.setName("Bhagya Lakshmi");
        newBuyer.setEmail("bhagyaLakshmi@gmail.com");
        newBuyer.setPassword("BhagyaLakshmi@123");
        newBuyer.setContact("9494075192");
        newBuyer.setResidence("Anantapur");
	}

	@Test
	public void testIsUserBlockedDAO() {
		
		  String email = "yoganandanaidu222@gmail.com";
		  
		  boolean isBlocked = buyerDAO.isUserBlockedDAO(email);

		  assertFalse("User is not  blocked", isBlocked);
		  
		  assertTrue("User is blocked", isBlocked);
	}

	@Test
	public void testUpdatePasswordDAO() {
		
        String email = "shyamsundhar@gmail.com";
        String newPassword = "UpdatedTest@123";
        
        boolean isUpdated = buyerDAO.updatePasswordDAO(email, newPassword);
        
        assertTrue("Password updated successfully", isUpdated);
        

	}

	@Test
	public void testIsEmailExistsDAO() {
		
		String existingEmail = "shyamsundhar@gmail.com";
		
		boolean exists = buyerDAO.isEmailExistsDAO(existingEmail);
		
		assertTrue("Email exist in the database", exists);
		
	}
		

	@Test
	public void testViewAllProductsDAO() {
		
		 List<Product> products = buyerDAO.viewAllProductsDAO();
		 
		 assertNotNull("Product list should not be null", products);
	     assertTrue("Product list should contain products", products.size() > 0);
	}

	@Test
	public void testAddItemsToCartDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaceOrderDao() {
		fail("Not yet implemented");
	}

}
