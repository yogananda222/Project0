package com.revshop.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revshop.dao.RetailerDAOInterface;
import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.service.AdminService;
import com.revshop.service.RetailerService;
import com.revshop.utility.DaoFactory;

public class RetailerServiceTest {
	
	
	@InjectMocks
    private RetailerDAOInterface mockRetailerDao;
    
    @Mock
    private RetailerService retailerService;
    
    private AutoCloseable closeable;


	@Before
	public void setUp() throws Exception {
		
		 closeable = MockitoAnnotations.openMocks(this);
		 mockRetailerDao = DaoFactory.createRetailer("retailer");
		 retailerService = new RetailerService();
		
	}

	@After
	public void tearDown() throws Exception {
		
		closeable.close();
	}

	@Test
	public void testSignInService() {
		
		Retailer retailer = new Retailer();
        retailer.setEmailaddress("test@example.com");
        when(mockRetailerDao.signInDAO(retailer)).thenReturn(retailer);

        Retailer result = retailerService.signInService(retailer);
        assertEquals(retailer, result);

        verify(mockRetailerDao).signInDAO(retailer);
	}

	@Test
	public void testSignUpService() {
		
		 Retailer retailer = new Retailer();
		 retailer.setEmailaddress("new@example.com");
	     when(mockRetailerDao.signUpDAO(retailer)).thenReturn(retailer);

	     Retailer result = retailerService.signUpService(retailer);
	     assertEquals(retailer, result);

	     verify(mockRetailerDao).signUpDAO(retailer);
	}

	@Test
	public void testIsRetailerBlocked() {
		
        String email = "blocked@example.com";
        when(mockRetailerDao.isRetailerBlockedDAO(email)).thenReturn(true);

        boolean result = retailerService.isRetailerBlocked(email);
        assertTrue(result);

        verify(mockRetailerDao).isRetailerBlockedDAO(email);
	}

	@Test
	public void testUpdatePassword() {
		
		String email = "update@example.com";
        String newPassword = "newPassword123";
        when(mockRetailerDao.updatePasswordDAO(email, newPassword)).thenReturn(true);

        boolean result = retailerService.updatePassword(email, newPassword);
        assertTrue(result);

        verify(mockRetailerDao).updatePasswordDAO(email, newPassword);
	}

	@Test
	public void testIsEmailExists() {
		
		 String email = "exists@example.com";
		 when(mockRetailerDao.isEmailExistsDAO(email)).thenReturn(true);

	     boolean result = retailerService.isEmailExists(email);
	     assertTrue(result);

	     verify(mockRetailerDao).isEmailExistsDAO(email);
	}

	@Test
	public void testAddProductForRetailer() {
		
		   	Product product = new Product();
	        when(mockRetailerDao.addProduct(product)).thenReturn(true);

	        boolean result = retailerService.addProductForRetailer(product);
	        assertTrue(result);

	        verify(mockRetailerDao).addProduct(product);
	}

	@Test
	public void testViewProducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

}
