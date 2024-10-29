package com.revshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revshop.dao.AdminDAO;
import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Retailer;
import com.revshop.service.AdminServiceInterface;
import com.revshop.utility.RetailerApprovalEmail;
import com.revshop.utility.ServiceFactory;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String taskType = request.getParameter("taskType");

	        if (taskType.equals("login")) {
	        	String email = request.getParameter("email");
	        	String password = request.getParameter("password"); 

	            Admin admin = new Admin();
	            admin.setEmail(email); 
	            admin.setPassword(password); 

	            AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
	            
	            Admin a = adminService.signInService(admin); 

	            if (a != null) {
	                HttpSession session = request.getSession(true);
	                session.setAttribute("email", email);

	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminHomepage.jsp");
	                rd.forward(request, response);
	            } else {
	                request.setAttribute("error", "Invalid email or password");
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminLogin.jsp");
	                rd.forward(request, response);
	            }
	        }
	        
	        if(taskType.equals("register")) {
	        	
	        	String username = request.getParameter("username");
	        	String password = request.getParameter("password"); 
	        	String email = request.getParameter("email"); 
	        	
	        	Admin admin = new Admin(); 
	        	admin.setUsername(username);
	        	admin.setPassword(password);
	        	admin.setEmail(email); 
	        	
	            AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
	            
	            Admin a = adminService.signUpService(admin); 
	            
	            if (a != null) {
					
					response.setContentType("text/html");
					response.getWriter().println("<script type='text/javascript'>");
					response.getWriter().println("alert('Registration successful! Please log in.');");
					response.getWriter().println("window.location.href = 'adminLogin.jsp';");
					response.getWriter().println("</script>");
				} else {
					
					request.setAttribute("error", "Registration failed. Please try again.");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminRegister.jsp");
					rd.forward(request, response);
				}
	        }
	        

	    	AdminServiceInterface aservice = ServiceFactory.createAdminService("admin");
	    	
	    	if (taskType.equals("viewUsers")) {
	    	    Buyer buyer = new Buyer();
	    	    String user = "buyer"; 
	    	    List<Buyer> list_of_buyer = aservice.viewUsers(user);

	    	    response.setContentType("text/html");
	    	    PrintWriter out = response.getWriter();
	    	    out.println("<html>");
//	    	    out.println("<style>\r\n"
//	    	            + "table, th, td {\r\n"
//	    	            + "  border:1px solid black;padding:5px;\r\n"
//	    	            + "}\r\n"
//	    	            + "</style>");
	    	    out.println("<html>");
	    	    out.println("<style>");
	    	    out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px;}");
	    	    out.println("h1 {text-align: center; color: #333;}");
	    	    out.println("table {width: 100%; border-collapse: collapse; margin: 25px 0; font-size: 1em; box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);}");
	    	    out.println("table th, table td {padding: 12px 15px; text-align: left;}");
	    	    out.println("table th {background-color: #009879; color: #ffffff; text-transform: uppercase;}");
	    	    out.println("table tr {border-bottom: 1px solid #dddddd;}");
	    	    out.println("table tr:nth-of-type(even) {background-color: #f3f3f3;}");
	    	    out.println("table tr:last-of-type {border-bottom: 2px solid #009879;}");
	    	    out.println("table tr:hover {background-color: #f1f1f1;}");
	    	    out.println("button {background-color: #009879; color: white; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px;}");
	    	    out.println("button:hover {background-color: #007f68;}");
	    	    out.println("</style>");
	    	    out.println("<body>");
	    	    out.println("<h1>USERS</h1>");
	    	    out.println("<table>");
	    	    out.println("<body>");
	    	    out.println("<table >");
	    	    out.println("<tr>");
	    	    out.println("<th> UserId </th>");
	    	    out.println("<th> Name </th>");
	    	    out.println("<th> Email </th>");
	    	    out.println("<th> Password </th>");
	    	    out.println("<th> Contact Number </th>");
	    	    out.println("<th> Residence </th>");
	    	    out.println("</tr>");
	    	    for (Buyer b : list_of_buyer) {
	    	        out.println("<tr>");
	    	        out.println("<td>" + b.getUserId() + "</td>");
	    	        out.println("<td>" + b.getName() + "</td>");
	    	        out.println("<td>" + b.getEmail() + "</td>");
	    	        out.println("<td>" + b.getPassword() + "</td>");
	    	        out.println("<td>" + b.getContact() + "</td>");
	    	        out.println("<td>" + b.getResidence() + "</td>");
	    	        out.println("</tr>");
	    	    }
	    	    out.println("</table>");
	    	    out.println("</body></html>");
	    	}	

				
				if(taskType.equals("viewRetailer")) {
					Retailer retailer = new Retailer();
					String user = "retailer";
					List<Retailer> list_of_retailer = aservice.viewRetailer(user);
					
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<html>");
//					out.println("<style>\r\n"
//							+ "table, th, td {\r\n"
//							+ "  border:1px solid black;padding:5px;\r\n"
//							+ "}\r\n"
//							+ "</style>");
					 out.println("<html>");
			    	    out.println("<style>");
			    	    out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px;}");
			    	    out.println("h1 {text-align: center; color: #333;}");
			    	    out.println("table {width: 100%; border-collapse: collapse; margin: 25px 0; font-size: 1em; box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);}");
			    	    out.println("table th, table td {padding: 12px 15px; text-align: left;}");
			    	    out.println("table th {background-color: #009879; color: #ffffff; text-transform: uppercase;}");
			    	    out.println("table tr {border-bottom: 1px solid #dddddd;}");
			    	    out.println("table tr:nth-of-type(even) {background-color: #f3f3f3;}");
			    	    out.println("table tr:last-of-type {border-bottom: 2px solid #009879;}");
			    	    out.println("table tr:hover {background-color: #f1f1f1;}");
			    	    out.println("button {background-color: #009879; color: white; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px;}");
			    	    out.println("button:hover {background-color: #007f68;}");
			    	    out.println("</style>");
			    	    out.println("<body>");
			    	    out.println("<h1>Retailers</h1>");
			    	    out.println("<table>");
			    	    out.println("<body>");
			    	    out.println("<table >");
			    	    out.println("<body>");
			    	    out.println("<table>");
			    	    out.println("<tr>");
			    	    out.println("<th> Retailer Id</th>");
			    	    out.println("<th> Brand Name </th>");
			    	    out.println("<th> Name </th>");
			    	    out.println("<th> Email </th>");
						out.println("<th> Password </th>");
						out.println("<th> Residence Place </th>");
						out.println("</tr>");
					for(Retailer r:list_of_retailer) {
						
						out.println("<tr>");
						out.println("<td>"+r.getRetailerId());
						out.println("<td>"+r.getBrandName()+"</td>");
						out.println("<td>"+r.getUsername()+"</td>");
						out.println("<td>"+r.getEmailaddress()+"</td>");
						out.println("<td>"+r.getPassword()+"</td>");
						out.println("<td>"+r.getResidencePlace()+"</td>");
						out.println("</tr>");
					}
					out.println("</table>");
					out.println("</body></html>");
				}
				
				if (taskType.equals("viewPendingRetailers")) {
				    AdminDAO adminDAO = new AdminDAO();
				    List<Retailer> pendingRetailers = adminDAO.getPendingRetailerRequests();

				    response.setContentType("text/html");
				    PrintWriter out = response.getWriter();
				    out.println("<html>");
				    out.println("<style>");
				    out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px;}");
				    out.println("h1 {text-align: center; color: #333;}");
				    out.println("table {width: 100%; border-collapse: collapse; margin: 25px 0; font-size: 1em; box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);}");
				    out.println("table th, table td {padding: 12px 15px; text-align: left;}");
				    out.println("table th {background-color: #009879; color: #ffffff; text-transform: uppercase;}");
				    out.println("table tr {border-bottom: 1px solid #dddddd;}");
				    out.println("table tr:nth-of-type(even) {background-color: #f3f3f3;}");
				    out.println("table tr:last-of-type {border-bottom: 2px solid #009879;}");
				    out.println("table tr:hover {background-color: #f1f1f1;}");
				    out.println("button {background-color: #009879; color: white; border: none; padding: 10px 20px; cursor: pointer; border-radius: 5px;}");
				    out.println("button:hover {background-color: #007f68;}");
				    out.println("a {color: #009879; text-decoration: none;}");
				    out.println("a:hover {text-decoration: underline;}");
				    out.println("</style>");
				    out.println("<body>");
				    out.println("<h1>Retailer Requests</h1>");
				    out.println("<table>");
				    out.println("<tr>");
				    out.println("<th>Brand Name</th>");
				    out.println("<th>Name</th>");
				    out.println("<th>Email</th>");
				    out.println("<th>Contact Number</th>");
				    out.println("<th>City</th>");
				    out.println("<th>Actions</th>");
				    out.println("</tr>");
				    for (Retailer r : pendingRetailers) {
				        out.println("<tr>");
				        out.println("<td>" + r.getBrandName() + "</td>");
				        out.println("<td>" + r.getUsername() + "</td>");
				        out.println("<td>" + r.getEmailaddress() + "</td>");
				        out.println("<td>" + r.getResidencePlace() + "</td>");
				        out.println("<td>" + r.getResidencePlace() + "</td>");
				        out.println("<td>");
				        out.println("<form action='AdminServlet' method='post' style='margin: 0;'>");
				        out.println("<input type='hidden' name='taskType' value='approveRetailer'>");
				        out.println("<input type='hidden' name='emailaddress' value='" + r.getEmailaddress() + "'>");
				        out.println("<button type='submit'>Approve</button>");
				        out.println("</form>");
				        out.println("</td>");
				        out.println("</tr>");
				    }
				    out.println("</table>");
				    out.println("</body></html>");
				}

				if (taskType.equals("approveRetailer")) {
				    String emailaddress = request.getParameter("emailaddress");
				    AdminDAO adminDAO = new AdminDAO();
				    boolean approved = adminDAO.approveRetailer(emailaddress);

			        // Retrieve retailer details
				    
				    String brandName = request.getParameter("brandName"); 
			        String retailerEmail = request.getParameter("emailaddress");
			        String retailerName = request.getParameter("username");
			        String retailerPassword = request.getParameter("password");
			        
			        String subject = "Retailer Approval - Your Account Details";
			        String body = "Dear " + retailerEmail + ",\n\n" +
			                      "Your account has been approved :) \n\n" +
			                      "We are happy to continue with your amazing brand! \n\n"+
			                      "If you have queries, please contact us @ +91 9494075192 \n\n"+
			                      "Thank you,\n RevShop Team";

			        // Send email
			        RetailerApprovalEmail.sendEmail(retailerEmail, subject, body);
			        
				    response.setContentType("text/html");
				    PrintWriter out = response.getWriter();
				    out.println("<html>");
				    out.println("<style>");
				    out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px;}");
				    out.println("h1 {text-align: center; color: #333;}");
				    out.println("p {text-align: center; color: #555;}");
				    out.println("a {color: #009879; text-decoration: none;}");
				    out.println("a:hover {text-decoration: underline;}");
				    out.println("</style>");
				    out.println("<body>");
				    if (approved) {
				        out.println("<h1>Retailer Approved Successfully!</h1>");
				        out.println("<p>The retailer with email " + emailaddress + " has been approved.</p>");
				    } else {
				        out.println("<h1>Approval Failed</h1>");
				        out.println("<p>Approval of retailer with email " + emailaddress + " failed. Please try again.</p>");
				    }
				    out.println("<p><a href='AdminServlet?taskType=viewPendingRetailers'>Back to Pending Retailers</a></p>");
				    out.println("</body></html>");
				}

				 
				 if (taskType.equals("blockUser")) {
					    String userId = request.getParameter("userId");
					    AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
					    boolean blocked = adminService.blockUser(userId);
					    response.setContentType("text/html");
					    PrintWriter out = response.getWriter();
					    out.println("<html>");
					    out.println("<body>");
					    if (blocked) {
					        out.println("<h1>User Blocked Successfully!</h1>");
					    } else {
					        out.println("<h1>Block Failed</h1>");
					    }
					    out.println("<a href='adminHomepage.jsp'>Back</a>");
					    out.println("</body></html>");
					}

					if (taskType.equals("unblockUser")) {
					    String userId = request.getParameter("userId");
					    AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
					    boolean unblocked = adminService.unblockUser(userId);
					    response.setContentType("text/html");
					    PrintWriter out = response.getWriter();
					    out.println("<html>");
					    out.println("<body>");
					    if (unblocked) {
					        out.println("<h1>User Unblocked Successfully!</h1>");
					    } else {
					        out.println("<h1>Unblock Failed</h1>");
					    }
					    out.println("<a href='adminHomepage.jsp'>Back</a>");
					    out.println("</body></html>");
					}

					if (taskType.equals("blockRetailer")) {
					    String retailerId = request.getParameter("retailerId");
					    AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
					    boolean blocked = adminService.blockRetailer(retailerId);
					    response.setContentType("text/html");
					    PrintWriter out = response.getWriter();
					    out.println("<html>");
					    out.println("<body>");
					    if (blocked) {
					        out.println("<h1>Retailer Blocked Successfully!</h1>");
					    } else {
					        out.println("<h1>Block Failed</h1>");
					    }
					    out.println("<a href='adminHomepage.jsp'>Back</a>");
					    out.println("</body></html>");
					}

					if (taskType.equals("unblockRetailer")) {
					    String retailerId = request.getParameter("retailerId");
					    AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
					    boolean unblocked = adminService.unblockRetailer(retailerId);
					    response.setContentType("text/html");
					    PrintWriter out = response.getWriter();
					    out.println("<html>");
					    out.println("<body>");
					    if (unblocked) {
					        out.println("<h1>Retailer Unblocked Successfully!</h1>");
					    } else {
					        out.println("<h1>Unblock Failed</h1>");
					    }
					    out.println("<a href='adminHomepage.jsp'>Back</a>");
					    out.println("</body></html>");
					}

					if(taskType.equals("viewComplaints")) {
						List<Complaints> list_of_complaints = aservice.viewComplaints();
						
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						
						out.println("<html>");
						out.println("<style>\r\n"
								+ "table, th, td {\r\n"
								+ "  border:1px solid black;padding:5px;\r\n"
								+ "}\r\n"
								+ "</style>");
						out.println("<body>");
						out.println("<table>");
						out.println("<tr>");
						out.println("<th> Name </th>");
						out.println("<th> Email </th>");
						out.println("<th> Contact Number </th>");
						out.println("<th> Complaint Subject </th>");
						out.println("<th> Complaint Body </th>");
						out.println("<th>Complaint Id</th>");
						out.println("</tr>");
						for(Complaints c:list_of_complaints) {
							
							out.println("<tr>");
							out.println("<td>"+c.getComplaintId()+"</td>");
							out.println("<td>"+c.getName()+"</td>");
							out.println("<td>"+c.getEmail()+"</td>");
							out.println("<td>"+c.getContact()+"</td>");
							out.println("<td>"+c.getComplaintSubject()+"</td>");
							out.println("<td>"+c.getComplaintBody()+"</td>");
							out.println("</tr>");
						}
						out.println("</table>");
						out.println("</body></html>");
						
					}
					
					if (taskType.equals("deleteUser")) {
					    String userId = request.getParameter("userId");
					    AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
					    boolean deleted = adminService.deleteUser(userId);
					    response.setContentType("text/html");
					    PrintWriter out = response.getWriter();
					    out.println("<html>");
					    out.println("<head>");
					    out.println("<style>");
					    out.println("body {");
					    out.println("    font-family: Arial, sans-serif;");
					    out.println("    background-color: #f4f4f4;");
					    out.println("    margin: 0;");
					    out.println("    padding: 20px;");
					    out.println("}");
					    out.println(".message-container {");
					    out.println("    max-width: 600px;");
					    out.println("    margin: 50px auto;");
					    out.println("    padding: 20px;");
					    out.println("    border-radius: 8px;");
					    out.println("    background-color: #dff0d8;");
					    out.println("    color: #3c763d;");
					    out.println("    border: 1px solid #d6e9c6;");
					    out.println("    text-align: center;");
					    out.println("}");
					    out.println(".message-container h1 {");
					    out.println("    font-size: 24px;");
					    out.println("    margin-bottom: 20px;");
					    out.println("}");
					    out.println(".message-container p {");
					    out.println("    font-size: 18px;");
					    out.println("    margin-bottom: 20px;");
					    out.println("}");
					    out.println(".message-container a {");
					    out.println("    display: inline-block;");
					    out.println("    padding: 10px 20px;");
					    out.println("    font-size: 16px;");
					    out.println("    color: #fff;");
					    out.println("    background-color: #5bc0de;");
					    out.println("    text-decoration: none;");
					    out.println("    border-radius: 5px;");
					    out.println("}");
					    out.println(".message-container a:hover {");
					    out.println("    background-color: #31b0d5;");
					    out.println("}");
					    out.println("</style>");
					    out.println("</head>");
					    out.println("<body>");
					    out.println("<div class='message-container'>");
					    if (deleted) {
					        out.println("<h1>User Deleted Successfully!</h1>");
					        out.println("<p>The user with ID " + userId + " has been deleted.</p>");
					    } else {
					        out.println("<h1>Deletion Failed</h1>");
					        out.println("<p>Deletion of user with ID " + userId + " failed. Please try again.</p>");
					    }
					    out.println("<a href='adminHomepage.jsp'>Back to Homepage</a>");
					    out.println("</div>");
					    out.println("</body>");
					    out.println("</html>");
					}

					
					
					 // Delete Retailer
			        if (taskType.equals("deleteRetailer")) {
			            String retailerId = request.getParameter("retailerId");
			            AdminServiceInterface adminService = ServiceFactory.createAdminService("admin");
			            boolean deleted = adminService.deleteRetailer(retailerId);
			            response.setContentType("text/html");
			            PrintWriter out = response.getWriter();
			            out.println("<html>");
			            out.println("<style>");
			            out.println("body {");
			            out.println("    font-family: Arial, sans-serif;");
			            out.println("    background-color: #f4f4f4;");
			            out.println("    margin: 0;");
			            out.println("    padding: 20px;");
			            out.println("}");
			            out.println(".message-container {");
			            out.println("    max-width: 600px;");
			            out.println("    margin: 50px auto;");
			            out.println("    padding: 20px;");
			            out.println("    border-radius: 8px;");
			            out.println("    background-color: #dff0d8;");
			            out.println("    color: #3c763d;");
			            out.println("    border: 1px solid #d6e9c6;");
			            out.println("    text-align: center;");
			            out.println("}");
			            out.println(".message-container h1 {");
			            out.println("    font-size: 24px;");
			            out.println("    margin-bottom: 20px;");
			            out.println("}");
			            out.println(".message-container p {");
			            out.println("    font-size: 18px;");
			            out.println("    margin-bottom: 20px;");
			            out.println("}");
			            out.println(".message-container a {");
			            out.println("    display: inline-block;");
			            out.println("    padding: 10px 20px;");
			            out.println("    font-size: 16px;");
			            out.println("    color: #fff;");
			            out.println("    background-color: #5bc0de;");
			            out.println("    text-decoration: none;");
			            out.println("    border-radius: 5px;");
			            out.println("}");
			            out.println(".message-container a:hover {");
			            out.println("    background-color: #31b0d5;");
			            out.println("}");
			            out.println("</style>");
			            out.println("<body>");
			            if (deleted) {
			                out.println("<h1>Retailer Deleted Successfully!</h1>");
			            } else {
			                out.println("<h1>Deletion Failed</h1>");
			            }
			            out.println("<a href='adminHomepage.jsp'>Back</a>");
			            out.println("</body></html>");
			        }
				 
			        
			        if("logout".equals(taskType)) {
			        	
			        	 HttpSession session = request.getSession(false);
			             if (session != null) {
			                 session.invalidate();
			             }
			             
			             response.sendRedirect("adminLogin.jsp"); 
			        }

				 
				}
}
