<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="MyCSS/login.css">
    <script src="MyJavaScript/login.js" defer></script>
    <style>
    body {
  font-family: Helvetica, Arial, sans-serif;
  margin: 0;
}

a {
  text-decoration: none;
  color: #000;
}
    .site-header { 
      position: sticky; /* Make the header sticky */
      top: 0; /* Stick to the top of the viewport */
      border-bottom: 1px solid rgba(255, 255, 255, 0.3); /* Slightly more visible border */
      padding: .5em 1em;
      display: flex;
      align-items: center;
      justify-content: space-between; 
      background: rgba(255, 255, 255, 0.2); /* Glass effect background color */
      backdrop-filter: blur(100px); /* Apply blur effect */
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2); /* Optional: Add shadow for better glass effect */
      z-index: 1000; /* Ensure it sits above other content */
    }

    .site-header::before {
      content: "";
      position: absolute; /* Position the pseudo-element absolutely */
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-image: url("images/header-background.png"); /* Background image URL */
      background-size: cover; /* Cover the entire header */
      background-position: center; /* Center the background image */
      filter: blur(10px); /* Apply blur effect to the background image */
      z-index: -1; /* Place the pseudo-element behind other content */
    }

    .site-identity {
      display: flex;
      align-items: center;
      position: relative; /* Position relative to ensure it sits above the pseudo-element */
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
    
    .body {
    background-image: url("images/background-image.jpg");
    background-size: cover;
    background-position: center 30%;
    background-repeat: no-repeat;
    width: 100%;
    height: 80vh;
    position: relative;
	}
	
	#submit-button {
    width: 40%;
    padding: 10px;
    background-color:#FB6F90;
    border: none;
    color:#000;
    border-radius: 4px;
    cursor: pointer;
    font-size: 19px;
    margin-left:100px;
   }

button:hover {
    color: #FB6F90;
}

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
  color: #000; /* Adjust text color for visibility on glass effect */
  font-size: 1em;
  padding: 8px;
}

.nav-links a:hover {
  color: #ff6035;
}

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
    color: #000; /* Adjust icon color for visibility */
}

.search-bar .login:hover,
.search-bar .favourite:hover,
.search-bar .cart:hover {
        color: rgba(255, 255, 255, 0.8); 
}

        .main-content {
            flex: 1;
            display: flex;
            justify-content: start-flex; /* Center content horizontally */
            align-items: center;
            background-image: url("images/background-image.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            padding: 2em; /* Add some padding around the content */
            
        }

        .form-container {
        
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 400px;
           	margin-left:100px;
        }
        h2{
        	color:#fff;
        	font-size:46px;
        }
        
        h6{
        	color:#fff;
        }
        

        form {
            width: 100%;
            font-size:20px;
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
            color: #ffff;
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
.forgot-password{
	margin-bottom:10px;


}
.forgot-password a{

	margin-left:250px;
	font-size:16px;
	color:#fff;

}

#submit-button {
    width: 40%;
    padding: 10px;
    background-color:#FB6F90;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    margin-left:100px;
   }

button:hover {
    color: #FB6F90;
}

.options {
    text-align: center;
    margin-top: 20px;
    color:#fff;
}

.options a {
    text-decoration: none;
    margin: 0 10px;
    color:#fff;
}

.options a:hover {
    text-decoration: underline;
}

/* Custom alert box */
        .custom-alert {
            display: none;
            position: fixed;
            top: 20%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #f8d7da;
            color: #721c24;
            padding: 20px;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            z-index: 1000;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .custom-alert button {
            margin-top: 10px;
            padding: 5px 10px;
            border: none;
            background-color: #721c24;
            color: #fff;
            border-radius: 3px;
            cursor: pointer;
        }

        .custom-alert button:hover {
            background-color: #501316;
        }
   
    
    </style>
</head>
<body>
<header class="site-header">
  <div class="site-identity">
    <a href="HomePage.jsp"><img src="images/RevShop-removebg-preview.png" alt="Site Logo" /></a>
    <h1><a href="HomePage.jsp">REVCOSMETICS</a></h1>
  </div>  
  <nav class="search-bar">
    <div class="nav-links">
      <a href="#"><b>BRANDS</b></a>
      <a href="#"><b>MAKEUP</b></a>
      <a href="#"><b>SKIN CARE</b></a>
      <a href="#"><b>FRAGRANCE</b></a>
      <a href="#"><b>COMBOS</b></a>
    </div>
    <button class="favourite"><i class="fa fa-heart"></i></button>
    <button class="cart" onclick="window.location.href='view-cart.jsp'" ><i class="fa fa-shopping-bag"></i></button>
    <button onclick="window.location.href='register.jsp'" class="login"><i class="fa fa-user-circle"></i></button>
  </nav>
</header>
<!-- Login Form -->
    <section class="main-content">
        <div class="form-container">
    <h2>Sign In</h2>
    <form id="loginForm" action="BuyerServlet" method="post">
        <input type="hidden" name="taskType" value="login">
        
                <fieldset>
                    <legend>Email</legend>
                    <div>
                        <i class="fa fa-envelope icon"></i>
                        <input type="email" id="email" name="email"  class="icon-input" required autocomplete="email">
                    </div>
                </fieldset>
        
                <fieldset>
                    <legend>Create Password</legend>
                    <div class="password-container">
                        <i class="fa fa-lock icon"></i>
                        <input type="password" id="password" name="password"  class="icon-input" required autocomplete="new-password">
                        <i class="fa fa-eye toggle-password" id="togglePassword"></i>
                    </div>
                </fieldset>

                
        <div class="forgot-password"> <a href="forgotPassword.jsp">Forgot Password?</a></div>
        <button id="submit-button" type="submit">Login</button>
        
        <p style="color:red;" id="errorMessage">
            <% if (request.getAttribute("error") != null) { %>
                <%= request.getAttribute("error") %>
            <% } %>
        </p>
    </form>
    <div class="options">
        Not a member..? <a href="register.jsp">Register here!</a>
    </div>
</div>
</section>
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
