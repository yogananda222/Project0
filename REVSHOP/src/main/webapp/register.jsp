<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        /* Basic reset and body styling */
        body {
            font-family: Helvetica, Arial, sans-serif;
            margin: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }

        /* Remove text decoration and set default link color */
        a {
            text-decoration: none;
            color: #000;
        }

        /* Header styling with sticky position and background effects */
        .site-header {
            position: sticky;
            top: 0;
            border-bottom: 1px solid rgba(255, 255, 255, 0.3);
            padding: .5em 1em;
            display: flex;
            align-items: center;
            justify-content: space-between;
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(100px);
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
            z-index: 1000;
        }

        /* Background blur effect for header */
        .site-header::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: url("images/header-background.png");
            background-size: cover;
            background-position: center;
            filter: blur(10px);
            z-index: -1;
        }

        /* Site identity and logo styling */
        .site-identity {
            display: flex;
            align-items: center;
            position: relative;
        }

        .site-identity h1 {
            font-size: 1.5em;
            margin: .7em 0 .3em 0;
            display: inline-block;
            margin-left: 10px;
            font-family: "Lucida Handwriting", cursive;
        }

        .site-identity img {
            max-width: 95px;
        }

        /* Navigation bar and links styling */
        .nav-bar {
            display: flex;
            align-items: center;
            width: 100%;
            justify-content: flex-end;
        }

        .nav-links {
            display: flex;
            gap: 30px;
            margin-right: 30px;
        }

        .nav-links a {
            color: #000;
            font-size: 1em;
            padding: 8px;
        }

        .nav-links a:hover {
            color: #ff6035;
        }

        /* Search bar and icon buttons styling */
        .search-bar {
            display: flex;
            align-items: center;
        }

        .search-bar .search-button,
        .search-bar .login,
        .search-bar .favourite,
        .search-bar .cart {
            background: none;
            border: none;
            margin-left: 20px;
            cursor: pointer;
            font-size: 1.5em;
        }

        .search-bar .search-button i,
        .search-bar .login i,
        .search-bar .favourite i,
        .search-bar .cart i {
            color: #000;
        }

        .search-bar .login:hover,
        .search-bar .favourite:hover,
        .search-bar .cart:hover {
            color: rgba(255, 255, 255, 0.8);
        }

        /* Main content area styling with background image */
        .main-content {
            flex: 1;
            display: flex;
            justify-content: start-flex;
            align-items: center;
            background-image: url("images/background-image.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            padding: 2em;
        }

        /* Form container styling */
        .form-container {
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 400px;
            margin-left: 100px;
        }

        h1 {
            color: #fff;
            font-size: 36px;
        }

        h6 {
            color: #fff;
        }

        /* Form elements styling */
        form {
            width: 100%;
            font-size: 20px;
        }

        fieldset {
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 1px;
            margin-bottom: 20px;
            position: relative;
        }

        legend {
            font-weight: bold;
            padding: 0 10px;
            color: #fff;
            border-radius: 4px;
            margin-left: 10px;
            font-size: 1.1em;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 20px;
            color: #fff;
            background-color: transparent;
            border: none;
        }

        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            outline: none;
        }

        input.icon-input {
            padding-left: 40px;
        }

        .icon {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: #fff;
        }

        #togglePassword {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            color: #fff;
        }

        /* Button styling */
        button {
            width: 100%;
            padding: 10px;
            background-color: #ff6035;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #000;
        }

        /* Text and link styling */
        p {
            text-align: center;
            color: #fff;
        }

        p a {
            color: #ff6035;
            text-decoration: none;
        }

        p a:hover {
            text-decoration: underline;
        }

        /* Error message styling */
        p.error {
            color: red;
            text-align: center;
        }

        .error-message {
            color: red;
            font-size: 0.9em;
            margin-top: 5px;
            display: none;
        }

        input.error {
            border-color: red;
        }

        input:focus.error {
            box-shadow: 0 0 5px rgba(255, 0, 0, 0.5);
        }

        /* Password field container styling */
        .password-container {
            position: relative;
        }

        .password-container .fa-eye {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
        }
    </style>
