package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revshop.entity.Admin;
import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Retailer;
import com.revshop.utility.DatabaseConnection;

public class AdminDAO implements AdminDAOInterface{

	@Override
	public Admin signInDAO(Admin admin) {
		Admin a = null; 
		
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where email=? and password=?");
			ps.setString(1, admin.getEmail());
			ps.setString(2, admin.getPassword());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new Admin();
			}
		}catch(Exception e) {
			System.out.println();
		}
		
		return a;
	}

	@Override
	public Admin signUpDAO(Admin admin) {
		
		Admin a = null; 
		
		try {
			
			Connection con = DatabaseConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into admin(adminId, username,password,email)values(?,?,?,?)");
			ps.setString(1, admin.getAdminId());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getEmail());
			
			int i = ps.executeUpdate(); 
			
			if(i>0) {
				
			    a = new Admin(); 
			    a.setAdminId(admin.getAdminId());
				a.setUsername(admin.getUsername());
				a.setPassword(admin.getPassword());
				a.setEmail(admin.getEmail());
			}
			
		}catch(Exception e) {
			
		}
		return a;
	}

	@Override
	public List<Buyer> viewUsersDao(String userType) {
		// TODO Auto-generated method stub
		List<Buyer> buyer_list = new ArrayList<Buyer>();
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from buyer");
//			ps.setString(1, userType);

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString(6);
				String name = rs.getString(1);
				String email= rs.getString(2);
				String password = rs.getString(3);
				String contact = rs.getString(4);
				String residence = rs.getString(5);
				
				Buyer buyer = new Buyer();
				buyer.setUserId(userId);
				buyer.setName(name);
				buyer.setEmail(email);
				buyer.setPassword(password);
				buyer.setContact(contact);
				buyer.setResidence(residence);
				
				buyer_list.add(buyer);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buyer_list;
	}

	@Override
	public List<Retailer> viewRetailerDao(String userType) {
		List<Retailer> retailer_list = new ArrayList<Retailer>();
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from retailer");
//			ps.setString(1, userType);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String retailerId = rs.getString(7);
				String brandname = rs.getString(1);
				String retailerUsername = rs.getString(2);
				String retailerEmail= rs.getString(3);
				String retailerPassword = rs.getString(4);
				String retailerResidence = rs.getString(5);


				
				Retailer retailer = new Retailer();
				
				retailer.setBrandName(brandname);
				retailer.setUsername(retailerUsername);
				retailer.setEmailaddress(retailerEmail);
				retailer.setPassword(retailerPassword);
				retailer.setResidencePlace(retailerResidence);
				retailer.setRetailerId(retailerId);
				
				retailer_list.add(retailer);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retailer_list;
	}
	
	
	@Override
	public List<Retailer> getPendingRetailerRequests() {
	    List<Retailer> retailer_list = new ArrayList<>();
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM retailer WHERE approved = FALSE");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Retailer retailer = new Retailer();
	            retailer.setRetailerId(rs.getString("retailerId"));
	            retailer.setBrandName(rs.getString("brandName"));
	            retailer.setUsername(rs.getString("username"));
	            retailer.setEmailaddress(rs.getString("emailaddress"));
	            retailer.setPassword(rs.getString("password"));
	            retailer.setResidencePlace(rs.getString("residencePlace"));
	            retailer_list.add(retailer);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return retailer_list;
	}

	@Override
	public boolean approveRetailer(String emailaddress) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE retailer SET approved = TRUE WHERE emailaddress = ?");
	        ps.setString(1, emailaddress);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

	
	@Override
	public boolean blockUser(String userId) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE buyer SET isBlocked = TRUE WHERE userId = ?");
	        ps.setString(1, userId);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

	@Override
	public boolean unblockUser(String userId) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE buyer SET isBlocked = FALSE WHERE userId = ?");
	        ps.setString(1, userId);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

	@Override
	public boolean blockRetailer(String retailerId) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE retailer SET isBlocked = TRUE WHERE retailerId = ?");
	        ps.setString(1, retailerId);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

	@Override
	public boolean unblockRetailer(String retailerId) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE retailer SET isBlocked = FALSE WHERE retailerId = ?");
	        ps.setString(1, retailerId);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

	@Override
	public List<Complaints> viewComplaintsDao() {

		List<Complaints> complaints_list = new ArrayList<Complaints>(); 
		
		try {
			
			Connection con = DatabaseConnection.getConnection(); 
			
			PreparedStatement ps = con.prepareStatement("select *from complaints");
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				
				String complaintId = rs.getString(1); 
				String name = rs.getString(2); 
				String email = rs.getString(3); 
				String contact = rs.getString(4); 
				String complaintSubject = rs.getString(5); 
				String complainBody  = rs.getString(6); 
				
				Complaints complaint = new Complaints();
				
				complaint.setComplaintId(complaintId);
				complaint.setName(name);
				complaint.setEmail(email);
				complaint.setContact(contact);
				complaint.setComplaintSubject(complaintSubject);
				complaint.setComplaintBody(complainBody);
				
				complaints_list.add(complaint); 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return complaints_list;
	}

	@Override
	public boolean deleteUserDAO(String email) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("DELETE FROM buyer WHERE userId = ?");
	        ps.setString(1, email);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}


	@Override
	public boolean deleteRetailerDAO(String emailaddress) {
	    boolean success = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("DELETE FROM retailer WHERE retailerId = ?");
	        ps.setString(1, emailaddress);
	        int i = ps.executeUpdate();
	        success = (i > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}

    
}