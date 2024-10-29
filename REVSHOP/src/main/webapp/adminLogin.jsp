<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVSHOP</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
}

.main-container {
    background-image: url("images/ADMIN.jpeg");
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    width: 100%;
    height: 98vh; /* Full viewport height */
    display: flex;
    flex-direction: column; /* Arrange elements vertically */
    align-items: center;
    justify-content: center;
    padding-top: 20px; /* Space at the top */
}

h1 {
    margin-bottom: 50px;
    color: #333;
    font-size: 30px;
}

form {
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent background for the form */
}

div {
    margin-bottom: 15px;
    position: relative;
}

label {
    font-weight: bold;
    display: block;
    margin-bottom: 5px;
    color: #555;
}

input[type="text"], input[type="email"], input[type="password"] {
    width: 100%;
    padding: 15px 35px 10px 40px; /* Add space for the icon */
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    background: transparent;
}

.icon {
    position: absolute;
    top: 35px;
    left: 10px;
    font-size: 16px;
    color: #555;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

button:hover {
    background-color: #45a049;
}

p {
    text-align: center;
    color: #333;
    margin-top: 20px;
}

a {
    color: #4CAF50;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

.toggle-password {
    position: absolute;
    top: 35px;
    right: 10px;
    cursor: pointer;
    font-size: 16px;
    color: #555;
}
</style>
</head>
<body>
    <section class="main-container">
        <h1>Admin Register</h1>
        <form action="AdminServlet" method="post">
            <input type="hidden" name="taskType" value="login">
            
            <div>
                <label for="email">Email:</label>
                <i class="fas fa-envelope icon"></i>
                <input type="email" id="email" name="email" required autocomplete="email">
            </div>

            <div>
                <label for="password">Password:</label>
                <i class="fas fa-lock icon"></i>
                <input type="password" id="password" name="password" required autocomplete="new-password">
                <i class="fas fa-eye toggle-password" onclick="togglePassword()"></i>
            </div>

            <button type="submit">Register</button>
        </form>

    <p style="color:red;">
        <% if (request.getAttribute("error") != null) { %>
            <%= request.getAttribute("error") %>
        <% } %>
    </p>
    </section>

    <script>
        function togglePassword() {
            var passwordInput = document.getElementById('password');
            var toggleIcon = document.querySelector('.toggle-password');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.classList.remove('fa-eye');
                toggleIcon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                toggleIcon.classList.remove('fa-eye-slash');
                toggleIcon.classList.add('fa-eye');
            }
        }
    </script>
</body>
</html>
