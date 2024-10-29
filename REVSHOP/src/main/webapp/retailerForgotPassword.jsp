<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVSHOP</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    color: #333;
    margin: 0;
    padding: 0;
    text-align: center;
}

/* Heading styles */
h2 {
    color: #0056b3;
    margin-top: 50px;
}

/* Form container */
form {
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    text-align: left;
}

/* Label styles */
label {
    display: block;
    font-size: 16px;
    margin-bottom: 5px;
}

/* Input field styles */
input[type="email"],
input[type="password"] {
    width: calc(100% - 22px); /* Full width minus padding and border */
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

/* Submit button styles */
input[type="submit"] {
    background-color: #0056b3;
    color: #fff;
    border: none;
    padding: 10px 15px;
    font-size: 16px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

input[type="submit"]:hover {
    background-color: #004494;
}

/* Error message styles */
.error-message {
    margin-bottom: 20px;
    font-size: 14px;
}

/* Link styles */
a {
    color: #0056b3;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

</style>
</head>
<body>
    <h2>Update Password</h2>

    <!-- Display any error message -->
    <div id="error-message" class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <!-- Password update form -->
    <form id="update-password-form" action="RetailerServlet" method="post">
        <input type="hidden" name="taskType" value="updatePassword">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="emailaddress" required>
        <br><br>

        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>
        <br><br>

        <input type="submit" value="Update Password">
    </form>

    <br>
    <a href="retailerLogin.jsp">Back to Login</a>
</body>
</html>