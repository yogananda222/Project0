package com.revshop.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revshop.dao.AdminDAOInterface;
import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Retailer;
import com.revshop.service.AdminService;
import com.revshop.service.BuyerService;
import com.revshop.utility.DaoFactory;

public class AdminServiceTest {
	
	@InjectMocks
    private AdminDAOInterface adminDao;
	
	@Mock
    private AdminService adminService;
	
	private AutoCloseable closeable;

	@Before
	public void setUp() throws Exception {
		
		 closeable = MockitoAnnotations.openMocks(this);
	     adminDao = DaoFactory.createAdmin("admin");
	     adminService = new AdminService();
	}

	@After
	public void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	public void testSignInService() {
		
        Admin admin = new Admin();
        when(adminDao.signInDAO(admin)).thenReturn(admin);
        
        Admin result = adminService.signInService(admin);
        assertEquals(admin, result);
        
        verify(adminDao).signInDAO(admin);
	}

	@Test
	public void testSignUpService() {
		
		  Admin admin = new Admin();
	      when(adminDao.signUpDAO(admin)).thenReturn(admin);
	        
	      Admin result = adminService.signUpService(admin);
	      assertEquals(admin, result);
	        
	      verify(adminDao).signUpDAO(admin);
	}

	@Test
	public void testViewUsers() {
		
        List<Buyer> buyers = Arrays.asList(new Buyer(), new Buyer());
        when(adminDao.viewUsersDao("buyer")).thenReturn(buyers);
        
        List<Buyer> result = adminService.viewUsers("buyer");
        assertEquals(buyers, result);
        
        verify(adminDao).viewUsersDao("buyer");
	}

	@Test
	public void testViewRetailer() {
		
		List<Retailer> retailers = Arrays.asList(new Retailer(), new Retailer());
        when(adminDao.viewRetailerDao("retailer")).thenReturn(retailers);
        
        List<Retailer> result = adminService.viewRetailer("retailer");
        assertEquals(retailers, result);
        
        verify(adminDao).viewRetailerDao("retailer");
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
	public void testViewComplaints() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRetailer() {
		fail("Not yet implemented");
	}

}
