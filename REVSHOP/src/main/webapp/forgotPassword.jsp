<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <link rel="stylesheet" href="MyCSS/forgotPassword.css"> 
    <script src="MyJS/forgotPassword.js" defer></script>
</head>
<body>
    <h2>Update Password</h2>

    <!-- Display any error message -->
    <div id="error-message" class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <!-- Password update form -->
    <form id="update-password-form" action="BuyerServlet" method="post">
        <input type="hidden" name="taskType" value="updatePassword">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br><br>

        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>
        <br><br>

        <input type="submit" value="Update Password">
    </form>

    <br>
    <a href="login.jsp">Back to Login</a>
</body>
</html>
