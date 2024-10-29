package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revshop.entity.Buyer;
import com.revshop.entity.Complaints;
import com.revshop.entity.Product;
import com.revshop.entity.Retailer;
import com.revshop.entity.cart;
import com.revshop.entity.order;
import com.revshop.utility.DatabaseConnection;

public class BuyerDAO implements BuyerDAOInterface {

	@Override
	public Buyer signInServiceDAO(Buyer user) {
		
	    Buyer b = null;
	    
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from buyer where email=? and password=?");
	        ps.setString(1, user.getEmail());
	        ps.setString(2, user.getPassword());
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            b = new Buyer();
	            // Setting fields from ResultSet, not from input User object
	            b.setUserId(rs.getString("userId"));
	            b.setName(rs.getString("name"));
	            b.setEmail(rs.getString("email"));
	            b.setPassword(rs.getString("password"));
	            b.setContact(rs.getString("contact"));
	            b.setResidence(rs.getString("residence"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return b;
	}


	@Override
	public Buyer signUpServiceDAO(Buyer user) {
		
		Buyer b = null; 
		
		try {
			
			Connection con = DatabaseConnection.getConnection(); 
			
            PreparedStatement checkEmail = con.prepareStatement("SELECT COUNT(*) FROM buyer WHERE email = ?");
            checkEmail.setString(1, user.getEmail());
            ResultSet rs = checkEmail.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                // Email already exists
                System.out.println("Email address already exists in the database.");
                return null;
            }
			
			PreparedStatement ps = con.prepareStatement("insert into buyer(userId,name, email, password, contact, residence) values(?,?,?,?,?,?)");
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4,  user.getPassword());
			ps.setString(5, user.getContact());
			ps.setString(6, user.getResidence());
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				b = new Buyer(); 
				b.setUserId(user.getUserId());
				b.setName(user.getName());
				b.setEmail(user.getEmail());
				b.setPassword(user.getPassword());
				b.setContact(user.getContact());
				b.setResidence(user.getResidence());
			}
			
		} catch(Exception e) {
			
			System.out.println();
		}
		
