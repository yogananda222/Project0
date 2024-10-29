package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.utility.DatabaseConnection;

public class RetailerDAO implements RetailerDAOInterface {
	
	// Handles the retailer login process 
	
	@Override
    public Retailer signInDAO(Retailer retailer) {
        Retailer r = null;
        try {
        	//Get a connection to the database
            Connection con = DatabaseConnection.getConnection();
            
            // Prepare the SQL query to select the retailer with matching email and password, and approved status
            PreparedStatement ps = con.prepareStatement("SELECT * FROM retailer WHERE emailaddress=? AND password=? AND approved = TRUE");
            ps.setString(1, retailer.getEmailaddress());
            ps.setString(2, retailer.getPassword());
            
         // Execute the query
            ResultSet rs = ps.executeQuery();
            
            // If a matching retailer is found, return the Retailer object with the details
            if (rs.next()) {
                r = new Retailer();
                r.setRetailerId(rs.getString("retailerId"));
                r.setBrandName(rs.getString("brandName"));
                r.setUsername(rs.getString("username"));
                r.setEmailaddress(rs.getString("emailaddress"));
                r.setPassword(rs.getString("password"));
                r.setResidencePlace(rs.getString("residencePlace"));
                
            }
        } catch (Exception e) {
        	// Print any exception that occurs
            e.printStackTrace();
        }
        
        // Return the Retailer object, or null if not found
        return r;
    }

	// Handles the retailer registration process 
    @Override
    public Retailer signUpDAO(Retailer retailer) {
        Retailer r = null;
        try {
        	
        	//Get a connection 
            Connection con = DatabaseConnection.getConnection();
            

        //  Check if the email address is already in use
            PreparedStatement checkEmail = con.prepareStatement("SELECT COUNT(*) FROM retailer WHERE emailaddress = ?");
            checkEmail.setString(1, retailer.getEmailaddress());
            ResultSet rs = checkEmail.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
              //   Email already exists
                System.out.println("Email address already exists in the database.");
                return null;
            }
            
         // Prepare the SQL query to insert the new retailer into the database
            PreparedStatement ps = con.prepareStatement("INSERT INTO retailer (retailerId,brandName, username, emailaddress, password, residencePlace, approved) VALUES (?,?, ?, ?, ?, ?,?)");
            ps.setString(1, retailer.getRetailerId());
            ps.setString(2, retailer.getBrandName());
            ps.setString(3, retailer.getUsername());
            ps.setString(4, retailer.getEmailaddress());
            ps.setString(5, retailer.getPassword());
            ps.setString(6, retailer.getResidencePlace());
            ps.setBoolean(7, false);
            
            // Execute the insert operation
            int i = ps.executeUpdate();
            
            // If the insertion is successful, populate the Retailer object with the details
            if (i > 0) {
                r = new Retailer();
                r.setRetailerId(retailer.getRetailerId());
                r.setBrandName(retailer.getBrandName());
                r.setUsername(retailer.getUsername());
                r.setEmailaddress(retailer.getEmailaddress());
                r.setPassword(retailer.getPassword());
                r.setResidencePlace(retailer.getResidencePlace());
            }
        } catch (Exception e) {
        	 // Print any exception that occurs
            e.printStackTrace();
        }
        
        // Return the Retailer object, or null if registration failed
        return r;
    }
    
    // Checks if a retailer is blocked based on the provided email address.
	@Override
	public boolean isRetailerBlockedDAO(String emailaddress) {
		boolean isBlocked = false; 
		
		try {
			
			//Get connection to the  database
			Connection con = DatabaseConnection.getConnection(); 
			
			 // Prepare the SQL query to check the blocked status of the retailer
			PreparedStatement ps = con.prepareStatement("select isBlocked from retailer where emailaddress=?");
			ps.setString(1, emailaddress);
			
			// Execute the query
			ResultSet rs = ps.executeQuery();

			 // If a result is found, retrieve the blocked status
	        if (rs.next()) {
	            isBlocked = rs.getBoolean("isBlocked");
	        }
			
		}catch(Exception e) {
			 // Print any exception that occurs
			e.printStackTrace();	
			
		}
		// Return the blocked status
		return isBlocked;
	}
	
	@Override
	public boolean updatePasswordDAO(String emailaddress, String newPassword) {
		boolean isUpdated = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "UPDATE retailer SET password=? WHERE emailaddress=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, emailaddress);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

	@Override
	public boolean isEmailExistsDAO(String emailaddress) {
	    boolean exists = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM retailer WHERE emailaddress=?");
	        ps.setString(1, emailaddress);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            exists = rs.getInt(1) > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return exists;
	}

	@Override
	public boolean addProduct(Product product) {
//	    String sql = "INSERT INTO products (productId, productName, productDescription, productPrice, imageUrl, inventoryCount, retailerId) VALUES (?, ?, ?, ?, ?, ?,?)";

	    try (
	    		
	    	Connection conn = DatabaseConnection.getConnection();
	    		
	         PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (productId, productName, productDescription, productPrice, imageUrl, inventoryCount, retailerId) VALUES (?, ?, ?, ?, ?, ?,?)")) {
	    	
	    	stmt.setLong(1, product.getProductId());
	        stmt.setString(2, product.getProductName());
	        stmt.setString(3, product.getProductDescription());
	        stmt.setDouble(4, product.getProductPrice());
	        stmt.setString(5, product.getImageUrl());
	        stmt.setLong(6, product.getInventory_count());
	        stmt.setString(7, product.getRetailerId()); 

	        return stmt.executeUpdate() > 0;

	    } catch (SQLException e) {
	        // Handle SQL exception
	        e.printStackTrace();
	        return false;
	    } catch (Exception e) {
	        // Handle other exceptions
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public boolean updateProductDAO(Product product) {
		boolean isUpdated = false; 
		
		try {
			
			Connection con = DatabaseConnection.getConnection(); 
			
			PreparedStatement ps = con.prepareStatement("UPDATE products SET productName = ?, productDescription = ?, productPrice = ?, imageUrl = ?, inventoryCount = ? WHERE productId = ?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductDescription());
			ps.setDouble(3, product.getProductPrice());
			ps.setString(4, product.getImageUrl());
			ps.setLong(5, product.getInventory_count());
			ps.setLong(6, product.getProductId()); // Ensure all parameters are set

			
			int i = ps.executeUpdate(); 
			
			if(i>0) {
				return isUpdated = true; 
			}
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	@Override
	public boolean deleteProductDAO(long productId) {
		
		boolean isDeleted = false; 
		try {
			
			Connection con = DatabaseConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE productId=?");

			ps.setLong(1, productId);
			
			int i = ps.executeUpdate(); 
			
			if(i>0) {
				return isDeleted= true; 
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public List<Product> viewProduct(Product product) {
		
		List<Product> product_list =  new ArrayList<>(); 
		
		try {
			
			Connection con = DatabaseConnection.getConnection(); 
			
			PreparedStatement ps = con.prepareStatement("select *from products where retailerId=?"); 
			ps.setString(1, product.getRetailerId());
			
			ResultSet rs = ps.executeQuery();
			
			Product p  = new Product(); 
			
            p.setProductId(rs.getLong("productId"));
            p.setProductName(rs.getString("productName"));
            p.setProductDescription(rs.getString("productDescription"));
            p.setProductPrice(rs.getLong("productPrice"));
            p.setImageUrl(rs.getString("imageUrl"));
            p.setInventory_count(rs.getLong("inventoryCount"));
            p.setRetailerId(rs.getString("retailerId"));
            
            product_list.add(p); 

		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return product_list;
	}


	

	
}
