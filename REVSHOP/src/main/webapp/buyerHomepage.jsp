<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arial">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <link rel="stylesheet" href="MyCSS/homepage.css"> <!-- Link to the external CSS file -->
  <title>REVSHOP</title>
</head>
<style>
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
  margin-top: -0px;
  font-family: "Lucida Handwriting", cursive;
}

.site-identity img {
  max-width: 95px;
}

/* Image Container */
.image-container {
  position: relative;
  overflow: hidden;
  width: 100%; /* Ensure the container is responsive */
  max-width: 1200px; /* Set a maximum width */
/*  margin: 0 auto; Center the container */
  height: auto;
  padding: 20px; /* Add padding for spacing */

}

/* Image Slider */
.image-slider {
  display: flex;
  transition: transform 0.2s ease-in-out;
  height: auto;
  will-change: transform;
}

/* Image Item */
.image-item {
  flex: 0 0 20%; /* Adjust item width to be 20% of the container width */
  margin-right: 10px; /* Space between items */
  display: flex;
  flex-direction: column;
  align-items: center;
  transition: transform 0.3s;
}

/* Image Item Image */
.image-item img {
  width: 60%; /* Ensure image takes up the full width of the item */
  height: auto; /* Maintain aspect ratio */
  border-radius: 10px; /* Rounded corners for images */
  filter: drop-shadow(1px 1px 10px rgba(0, 0, 0, 0.2)); /* Subtle shadow */
}

/* Hover Effect for Image Item */
.image-item:hover img {
  transform: scale(1.05); /* Slightly zoom image on hover */
}

/* Style for Image Title Buttons */
.image-title {
  display: inline-block;
  margin-top: 10px;
  font-size: 1em;
  border: none;
  background-color: #fff;
  cursor: pointer;
  transition: transform 0.3s, background-color 0.3s;
  text-decoration: none;
  text-align: center;
  border-radius: 5px; /* Rounded corners for the button */
  padding: 10px 20px; /* Add padding for better button appearance */
}

/* Hover Effect for Image Title Buttons */
.image-title:hover {
  transform: scale(1.1); /* Enlarge button slightly on hover */
  background-color: #f0f0f0; /* Light background color on hover */
}
/* Additional styling for infinite scroll */
.container {
  margin: 20px auto;
  width: 80%;
  overflow: hidden;
  position: relative;
}



.slider {
  display: flex;
  transition: transform 0.7s cubic-bezier(0.25, 0.8, 0.25, 1);
}

.slide {
  min-width: 300px; 
  margin: 0 10px;
}

.slide img {
  width: 100%;
  height: auto;
  display: block;
}

/* CSS for Continuous Loop Animation */
.brands-on-board .slider {
  display: flex;
  transition: none; 
}

/* Footer Styles */
.footer {
  background-color: #faf8f6;
  font-family: Arial, sans-serif;
  color: #333;
}
.footer-content {
  display: flex;
  justify-content: space-around;
  margin-left:50px;
  border-top: 1px solid #ddd;
  flex-wrap: wrap;
}

.footer-section {
  flex: 1;
  min-width: 180px;
  margin: 10px 0;
}

.footer-section h4 {
  font-weight: bold;
  margin-bottom: 10px;
}

.footer-section ul {
  list-style: none;
  padding: 0;
}

.footer-section ul li {
  margin-bottom: 5px;
}

.footer-section ul li a {
  color: #333;
  text-decoration: none;
  transition: color 0.3s ease;
}

.footer-section ul li a:hover {
  color: #000;
}

.social-icons a {
  color: #333;
  margin-right: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: color 0.3s ease;
}

.social-icons a:hover {
  color: #000;
}

</style>
<body>
<header class="site-header">
  <div class="site-identity">
    <a href="HomePage.jsp"><img src="images/RevShop-removebg-preview.png" alt="Site Logo" /></a>
    <h1><a href="HomePage.jsp">REVSHOP</a></h1>
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
    <button class="cart" onclick="window.location.href='view-cart.jsp'"><i class="fa fa-shopping-bag"></i></button>
   <button onclick="window.location.href='BuyerLogedDetails.jsp'" class="login"><i class="fa fa-user-circle"></i></button>
 
  </nav>
</header>

<div class="image-container">
  <div class="image-slider">
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/MakeUp.png" alt="Makeup">
      <button class="image-title">Makeup</button>
    </a>
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/skin.png" alt="Skin Care">
      <button class="image-title">Skin Care</button>
    </a>
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/Hair.png" alt="Hair Care">
      <button class="image-title">Hair Care</button>
    </a>
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/Bath&Body.png" alt="Bath & Body">
      <button class="image-title">Bath & Body</button>
    </a>
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/Best Seller's.png" alt="Best Sellers">
      <button class="image-title">Best Sellers</button>
    </a>
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/Fragrance.png" alt="Fragrance">
      <button class="image-title">Fragrance</button>
    </a>
    <a href="BuyerServlet?taskType=viewAllProducts" class="image-item">
      <img src="images/combos.png" alt="Combos">
      <button class="image-title">Combos</button>
    </a>
  </div>
</div>

<!-- Brands on Board Container -->
<div class="container brands-on-board">
  <h2>Brands on Board</h2>
  <div class="slider infinite-scroll">
    <div class="slide"><img src="images/brands1.png" alt="Brand 1"></div>
    <div class="slide"><img src="images/brands2.png" alt="Brand 2"></div>
    <div class="slide"><img src="images/brands3.png" alt="Brand 3"></div>
    <div class="slide"><img src="images/brands4.png" alt="Brand 4"></div>
    <div class="slide"><img src="images/brands5.png" alt="Brand 5"></div>
    <!-- Clone slides for smooth infinite loop -->
    <div class="slide"><img src="images/brands1.png" alt="Brand 1"></div>
    <div class="slide"><img src="images/brands2.png" alt="Brand 2"></div>
  </div>
</div>


<script src="MyJavaScript/homepage.js" defer></script>
<script>
document.addEventListener("DOMContentLoaded", function () {
	  const brandsSlider = document.querySelector('.brands-on-board .slider');
	  const slideWidth = 300; // Width of each slide
	  let position = 0;

	  function startInfiniteScroll() {
	    // Move the slider to the left continuously
	    position -= 1; // Adjust speed by changing the decrement value

	    if (position <= -slideWidth * 5) { // Check when to reset (number of original slides * width)
	      position = 0; // Reset to the original position
	    }

	    brandsSlider.style.transform = `translateX(${position}px)`;
	    requestAnimationFrame(startInfiniteScroll);
	  }

	  startInfiniteScroll(); // Start the continuous loop
	});

</script>
</body>
<footer class="footer">
  <div class="footer-content">
    <div class="footer-section">
      <h4>Quick Links</h4>
      <ul>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Terms & Conditions</a></li>
        <li><a href="#">Return Policy</a></li>
      </ul>
    </div>
    <div class="footer-section">
      <h4>Make Money with Us</h4>
      <ul>
        <li><a href="retailerRegister.jsp">Sell on RevShop</a></li>
      </ul>
    </div>
    <div class="footer-section">
      <h4>Help Desk</h4>
      <p>Call: +91 9494075192</p>
      <p>Email: yoganandanaidu222@gmail.com</p>
      <p>Monday-Saturday 10AM to 7PM</p>
    </div>
    <div class="footer-section">
      <h4>Follow us on</h4>
      <div class="social-icons">
        <a href="#"><i class="fab fa-instagram"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-youtube"></i></a>
      </div>
    </div>
  </div>
</footer>
</html>
