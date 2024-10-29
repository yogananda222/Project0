<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <div class="container">
        <h1>Order Placed Successfully!</h1>
        
        <p>Thank you for your purchase. Your order has been placed successfully.</p>

        <h3>Order Details:</h3>
        <table class="order-details-table">
            <tr>
                <th>Order ID:</th>
                <td><%= request.getAttribute("orderId") %></td>
            </tr>
            <tr>
                <th>Cart ID:</th>
                <td><%= request.getAttribute("cartId") %></td>
            </tr>
            <tr>
                <th>Buyer Email:</th>
                <td><%= request.getAttribute("email") %></td>
            </tr>
            <tr>
                <th>Retailer ID:</th>
                <td><%= request.getAttribute("retailerId") %></td>
            </tr>
            <tr>
                <th>Order Date:</th>
                <td><%= request.getAttribute("orderDate") %></td>
            </tr>
            <tr>
                <th>Order Time:</th>
                <td><%= request.getAttribute("orderTime") %></td>
            </tr>
            <tr>
                <th>Order Amount:</th>
                <td>$<%= request.getAttribute("orderAmount") %></td>
            </tr>
        </table>

        <a href="buyerHomepage.jsp" class="button">Continue Shopping</a>
    </div>
</body>
</html>