		return b;
	}

	@Override
	public boolean isUserBlockedDAO(String email) {
		
		boolean isBlocked = false;

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select isBlocked from buyer where email=?");
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isBlocked = rs.getBoolean("isBlocked");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return isBlocked;
    }

	@Override
	public boolean updatePasswordDAO(String email, String newPassword) {
		boolean isUpdated = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "UPDATE buyer SET password=? WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, email);
            
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
	public boolean isEmailExistsDAO(String email) {
	    boolean exists = false;
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM buyer WHERE email=?");
	        ps.setString(1, email);
	        
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
	public List<Product> viewAllProductsDAO() {
		
	       List<Product> products = new ArrayList<>();
	        
	        try {
	            Connection con = DatabaseConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement("SELECT *FROM products");

	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                Product product = new Product();
	                product.setProductId(rs.getLong("productId"));
	                product.setProductName(rs.getString("productName"));
	                product.setProductPrice(rs.getLong("productPrice"));
	                product.setProductDescription(rs.getString("productDescription"));
	                product.setImageUrl(rs.getString("imageUrl"));
	                product.setRetailerId(rs.getString("retailerId"));
	                products.add(product);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return products;
	    }




	@Override
	public List<cart> addItemsToCartDAO(cart cart) {
	    List<cart> cartItems = new ArrayList<>();
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        
	        // Retrieve retailerId based on the productId
	        PreparedStatement retailerps = con.prepareStatement("SELECT retailerId FROM products WHERE productId = ?");
	        retailerps.setLong(1, cart.getProductId().getProductId());

	        // Log the query execution
	        System.out.println("Executing query to fetch retailerId for productId: " + cart.getProductId().getProductId());
	        
	        ResultSet retailerRs = retailerps.executeQuery();
	        
	        String retailerId = null;
	        if (retailerRs.next()) {
	            retailerId = retailerRs.getString("retailerId");
	            System.out.println("Fetched retailerId: " + retailerId);
	        } else {
	            System.out.println("No retailerId found for productId: " + cart.getProductId().getProductId());
	        }
	        
	        // Proceed with the rest of the method only if retailerId is not null
	        if (retailerId != null) {
	            // Check if the product is already in the cart for this user
	            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM cart WHERE email = ? AND productId = ?");
	            checkStmt.setString(1, cart.getEmail().getEmail());
	            checkStmt.setLong(2, cart.getProductId().getProductId()); 
	            ResultSet checkRs = checkStmt.executeQuery();

	            if (checkRs.next()) {
	                // If the product is already in the cart, update the quantity
	                int existingQuantity = checkRs.getInt("quantity");
	                int newQuantity = existingQuantity + cart.getQuantity();
	                PreparedStatement updateStmt = con.prepareStatement("UPDATE cart SET quantity = ?, retailerId = ? WHERE email = ? AND productId = ?");
	                updateStmt.setInt(1, newQuantity);
	                updateStmt.setString(2, retailerId);
	                updateStmt.setString(3, cart.getEmail().getEmail());
	                updateStmt.setLong(4, cart.getProductId().getProductId());
	                updateStmt.executeUpdate();
	            } else {
	                // If the product is not in the cart, add it
	                PreparedStatement insertStmt = con.prepareStatement("INSERT INTO cart (cartId, email, productId, quantity, retailerId) VALUES (?, ?, ?, ?, ?)");
	                insertStmt.setInt(1, cart.getCartId()); 
	                insertStmt.setString(2, cart.getEmail().getEmail());
	                insertStmt.setLong(3, cart.getProductId().getProductId());
	                insertStmt.setInt(4, cart.getQuantity());
	                insertStmt.setString(5, retailerId);
	                insertStmt.executeUpdate();
	            }

	            // Retrieve all items in the cart for the user to return
	            PreparedStatement selectStmt = con.prepareStatement("SELECT c.cartId, c.email, c.productId, c.quantity, c.retailerId, p.productName, p.productPrice, p.imageUrl " +
	                                                             "FROM cart c JOIN products p ON c.productId = p.productId WHERE c.email = ?");
	            selectStmt.setString(1, cart.getEmail().getEmail());
	            ResultSet rs = selectStmt.executeQuery();
	            while (rs.next()) {
	                cart cartItem = new cart();
	                cartItem.setCartId(rs.getInt("cartId"));

	                // Create Buyer object
	                Buyer buyer = new Buyer();
	                buyer.setEmail(rs.getString("email"));
	                cartItem.setEmail(buyer);

	                // Create Product object with additional details
	                Product product = new Product();
	                product.setProductId(rs.getLong("productId")); 
	                product.setProductName(rs.getString("productName"));
	                product.setProductPrice(rs.getLong("productPrice"));
	                product.setImageUrl(rs.getString("imageUrl"));
	                cartItem.setProductId(product);
	                cartItem.setQuantity(rs.getInt("quantity"));

	                // Create Retailer object
	                Retailer retailer = new Retailer();
	                retailer.setRetailerId(rs.getString("retailerId"));
	                cartItem.setRetailerId(retailer);

	                cartItems.add(cartItem);
	            }
	        } else {
	            System.out.println("Unable to add to cart. No retailerId associated with productId: " + cart.getProductId().getProductId());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return cartItems;
	}


	@Override
	public boolean deleteItemFromCartDAO(String email, long productId) {
		boolean isDeleted = false; 
		
		try{
			
			Connection con = DatabaseConnection.getConnection(); 
			
			PreparedStatement ps= con.prepareStatement("delete from cart where email=? and productId=?"); 
			ps.setString(1, email);
			ps.setLong(2, productId);
			
			int i = ps.executeUpdate(); 
			
			if(i>0) {
				isDeleted= true; 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}


	

	@Override
	public List<cart> getCartItemsDAO(Buyer email) {
		 List<cart> cartItems = new ArrayList<>();
		 
		 try {
			 
			 Connection con = DatabaseConnection.getConnection();
			 
			 PreparedStatement ps = con.prepareStatement("SELECT c.cartId, c.email, c.productId, c.quantity, p.productName, p.productPrice, p.imageUrl \" +\r\n"
			 		+ "                     \"FROM cart c JOIN products p ON c.productId = p.productId \" +\r\n"
			 		+ "                     \"WHERE c.email = ?"); 
			 
			 ps.setString(1, email.getEmail());
			 
			 ResultSet rs = ps.executeQuery(); 
			 
			 while(rs.next()) {
				 
		            cart cartItem = new cart();
		            cartItem.setCartId(rs.getInt("cartId"));
		            
		            Buyer cartBuyer = new Buyer();
		            cartBuyer.setEmail(rs.getString("email"));
		            cartItem.setEmail(cartBuyer);

		            
		            Product product = new Product();
		            product.setProductId(rs.getLong("productId"));
		            product.setProductName(rs.getString("productName"));
		            product.setProductPrice(rs.getLong("productPrice"));
		            product.setImageUrl(rs.getString("imageUrl"));
		            cartItem.setProductId(product);
		            
		            cartItem.setQuantity(rs.getInt("quantity"));
		            cartItems.add(cartItem);
		            
			 }
			 
		 }catch(Exception e) {
			 
			 
		 }
		return cartItems;
	}


	@Override
	public boolean updateEmailDAO(String email, String newEmail) {
		boolean isEmailUpdated = false; 
		
		try {
			
			Connection con = DatabaseConnection.getConnection(); 
			
			PreparedStatement ps = con.prepareStatement("UPDATE buyer SET email=? WHERE email=?"); 
			ps.setString(1, newEmail);
			ps.setString(2, email);
			
			int i = ps.executeUpdate(); 
			
			if(i>0) {
				
				isEmailUpdated = true; 
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return isEmailUpdated;
	}


	@Override
	public boolean createOrderDAO(cart cart) {
		boolean isOrderCreated = false; 
		
		try {
			
			Connection con = DatabaseConnection.getConnection(); 
			
			PreparedStatement ps = con.prepareStatement("\"SELECT SUM(p.productPrice * c.quantity) AS totalAmount \" +\r\n"
					+ "            \"FROM cart c JOIN products p ON c.productId = p.productId \" +\r\n"
					+ "            \"WHERE c.email = ?\""); 
			
			ps.setString(1, cart.getEmail().getEmail());
			
			ResultSet rs = ps.executeQuery(); 
			
			long orderAmount = 0 ; 
			
			if(rs.next()) {
				orderAmount = rs.getLong("totalAmount");
			}
			
	        int retailerIdInt;
	        try {
	            retailerIdInt = Integer.parseInt(cart.getRetailerId().getRetailerId());
	        } catch (NumberFormatException e) {
	            throw new IllegalArgumentException("Invalid retailerId format", e);
	        }
	        
			
			
			PreparedStatement insertOrder = con.prepareStatement( "INSERT INTO orders (email, retailerId, orderdate, ordertime, orderAmount) " +
		            "VALUES (?, ?, ?, CURDATE(), CURTIME(), ?)"); 
			insertOrder.setString(1, cart.getEmail().getEmail());
//			insertOrder.setInt(2, cart.getCartId());
			insertOrder.setLong(3, cart.getProductId().getProductId());
		//	insertOrder.setString(4, cart.getProductId().getProductName());
		//	insertOrder.setLong(5, cart.getProductId().getProductPrice()); 
			insertOrder.setInt(3, retailerIdInt); ;
			insertOrder.setLong(7, orderAmount); 
			
			 int i = insertOrder.executeUpdate();
			 
			 if(i>0) {
				 
				 isOrderCreated = true; 
				 
				 // clearing the cart after the order is placed
		            PreparedStatement clearCart = con.prepareStatement(
		                "DELETE FROM cart WHERE email = ?"
		            );
		            clearCart.setString(1, cart.getEmail().getEmail());
		            clearCart.executeUpdate();
		        }
			 
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return isOrderCreated;
	}




	@Override
	public boolean CreateComplaint(Complaints complaint) {
        boolean isInserted = false;
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO complaints (complaintId, name, email, contact, complaintSubject, complainBody) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, complaint.getComplaintId());
            ps.setString(2, complaint.getName());
            ps.setString(3, complaint.getEmail());
            ps.setString(4, complaint.getContact());
            ps.setString(5, complaint.getComplaintSubject());
            ps.setString(6, complaint.getComplaintBody());
            
            int i = ps.executeUpdate();
            if (i > 0) {
                isInserted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isInserted;
    }
	
	
	

	
}

	
