package com.revshop.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revshop.dao.RetailerDAO;
import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.service.BuyerServiceInterface;
import com.revshop.service.RetailerService;
import com.revshop.service.RetailerServiceInterface;
import com.revshop.utility.RetailerRequestEmail;
import com.revshop.utility.ServiceFactory;

/**
 * Servlet implementation class RetailerServlet
 */
public class RetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To Retrieve the task type from the request parameter
		 String taskType = request.getParameter("taskType");

		 // taskType for login, to handle the login process
	        if (taskType.equals("login")) {
	        	// Retrieve email and password from the request
	            String emailaddress = request.getParameter("emailaddress");
	            String password = request.getParameter("password");

	         // Creating a new Retailer object and set its email and password
	            Retailer retailer = new Retailer();
	            retailer.setEmailaddress(emailaddress);
	            retailer.setPassword(password);

	         // Creating an instance of RetailerService using the factory method
	            RetailerServiceInterface retailerService = ServiceFactory.createRetailerService("retailer");
	            
	         // Checking if the retailer's account is blocked
				if (retailerService.isRetailerBlocked(emailaddress)) {
					// If the account is blocked, set an error message and forward to the login page
		            request.setAttribute("error", "Your account is blocked. Please contact support team.");
		            RequestDispatcher rd = getServletContext().getRequestDispatcher("/retailerLogin.jsp");
		            rd.forward(request, response);
		            return;// Exit the method after forwarding
		        }
				
				// Attempting to sign in the retailer using the provided credential
	            Retailer r = retailerService.signInService(retailer);

	            
	            if (r != null) {
	            	// If the retailer is authenticated, create a session and forward to the retailer home page
	                HttpSession session = request.getSession(true);
	                session.setAttribute("emailaddress", emailaddress);
	                session.setAttribute("loggedRetailer", r);

	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/retailerHomepage.jsp");
	                rd.forward(request, response);
	            } else {
	            	
	            	// If the retailer is not authenticated, set an error message and forward to the retailer  login page
	                request.setAttribute("error", "Not an approved retailer.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/retailerLogin.jsp");
	                rd.forward(request, response);
	            }
	        }
	        
	        
	        
	     // task type is "register", handle the registration process
	        
	        if (taskType.equals("register")) {
	        	// Retrieve retailer details from the request
	            String retailerId = request.getParameter("retailerId");
	            String brandName = request.getParameter("brandName");
	            String username = request.getParameter("username");
	            String emailaddress = request.getParameter("emailaddress");
	            String password = request.getParameter("password");
	            String residencePlace = request.getParameter("residencePlace");

	        	// Create a new Retailer object and set its properties
	            Retailer retailer = new Retailer();
	            retailer.setRetailerId(retailerId);
	            retailer.setBrandName(brandName);
	            retailer.setUsername(username);
	            retailer.setEmailaddress(emailaddress);
	            retailer.setPassword(password);
	            retailer.setResidencePlace(residencePlace);

	            try {
	            	// Create an instance of RetailerService using the factory method
	                RetailerServiceInterface retailerService = ServiceFactory.createRetailerService("retailer");

	             // Attempting to sign up the retailer
	                Retailer r = retailerService.signUpService(retailer);

	                if (r != null) {
	                	
	                	RetailerRequestEmail.sendConfirmationEmail(emailaddress); 
	                	// If the registration is successful, show a success message and redirect to the home page
	                    response.setContentType("text/html");
	                    response.getWriter().println("<script type='text/javascript'>");
	                    response.getWriter().println("alert('Thank you for your interest in partnering with us!\\n \\nYour request has been sent to REVSHOP.\\n  \\n We will contact you to move forward and approve the request.');");
	                    response.getWriter().println("window.location.href = 'HomePage.jsp';");
	                    response.getWriter().println("</script>");
	                } else {
	                    // Handle the case where the email already exists
	                	response.setContentType("text/html");
	                    response.getWriter().println("<script type='text/javascript'>");
	                    response.getWriter().println("alert('Email already exists in the database.');");
	                    response.getWriter().println("window.location.href = 'retailerRegister.jsp';");
	                    response.getWriter().println("</script>");
	                }
	            } catch (Exception e) {
	                // Handle any other errors
	            	 e.printStackTrace(); // Log the error for debugging purposes
	            	    response.setContentType("text/html");
	            	    response.getWriter().println("<script type='text/javascript'>");
	            	    response.getWriter().println("alert('An unexpected error occurred during registration. Please try again later.');");
	            	    response.getWriter().println("window.location.href = 'retailerRegister.jsp';");
	            	    response.getWriter().println("</script>");
	            }
	        }
	        
	        if ("updatePassword".equals(taskType)) {
	            String emailaddress = request.getParameter("emailaddress");
	            String newPassword = request.getParameter("newPassword");

	            RetailerServiceInterface retailerService = ServiceFactory.createRetailerService("retailer");

	            if (!retailerService.isEmailExists(emailaddress)) {
	                request.setAttribute("error", "This email is not associated with RevShop.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/forgotPassword.jsp");
	                rd.forward(request, response);
	                return;
	            }

	            boolean isUpdated = retailerService.updatePassword(emailaddress, newPassword);

	            if (isUpdated) {
	                response.setContentType("text/html");
	                response.getWriter().println("<script type='text/javascript'>");
	                response.getWriter().println("alert('Password updated successfully!');");
	                response.getWriter().println("window.location.href = 'retailerLogin.jsp';");
	                response.getWriter().println("</script>");
	            } else {
	                request.setAttribute("error", "Error updating password. Please try again.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/forgotPassword.jsp");
	                rd.forward(request, response);
	            }
	        }
	        
	        
	        if("addProduct".equals(taskType)) {
	       
	        	String productName = request.getParameter("productName");
	            String productDescription = request.getParameter("productDescription");
	            double productPrice = Double.parseDouble(request.getParameter("productPrice"));
	            String imageUrl = request.getParameter("imageUrl");
	            long inventoryCount = Long.parseLong(request.getParameter("inventoryCount"));

	            // Retrieves the logged-in retailer from session
	            HttpSession session = request.getSession(false);
	            if (session == null) {
	                response.sendRedirect("retailerLogin.jsp");
	                return;
	            }

	            Retailer retailer = (Retailer) session.getAttribute("loggedRetailer");
	            if (retailer == null) {
	                response.sendRedirect("retailerLogin.jsp");
	                return;
	            }

	            // Creating a Product object and set its properties
	            Product product = new Product();
	            product.setProductName(productName);
	            product.setProductDescription(productDescription);
	            product.setProductPrice((long) productPrice);
	            product.setImageUrl(imageUrl);
	            product.setInventory_count(inventoryCount);
	            product.setRetailerId(retailer.getRetailerId()); // Set retailer ID

	            // Calling the RetailerService to add the product
	            RetailerServiceInterface retailerService = ServiceFactory.createRetailerService("retailer");

	            boolean isAdded = retailerService.addProductForRetailer(product);

	            if (isAdded) {
	                response.setContentType("text/html");
	                response.getWriter().println("<script type='text/javascript'>");
	                response.getWriter().println("alert('Product added successfully!');");
	                response.getWriter().println("window.location.href = 'retailerHomepage.jsp';");
	                response.getWriter().println("</script>");
	            } else {
	                request.setAttribute("error", "Error adding product. Please try again.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/addProduct.jsp");
	                rd.forward(request, response);
	            }
	        }
	        
	        
	        if ("updateProduct".equals(taskType)) {
	            long productId = Long.parseLong(request.getParameter("productId"));
	            String productName = request.getParameter("productName");
	            String productDescription = request.getParameter("productDescription");
	            long productPrice = Long.parseLong(request.getParameter("productPrice"));
	            String imageUrl = request.getParameter("imageUrl");
	            long inventoryCount = Long.parseLong(request.getParameter("inventoryCount"));

	            Product product = new Product();
	            product.setProductId(productId);
	            product.setProductName(productName);
	            product.setProductDescription(productDescription);
	            product.setProductPrice(productPrice);
	            product.setImageUrl(imageUrl);
	            product.setInventory_count(inventoryCount);

	            RetailerServiceInterface retailerService = ServiceFactory.createRetailerService("retailer");

	            boolean isUpdated = retailerService.updateProduct(product);

	            if (isUpdated) {
	                response.setContentType("text/html");
	                response.getWriter().println("<script type='text/javascript'>");
	                response.getWriter().println("alert('Product updated successfully!');");
	                response.getWriter().println("window.location.href = 'retailerHomepage.jsp';");
	                response.getWriter().println("</script>");
	            } else {
	                request.setAttribute("error", "Error updating product. Please try again.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateProduct.jsp");
	                rd.forward(request, response);
	            }
	        }

	        if ("deleteProduct".equals(taskType)) {
	            long productId = Long.parseLong(request.getParameter("productId"));

	            RetailerServiceInterface retailerService = ServiceFactory.createRetailerService("retailer");

	            boolean isDeleted = retailerService.deleteProduct(productId);

	            if (isDeleted) {
	                response.setContentType("text/html");
	                response.getWriter().println("<script type='text/javascript'>");
	                response.getWriter().println("alert('Product deleted successfully!');");
	                response.getWriter().println("window.location.href = 'retailerHomepage.jsp';");
	                response.getWriter().println("</script>");
	            } else {
	                request.setAttribute("error", "Error deleting product. Please try again.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewProducts.jsp");
	                rd.forward(request, response);
	            }
	        }
	        
	        if("logout".equals(taskType)) {
	        	
	        	 HttpSession session = request.getSession(false);
	             if (session != null) {
	                 session.invalidate();
	             }
	             
	             response.sendRedirect("retailerLogin.jsp"); 
	        }

	        
	        
	        
	    }
}