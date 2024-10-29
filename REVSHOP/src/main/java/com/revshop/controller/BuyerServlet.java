package com.revshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.entity.cart;
import com.revshop.entity.order;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.service.AdminServiceInterface;
import com.revshop.service.BuyerService;
import com.revshop.service.BuyerServiceInterface;
import com.revshop.utility.ServiceFactory;

/**
 * Servlet implementation class BuyerServlet
 */
public class BuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String taskType = request.getParameter("taskType");
		
		  if ("login".equals(taskType)) {
		        String email = request.getParameter("email");
		        String password = request.getParameter("password");

		        // Creating object of the buyer
		        Buyer user = new Buyer();
		        user.setEmail(email);
		        user.setPassword(password);


		        BuyerServiceInterface userService = ServiceFactory.createObject("buyer");

		        if (userService.isUserBlocked(email)) {
		            request.setAttribute("error", "<b>Your account is blocked. Please contact support team </b>.");
		            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		            rd.forward(request, response);
		            return;
		        }

		        Buyer b = userService.signInService(user);

		        if (b != null) {
		            HttpSession session = request.getSession(true);
		            session.setAttribute("userId", b.getUserId()); 
		            session.setAttribute("email", b.getEmail());
		            session.setAttribute("password", b.getPassword());
		            session.setAttribute("name", b.getName());
		            session.setAttribute("contact", b.getContact());
		            session.setAttribute("residence", b.getResidence());

		            // Debug statements
		            System.out.println("Setting session attributes:");
		            System.out.println("userId:"+b.getUserId());
		            System.out.println("Name: " + b.getName());
		            System.out.println("Email: " + b.getEmail());
		            System.out.println("Contact: " + b.getContact());
		            System.out.println("Password: " + b.getPassword());
		            System.out.println("Residence: " + b.getResidence());

		            RequestDispatcher rd = getServletContext().getRequestDispatcher("/buyerHomepage.jsp");
		            rd.forward(request, response);
		        } else {
		            request.setAttribute("error", "Invalid email or password");
		            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		            rd.forward(request, response);
		        }
		    }

		
		if(taskType.equals("register")) {
			String userId = request.getParameter("userId"); 
			String name = request.getParameter("name");
			String email = request.getParameter("email"); 
			String password = request.getParameter("password"); 
			String contact = request.getParameter("contact"); 
			String residence = request.getParameter("residence"); 
			
			Buyer user = new Buyer(); 
			user.setUserId(userId);
			user.setName(name); 
			user.setEmail(email); 
			user.setPassword(password); 
			user.setContact(contact); 
			user.setResidence(residence); 
			
			try {
			BuyerServiceInterface userService = ServiceFactory.createObject("buyer"); 
			
			Buyer b = userService.signUpService(user); 
			
			if (b != null) {
				
				response.setContentType("text/html");
				response.getWriter().println("<script type='text/javascript'>");
				response.getWriter().println("alert('Registration successful! Please log in.');");
				response.getWriter().println("window.location.href = 'login.jsp';");
				response.getWriter().println("</script>");
			} else {
				
				response.setContentType("text/html");
                response.getWriter().println("<script type='text/javascript'>");
                response.getWriter().println("alert('Email already exists in the database.\\n Click OK to Login now :)');");
                response.getWriter().println("window.location.href = 'login.jsp';");
                response.getWriter().println("</script>");
				}
			}catch(Exception e) {
				
				e.printStackTrace(); // Log the error for debugging purposes
        	    response.setContentType("text/html");
        	    response.getWriter().println("<script type='text/javascript'>");
        	    response.getWriter().println("alert('An unexpected error occurred during registration. Please try again later.');");
        	    response.getWriter().println("window.location.href = 'retailerRegister.jsp';");
        	    response.getWriter().println("</script>");
			}
		}
			
		 if ("updatePassword".equals(taskType)) {
	            String email = request.getParameter("email");
	            String newPassword = request.getParameter("newPassword");

	            BuyerServiceInterface userService = ServiceFactory.createObject("buyer");
	            
	            if (!userService.isEmailExists(email)) {
	                request.setAttribute("error", "This email is not associated with RevShop.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/forgotPassword.jsp");
	                rd.forward(request, response);
	                return;
	            }

	            boolean isUpdated = userService.updatePassword(email, newPassword);

	            if (isUpdated) {
	                response.setContentType("text/html");
	                response.getWriter().println("<script type='text/javascript'>");
	                response.getWriter().println("alert('Password updated successfully!');");
	                response.getWriter().println("window.location.href = 'login.jsp';");
	                response.getWriter().println("</script>");
	            } else {
	                request.setAttribute("error", "Error updating password. Please try again.");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/forgotPassword.jsp");
	                rd.forward(request, response);
	            }
	        }
		 
	    BuyerServiceInterface buyerService = ServiceFactory.createObject("buyer");

		 if ("viewAllProducts".equals(taskType)) {
			 
			 Product product = new Product(); 
			 
			 String products = "product"; 
			 
			 List<Product> list_of_Products = buyerService.viewAllProducts();
			 
			 System.out.println(list_of_Products.size());
			 
			 request.setAttribute("products", list_of_Products);
			 
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductsListForBuyer.jsp");
			    rd.forward(request, response);
			 
			}

		 
	        if ("addToCart".equals(taskType)) {
	            HttpSession session = request.getSession(false);
	            if (session == null || session.getAttribute("email") == null) {
	                response.sendRedirect("login.jsp");
	                return;
	            }

	            String buyerEmail = (String) session.getAttribute("email");
	            long productId = Long.parseLong(request.getParameter("productId"));
	            int quantity = Integer.parseInt(request.getParameter("quantity"));

	            // Create Buyer object
	            Buyer buyer = new Buyer();
	            buyer.setEmail(buyerEmail);

	            // Create Product object
	            Product product = new Product();
	            product.setProductId(productId);

	            // Create Cart object and set necessary details
	            cart cartItem = new cart();
	            cartItem.setEmail(buyer);
	            cartItem.setProductId(product);
	            cartItem.setQuantity(quantity);

	            // Call service to add item to cart
	            BuyerServiceInterface BuyerService = ServiceFactory.createObject("buyer");
	            List<cart> cartItems = BuyerService.addItemsToCart(cartItem);

	            // Debugging output
	            System.out.println("Cart size is: " + cartItems.size());

	            // Set cart items as request attribute and forward to view-cart.jsp
	            request.setAttribute("cartItems", cartItems);
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view-cart.jsp");
	            rd.forward(request, response);
	        }
	    
	    

		 if ("deleteFromCart".equals(taskType)) {
			    HttpSession session = request.getSession(false);
			    if (session == null || session.getAttribute("email") == null) {
			        response.sendRedirect("login.jsp");
			        return;
			    }

			    String buyerEmail = (String) session.getAttribute("email");
			    long productId = Long.parseLong(request.getParameter("productId"));

			    BuyerServiceInterface BuyerService = ServiceFactory.createObject("buyer");
			    boolean isDeleted = BuyerService.deleteItemFromCartService(buyerEmail, productId);

			    if (isDeleted) {
			        // Set a success message
			        request.setAttribute("successMessage", "Item successfully removed from cart.");
			    } else {
			        // Set an error message
			        request.setAttribute("errorMessage", "Failed to delete item from cart.");
			    }
			    
			    // Forward to the cart page with messages
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/view-cart.jsp");
			    rd.forward(request, response);
			}
		 
		 
		 if ("getCartItems".equals(taskType)) {
			    HttpSession session = request.getSession(false);
			    if (session != null && session.getAttribute("email") != null) {
			        String email = (String) session.getAttribute("email");

			        BuyerServiceInterface BuyerService = ServiceFactory.createObject("buyer");
			        Buyer buyer = new Buyer();
			        buyer.setEmail(email);
			        
			        List<cart> cartItems = BuyerService.getCartItems(buyer);

			        if (cartItems != null && !cartItems.isEmpty()) {
			            request.setAttribute("cartItems", cartItems);
			            RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
			            rd.forward(request, response);
			        } else {
			            request.setAttribute("message", "Your cart is empty.");
			            RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
			            rd.forward(request, response);
			        }
			    } else {
			        response.sendRedirect("login.jsp");
			    }
			}


		 
	        
	        if("logout".equals(taskType)) {
	        	
	        	 HttpSession session = request.getSession(false);
	             if (session != null) {
	                 session.invalidate();
	             }
	             response.sendRedirect("login.jsp"); 
	        }
	        
	        
			 if ("updateEmail".equals(taskType)) {
		            String email = request.getParameter("email");
		            String newEmail = request.getParameter("newEmail");

		            BuyerServiceInterface userService = ServiceFactory.createObject("buyer");
		            
		            if (!userService.isEmailExists(email)) {
		                request.setAttribute("error", "This email is not associated with RevShop.");
		                RequestDispatcher rd = getServletContext().getRequestDispatcher("/User-EmailUpdate.jsp");
		                rd.forward(request, response);
		                return;
		            }

		            boolean isUpdated = userService.UpdateEmail(email, newEmail);

		            if (isUpdated) {
		                response.setContentType("text/html");
		                response.getWriter().println("<script type='text/javascript'>");
		                response.getWriter().println("alert('Email updated successfully!');");
		                response.getWriter().println("window.location.href = 'login.jsp';");
		                response.getWriter().println("</script>");
		            } else {
		                request.setAttribute("error", "Error updating email. Please try again.");
		                RequestDispatcher rd = getServletContext().getRequestDispatcher("/User-EmailUpdate.jsp");
		                rd.forward(request, response);
		            }
		        }
			 
			 
			 if ("createOrder".equals(taskType)) {

				    HttpSession session = request.getSession(false);
				    if (session == null || session.getAttribute("email") == null) {
				        response.sendRedirect("login.jsp");
				        return;
				    }

				    String buyerEmail = (String) session.getAttribute("email");

				    // Handle possible null parameters
				    String cartIdParam = request.getParameter("cartId");
				    String productIdParam = request.getParameter("productId");
				    String retailerIdParam = request.getParameter("retailerId");

				    if (cartIdParam == null || productIdParam == null || retailerIdParam == null) {
				        // Handle missing parameters
				        session.setAttribute("orderErrorMessage", "Missing required parameters.");
				        response.sendRedirect("orderFailure.jsp");
				        return;
				    }

				    int cartId;
				    long productId;
				    int retailerId;

				    try {
				        cartId = Integer.parseInt(cartIdParam);
				        productId = Long.parseLong(productIdParam);
				        retailerId = Integer.parseInt(retailerIdParam); // Convert retailerId to int
				    } catch (NumberFormatException e) {
				        // Handle parsing errors
				        session.setAttribute("orderErrorMessage", "Invalid parameter format.");
				        response.sendRedirect("orderFailure.jsp");
				        return;
				    }

				    Buyer buyer = new Buyer();
				    buyer.setEmail(buyerEmail);

				    Retailer retailer = new Retailer(); 
				    retailer.setRetailerId(String.valueOf(retailerId)); // Convert int to String

				    cart cartItem = new cart();
				    cartItem.setEmail(buyer);
				    cartItem.setCartId(cartId);
				    cartItem.getProductId().setProductId(productId);
				    cartItem.setRetailerId(retailer); 

				    BuyerServiceInterface userService = ServiceFactory.createObject("buyer");

				    boolean isOrderCreated = userService.createOrder(cartItem);

				    if (isOrderCreated) {
				        session.setAttribute("orderSuccessMessage", "Order has been successfully placed.");
				        response.sendRedirect("OrderSuccess.jsp");
				    } else {
				        session.setAttribute("orderErrorMessage", "Failed to create order. Please try again.");
				        response.sendRedirect("OrderFailure.jsp");
				    }

				}
			 
			 
			 
			    if ("registerComplaint".equals(taskType)) {
		            String complaintId = request.getParameter("complaintId");
		            String name = request.getParameter("name");
		            String email = request.getParameter("email");
		            String contact = request.getParameter("contact");
		            String complaintSubject = request.getParameter("complaintSubject");
		            String complaintBody = request.getParameter("complaintBody");

		            Complaints complaint = new Complaints();
		            complaint.setComplaintId(complaintId);
		            complaint.setName(name);
		            complaint.setEmail(email);
		            complaint.setContact(contact);
		            complaint.setComplaintSubject(complaintSubject);
		            complaint.setComplaintBody(complaintBody);
		            
		            BuyerServiceInterface userService = ServiceFactory.createObject("buyer");

		            boolean isRegistered = userService.registerComplaint(complaint);

		            if (isRegistered) {
		                request.setAttribute("message", "Complaint registered successfully!");
		                RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
		                rd.forward(request, response);
		            } else {
		                request.setAttribute("message", "Failed to register complaint.");
		                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		                rd.forward(request, response);
		            }
			    }

			 
	}

}


