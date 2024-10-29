<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REVSHOP</title>
    <link rel="stylesheet" href="MyCSS/adminHomepage.css">
</head>
<body>

<div class="top-buttons">
    <form action="AdminServlet?taskType=viewUsers" method="post">
        <button type="submit" value="buyer">View Buyers</button>
    </form>
    <form action="AdminServlet?taskType=viewRetailer" method="post">
        <button type="submit" value="retailer">View Sellers</button>
    </form>
    <form action="AdminServlet" method="post">
        <input type="hidden" name="taskType" value="viewPendingRetailers">
        <button type="submit">Retailers Requests</button>
    </form>
    <form action="AdminServlet" method="post">
        <input type="hidden" name="taskType" value="viewComplaints">
        <button type="submit">Complaints</button>
    </form>
</div>

<h2>Manage Buyers</h2>
<div class="form-container">
    <form action="AdminServlet" method="post">
        <input type="hidden" name="taskType" value="blockUser">
        <label for="blockUserId">Block User ID:</label>
        <input type="text" id="blockUserId" name="userId">
        <button type="submit">Block User</button>
    </form>

    <form action="AdminServlet" method="post">
        <input type="hidden" name="taskType" value="unblockUser">
        <label for="unblockUserId">Unblock User ID:</label>
        <input type="text" id="unblockUserId" name="userId">
        <button type="submit">Unblock User</button>
    </form>
</div>

<h2>Manage Retailers</h2>
<div class="form-container">
    <form action="AdminServlet" method="post">
        <input type="hidden" name="taskType" value="blockRetailer">
        <label for="blockRetailerId">Block Retailer ID:</label>
        <input type="text" id="blockRetailerId" name="retailerId">
        <button type="submit">Block Retailer</button>
    </form>

    <form action="AdminServlet" method="post">
        <input type="hidden" name="taskType" value="unblockRetailer">
        <label for="unblockRetailerId">Unblock Retailer ID:</label>
        <input type="text" id="unblockRetailerId" name="retailerId">
        <button type="submit">Unblock Retailer</button>
    </form>
</div>

 <div class="container">
        <h1>Delete User</h1>
        <form action="AdminServlet" method="post">
            <input type="hidden" name="taskType" value="deleteUser">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
            <button type="submit">Delete User</button>
        </form>
    </div>
    
    
        <div class="container">
        <h1>Delete Retailer</h1>
        <form action="AdminServlet" method="post">
            <input type="hidden" name="taskType" value="deleteRetailer">
            <label for="retailerId">Retailer ID:</label>
            <input type="text" id="retailerId" name="retailerId" required>
            <button type="submit">Delete Retailer</button>
        </form>
    </div>
</body>
</html>
