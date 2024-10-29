package com.revshop.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revshop.dao.AdminDAOInterface;
import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Retailer;
import com.revshop.utility.DaoFactory;

public class AdminDAOTest {
	
	private AdminDAOInterface adminDao ; 

	@Before
	public void setUp() throws Exception {
		
		adminDao = DaoFactory.createAdmin("admin"); 
	}

	@After
	public void tearDown() throws Exception {
		
		adminDao = null; 
	}

	@Test
	public void testSignInDAO() {
		
	      Admin admin = new Admin();
	      admin.setEmail("bhagya@gmail.com");
	      admin.setPassword("amma@123");
	        
	      Admin result = adminDao.signInDAO(admin);
	      
	      assertNotNull("Admin should not be null on successful sign-in", result);
	}

	@Test
	public void testSignUpDAO() {
      	      
	        Admin admin = new Admin();
	        admin.setUsername("YoganadaNaid");
	        admin.setPassword("Yogananda@123");
	        admin.setEmail("yoganandanaidu14382@gmail.com.com");
	        
	        Admin result = adminDao.signUpDAO(admin);
	        assertNotNull("Admin should not be null on successful sign-up", result);
	        assertEquals("Username should match", "testAdmin", result.getUsername());
	}

	@Test
	public void testViewUsersDao() {
		
	    List<Buyer> buyers = adminDao.viewUsersDao("buyer");
        assertNotNull("Buyer list should not be null", buyers);
        assertFalse("Buyer list should not be empty", buyers.isEmpty());

	}

	@Test
	public void testViewRetailerDao() {
		
		   List<Retailer> retailers = adminDao.viewRetailerDao("retailer");
	        assertNotNull("Retailer list should not be null", retailers);
	        assertFalse("Retailer list should not be empty", retailers.isEmpty());
	}

	@Test
	public void testGetPendingRetailerRequests() {

		 List<Retailer> pendingRetailers = adminDao.getPendingRetailerRequests();
	     assertNotNull("Pending retailer list should not be null", pendingRetailers);
	}

	@Test
	public void testApproveRetailer() {
		fail("Not yet implemented");
	}

	@Test
	public void testBlockUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnblockUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBlockRetailer() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnblockRetailer() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewComplaintsDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRetailerDAO() {
		fail("Not yet implemented");
	}

}