</head>
<body>
    <!-- Site Header with logo, site name, and navigation bar -->
    <header class="site-header">
        <div class="site-identity">
            <a href="HomePage.jsp"><img src="images/RevShop-removebg-preview.png" alt="Site Logo" /></a>
            <h1><a href="HomePage.jsp">REVCOSMETICS</a></h1>
        </div>
        <nav class="search-bar">
            <div class="nav-links">
                <a href="#"><b>BRANDS</b></a>
                <a href="#"><b>MAKEUP</b></a>
                <a href="#"><b>SKINCARE</b></a>
                <a href="#"><b>FRAGRANCE</b></a>
                <a href="#"><b>COMBOS</b></a>
            </div>
            <button class="favourite"><i class="fa fa-heart"></i></button>
            <button class="cart"><i class="fa fa-shopping-bag"></i></button>
            <button onclick="window.location.href='register.jsp'" class="login"><i class="fa fa-user-circle"></i></button>
        </nav>
    </header>

    <!-- Main Content Area with a registration form -->
    <section class="main-content">
        <div class="form-container">
            <h1>Register</h1>
            <h6>Please fill the below details</h6>
            <form id="registerForm" action="BuyerServlet" method="post">
                <!-- Hidden field to pass task type -->
                <input type="hidden" name="taskType" value="register">

                <!-- Name input field -->
                <fieldset>
                    <legend>Name</legend>
                    <div class="password-container">
                        <i class="fa fa-user icon"></i>
                        <input type="text" id="name" name="name" class="icon-input" required>
                        <p class="error-message" id="nameError">Please enter your name</p>
                    </div>
                </fieldset>

                <!-- Email input field -->
                <fieldset>
                    <legend>Email</legend>
                    <div class="password-container">
                        <i class="fa fa-envelope icon"></i>
                        <input type="email" id="email" name="email" class="icon-input" required>
                        <p class="error-message" id="emailError">Please enter a valid email</p>
                    </div>
                </fieldset>

                <!-- Password input field -->
                <fieldset>
                    <legend>Password</legend>
                    <div class="password-container">
                        <i class="fa fa-lock icon"></i>
                        <input type="password" id="password" name="password" class="icon-input" required>
                        <i class="fa fa-eye toggle-password" id="togglePassword"></i>
                        <p class="error-message" id="passwordError">Please enter a password</p>
                    </div>
                </fieldset>

                <!-- Phone input field -->
                <fieldset>
                    <legend>Phone</legend>
                    <div class="password-container">
                        <i class="fa fa-phone icon"></i>
                        <input type="text" id="phone" name="contact" class="icon-input" required>
                        <p class="error-message" id="phoneError">Please enter your phone number</p>
                    </div>
                </fieldset>
                
				<!-- Residence input field -->
                <fieldset>
                    <legend>Residence</legend>
                    <div class="password-container">
                        <i class="fa fa-home icon"></i>
                        <input type="text" id="phone" name="residence" class="icon-input" required>
                    </div>
                </fieldset>

                <!-- Register button -->
                <button type="submit">REGISTER</button>
                <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
            </form>
        </div>
    </section>

    <!-- Script to toggle password visibility -->
    <script>
    const togglePassword = document.querySelector("#togglePassword");
    const password = document.querySelector("#password");

    togglePassword.addEventListener("click", function() {
        // Toggle the type attribute between 'password' and 'text'
        const type = password.getAttribute("type") === "password" ? "text" : "password";
        password.setAttribute("type", type);

        // Toggle the eye icon classes
        this.classList.toggle("fa-eye");
        this.classList.toggle("fa-eye-slash");
    });

    </script>
</body>
</html>
