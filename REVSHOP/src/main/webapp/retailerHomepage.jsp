<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.revshop.entity.Retailer" %>

<%
    // Retrieve the Retailer object from the session
    Retailer retailer = (Retailer) session.getAttribute("loggedRetailer"); // Corrected attribute name

    // Redirect to login page if retailer is null (not logged in)
    if (retailer == null) {
        response.sendRedirect("retailerLogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <style>
/* General Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f4f4f4;
    color: #333;
}

/* Header Styles */
.header {
    background-color: #007bff;
    color: #fff;
    padding: 20px 0;
    text-align: center;
    font-size: 1.6rem;
    border-bottom: 4px solid #0056b3;
}

.header h1 {
    margin: 0;
}

/* Container Styles */
.container {
    margin: 20px auto;
    width: 90%;
    max-width: 900px;
    background: #fff;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Profile Details Table */
.profile-details {
    margin: 0 auto;
    max-width: 700px;
}

.profile-details h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #444;
    font-size: 2rem;
    border-bottom: 2px solid #007bff;
    padding-bottom: 10px;
}

.profile-details table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

.profile-details th,
.profile-details td {
    padding: 15px;
    border: 1px solid #ddd;
    text-align: left;
    font-size: 1.1rem;
}

.profile-details th {
    background-color: #f9f9f9;
    color: #007bff;
    font-weight: bold;
}

.profile-details td {
    background-color: #fafafa;
}

/* Action Buttons */
.action-buttons {
    text-align: center;
    margin-top: 20px;
}

.action-buttons a {
    text-decoration: none;
    padding: 12px 25px;
    margin: 0 8px;
    background-color: #28a745;
    color: white;
    border-radius: 8px;
    transition: background-color 0.3s ease, transform 0.2s ease;
    display: inline-block;
    font-size: 1.1rem;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.action-buttons a:hover {
    background-color: #218838;
    transform: scale(1.05);
}

/* Responsive Design */
@media (max-width: 768px) {
    .container {
        width: 95%;
    }

    .profile-details table, .profile-details th, .profile-details td {
        font-size: 1rem;
    }

    .action-buttons a {
        padding: 10px 20px;
        margin: 5px;
        font-size: 1rem;
    }
}


    </style>
</head>
<body>

<div class="header">
    <h1>Welcome, <%= retailer.getUsername() %>!</h1>
</div>

<div class="container">
    <div class="profile-details">
        <h2>Retailer Profile</h2>
        <table>
            <tr>
                <th>Retailer ID</th>
                <td><%= retailer.getRetailerId() %></td>
            </tr>
            <tr>
                <th>Brand Name</th>
                <td><%= retailer.getBrandName() %></td>
            </tr>
            <tr>
                <th>Username</th>
                <td><%= retailer.getUsername() %></td>
            </tr>
            <tr>
                <th>Email Address</th>
                <td><%= retailer.getEmailaddress() %></td>
            </tr>
            <tr>
                <th>Residence Place</th>
                <td><%= retailer.getResidencePlace() %></td>
            </tr>
        </table>
    </div>

    <div class="action-buttons">
        <a href="addProduct.jsp">Add New Product</a>
        <a href="updateProduct.jsp">Update Product</a>
        <a href="deleteProduct.jsp">Delete Product</a>
 	 <!--   <a href="RetailerServlet?taskType=viewallProductofRetailer">View All Products</a>
     <a href="updateProfile.jsp">Update Profile</a>--> 
        <a href="RetailerServlet?taskType=logout">Logout</a>
    </div>
</div>





</body>
</html>
