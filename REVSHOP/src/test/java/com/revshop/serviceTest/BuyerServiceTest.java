package com.revshop.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
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

import com.revshop.dao.BuyerDAOInterface;
import com.revshop.entity.Buyer;
import com.revshop.entity.Product;
import com.revshop.service.BuyerService;
import com.revshop.utility.DaoFactory;

public class BuyerServiceTest {
	
    @InjectMocks
    private BuyerService buyerService;
    
    @Mock
    private BuyerDAOInterface buyerDao;
    
    private AutoCloseable closeable;


	@Before
	public void setUp() throws Exception {
		
        closeable = MockitoAnnotations.openMocks(this);
        buyerDao = DaoFactory.createObject("buyer");
        buyerService = new BuyerService();
	}

	@After
	public void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	public void testSignInService() {
		
		Buyer mockBuyer = new Buyer();
        mockBuyer.setEmail("devendra222@gmail.com");
        mockBuyer.setPassword("Deva@123");

        when(buyerDao.signInServiceDAO(mockBuyer)).thenReturn(mockBuyer);

        Buyer result = buyerService.signInService(mockBuyer);

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(buyerDao, times(1)).signInServiceDAO(mockBuyer);
	}

	@Test
	public void testSignUpService() {
        Buyer mockBuyer = new Buyer();
        mockBuyer.setEmail("Bhagya");
        mockBuyer.setPassword("Bhagya@123");
        mockBuyer.setEmail("bhagyaLakshmi@gmail.com");
        mockBuyer.setContact("9494075192");
        mockBuyer.setResidence("Anantapur");

        when(buyerDao.signUpServiceDAO(mockBuyer)).thenReturn(mockBuyer);

        Buyer result = buyerService.signUpService(mockBuyer);

        assertNotNull(result);
        assertEquals("new@example.com", result.getEmail());
        verify(buyerDao, times(1)).signUpServiceDAO(mockBuyer);
	}

	@Test
	public void testIsUserBlocked() {
		
        String email = "yoganandanaidu222@gmail.com";

        when(buyerDao.isUserBlockedDAO(email)).thenReturn(true);

        boolean isBlocked = buyerService.isUserBlocked(email);

        assertTrue(isBlocked);
        verify(buyerDao, times(1)).isUserBlockedDAO(email);
	}

	@Test
	public void testUpdatePassword() {
		
        String email = "shyamsundhar@gmail.com";
        String newPassword = "newPassword123";

        when(buyerDao.updatePasswordDAO(email, newPassword)).thenReturn(true);

        boolean isUpdated = buyerService.updatePassword(email, newPassword);

        assertTrue(isUpdated);
        verify(buyerDao, times(1)).updatePasswordDAO(email, newPassword);
	}

	@Test
	public void testIsEmailExists() {
		
        String email = "shyamsundhar@gmail.com";

        when(buyerDao.isEmailExistsDAO(email)).thenReturn(true);

        boolean exists = buyerService.isEmailExists(email);

        assertTrue(exists);
        verify(buyerDao, times(1)).isEmailExistsDAO(email);
	}

	@Test
	public void testViewAllProducts() {
		
	       Product product1 = new Product();
	        product1.setProductId(1);
	        product1.setProductName("Product1");

	        Product product2 = new Product();
	        product2.setProductId(2);
	        product2.setProductName("Product2");

	        List<Product> products = Arrays.asList(product1, product2);

	        when(buyerDao.viewAllProductsDAO()).thenReturn(products);

	        List<Product> result = buyerService.viewAllProducts();

	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(buyerDao, times(1)).viewAllProductsDAO();
	}

	@Test
	public void testAddItemsToCart() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaceOrder() {
		fail("Not yet implemented");
	}

}
