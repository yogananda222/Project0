package com.revshop.daoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revshop.dao.RetailerDAOInterface;
import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.utility.DaoFactory;

public class RetailerDAOTest {
	
	private RetailerDAOInterface retailerDao; 

	@Before
	public void setUp() throws Exception {
		
		retailerDao = DaoFactory.createRetailer("retailer"); 
	}

	@After
	public void tearDown() throws Exception {
		
		retailerDao = null; 
	}

	@Test
	public void testSignInDAO() {
		Retailer retailer = new Retailer();
		retailer.setEmailaddress("pranvai@gmail.com");
		retailer.setPassword("Pranavi@123");
		
		Retailer result = retailerDao.signInDAO(retailer);
		assertNotNull("Retailer should sign in successfully", result);
		assertEquals("Emails should match", "pranvai@gmail.com", result.getEmailaddress());
	}

	@Test
	public void testSignUpDAO() {
		
		Retailer retailer = new Retailer();
		retailer.setBrandName("Pigment Play");
		retailer.setUsername("prakash");
		retailer.setEmailaddress("prakash@gmail.com");
		retailer.setPassword("prakash@123");
		retailer.setResidencePlace("Godavari");

		Retailer result = retailerDao.signUpDAO(retailer);
		assertNotNull("Retailer should sign up successfully", result);
		assertEquals("Usernames should match", "newRetailer", result.getUsername());
	}

	@Test
	public void testIsRetailerBlockedDAO() {
		
		String email = "suresh@gmail.com";
		boolean isBlocked = retailerDao.isRetailerBlockedDAO(email);
		assertTrue("Retailer should be blocked", isBlocked);
	}

	@Test
	public void testUpdatePasswordDAO() {
		
		String email = "pranvai@gmail.com";
		String newPassword = "newPassword123";
		
		boolean isUpdated = retailerDao.updatePasswordDAO(email, newPassword);
		assertTrue("Password should be updated successfully", isUpdated);
	}

	@Test
	public void testIsEmailExistsDAO() {
		
		String existingEmail = "pranvai@gmail.com";
		boolean exists = retailerDao.isEmailExistsDAO(existingEmail);
		assertTrue("Email should exist in the database", exists);
	}

	@Test
	public void testAddProduct() {
		
		Product product = new Product();
		product.setProductId(101);
		product.setProductName("Hustel Face wash");
		product.setProductDescription("Description");
		product.setProductPrice(220);
		product.setImageUrl("images/brands3.png");
		product.setInventory_count(50);
		product.setRetailerId("11");

		boolean isAdded = retailerDao.addProduct(product);
		assertTrue("Product should be added successfully", isAdded);
	}

	@Test
	public void testUpdateProductDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProductDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewProduct() {
		fail("Not yet implemented");
	}

}
