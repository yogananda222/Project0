<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arial">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <title>REVSHOP</title>
</head>
<style>
/* General Body and Link Styling */
body {
  font-family: Helvetica, Arial, sans-serif;
  margin: 0;
}

a {
  text-decoration: none;
  color: #000;
}

/* Navigation Bar */
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

/* Header Styling */
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
  margin-top: -0px;
  font-family: "Lucida Handwriting", cursive;
}

.site-identity img {
  max-width: 95px;
}

/* Carousel Container */
.carousel{
  position: relative;
  width: 98vw;
  margin: 0 auto;
  overflow: hidden;
  margin-bottom: 100px;
}

/* Carousel Content */
.carousel-content {
  display: flex;
  transition: transform 0.5s ease-in-out;
  width: 100%;
}

/* Carousel Items (Images and Videos) */
.carousel-content img,
.carousel-content video{
  flex-shrink: 0;
  width: 98vw;
  object-fit: cover;
}

/* Carousel Controls */
.carousel-control-left,
.carousel-control-right{
  position: absolute;
  top: 50%;
  width: 50px;
  height: 50px;
  font-size: 2em;
  line-height: 50px;
  text-align: center;
  cursor: pointer;
  transform: translateY(-50%);
  z-index: 10;
  border-radius: 50%;
}

.carousel-control-left {
  left: 10px;
}

.carousel-control-right {
  right: 10px;
}

/* Hover Effects for Carousel Controls */
.carousel-control-left:hover,
.carousel-control-right:hover , .top-picks-content{
  background-color: rgba(0, 0, 0, 0.7);
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


/* Enhanced CSS for New Arrivals and Top Picks */
.container {
  margin: 20px auto;
  width: 90%;
  overflow: hidden;
  position: relative;
}

.container h2 {
  font-size: 2.5rem;
  margin-bottom: 1em;
  color: #333;
  text-align: start-flex;
  
}

.slider {
  display: flex;
  transition: transform 0.5s ease-in-out;
}

.slide {
  min-width: 250px;
  margin: 0 5px;
  overflow: hidden;
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s;
}

.slide:hover {
  transform: scale(1.05);
}

.slide img {
  width: 100%;
  height: auto;
  display: block;
  border-radius: 10px;
}

/* Slider Control Buttons */
.slider-control-left, .slider-control-right {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  color: #000;
  border: none;
  padding: 12px;
  cursor: pointer;
  z-index: 10;
  font-size: 28px;
  transition: transform 0.3s;
  border-radius: 50%;
}

.slider-control-left {
  left: 0;
}

.slider-control-right {
  right: 0;
}

.slider-control-left:hover, .slider-control-right:hover {
  transform: scale(1.1);
}

/* CSS for the Infinite Scroll */
.slider.infinite-scroll {
  display: flex;
  transition: none;
}

/* Additional Styling for Infinite Scroll */
.container {
  position: relative;
  overflow: hidden;
  width: 100%; /* Ensure the container is responsive */
  max-width: 1200px; /* Set a maximum width */
/*  margin: 0 auto; Center the container */
  height: auto;
  padding: 20px; /* Add padding for spacing */
}

/* Top-Picks styling */

.top-picks{
  position: relative;
  width: 60vw;
  height:auto;
  margin: 0 auto;
  overflow: hidden;
  margin-bottom: 100px;
}

.top-picks-content {
  display: flex;
  transition: transform 0.2s ease-in-out;
  height: auto;
  will-change: transform;
}

/* Carousel Items (Images and Videos) */
.top-picks-content img{
 width: 60%; /* Ensure image takes up the full width of the item */
  height: auto; /* Maintain aspect ratio */
  border-radius: 10px; /* Rounded corners for images */
  filter: drop-shadow(1px 1px 10px rgba(0, 0, 0, 0.2)); /* Subtle shadow */
}

.carousel-control-left,
.carousel-control-right{
  position: absolute;
  top: 50%;
  width: 50px;
  height: 50px;
  font-size: 2em;
  line-height: 50px;
  text-align: center;
  cursor: pointer;
  transform: translateY(-50%);
  z-index: 10;
  border-radius: 50%;
}

.carousel-control-left {
  left: 10px;
}

.carousel-control-right {
  right: 10px;
}


.carousel-control-left:hover,
.carousel-control-right:hover , .top-picks-content{
  background-color: rgba(0, 0, 0, 0.7);
}

/* Footer Styles */
.footer {
  background-color: #faf8f6;
  padding: 40px 20px;
  font-family: Arial, sans-serif;
  color: #333;
}

.footer-subscribe {
  text-align: center;
  padding-bottom: 30px;
}

.footer-subscribe h3 {
  font-size: 1.8rem;
  margin-bottom: 10px;
  font-weight: bold;
  font-family:Lucida Sans Unicode;
  
}

.footer-subscribe p {
  font-size: 1.2rem;
  margin-bottom: 20px;
  color: #666;
}

.subscribe-form {
  display: flex;
  justify-content: center;
  gap: 10px;
  flex-wrap: wrap;
}

.subscribe-form input {
  padding: 10px;
  width: 250px;
  border: 1px solid #ddd;
  border-radius: 5px;
  background:transparent;
}

.subscribe-form button {
  padding: 10px 20px;
  background-color: #fff;
  color: #333;
  border: 1px solid #333;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.subscribe-form button:hover {
  background-color: #f5f5f5;
}

.footer-content {
  display: flex;
  justify-content: space-around;
  padding-top: 20px;
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
    <button onclick="window.location.href='login.jsp'" class="login"><i class="fa fa-user-circle"></i></button>
  </nav>
</header>

<div class="carousel">
    <span class="carousel-control-left">&#10094;</span>
    <span class="carousel-control-right">&#10095;</span>
    <div class="carousel-content">
        <video autoplay loop muted playsinline class="back-video" src="images/video1.mp4"></video>
        <img src="images/slide image1.jpg" alt="Slide 1" />
        <img src="images/slide image2.jpg" alt="Slide 2" />
        <img src="images/banner_1.jpg" alt="Banner" />
    </div>
</div>

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
    <div class="slide"><img src="images/brands6.png" alt="Brand 6"></div>
    <div class="slide"><img src="images/brands7.png" alt="Brand 7"></div>
    <div class="slide"><img src="images/brands8.png" alt="Brand 8"></div>
    <div class="slide"><img src="images/brands9.png" alt="Brand 9"></div>
    <div class="slide"><img src="images/brands10.png" alt="Brand 10"></div>
    <div class="slide"><img src="images/brands11.png" alt="Brand 11"></div>
    <div class="slide"><img src="images/brands12png" alt="Brand 12"></div>
	<div class="slide"><img src="images/brands13.png" alt="Brand 13"></div>
  </div>
</div>


<div class="image-container">
<h1>Top Picks</h1>
  <div class="image-slider">
    <a href="makeup.jsp" class="image-item">
      <img src="images/toppicks1.jpg" alt="Makeup">
      <button class="image-title">Lipstick</button>
    </a>
    <a href="skincare.jsp" class="image-item">
      <img src="images/toppicks2.jpg" alt="Skin Care">
      <button class="image-title">Brush Set</button>
    </a>
    <a href="haircare.jsp" class="image-item">
      <img src="images/toppicks3.jpg" alt="Hair Care">
      <button class="image-title">Y2K</button>
    </a>
    <a href="bathbody.jsp" class="image-item">
      <img src="images/toppicks4.jpg" alt="Bath & Body">
      <button class="image-title">Sunscreen</button>
    </a>
    <a href="bestsellers.jsp" class="image-item">
      <img src="images/toppicks5.jpg" alt="Best Sellers">
      <button class="image-title">Foundation</button>
    </a>


  </div>
</div>
<script src="MyJavaScript/homepage.js" defer></script> <!-- Link to the external JavaScript file -->
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
  <div class="footer-subscribe">
    <h3>Don’t miss an update!</h3>
    <p>The latest product drops, offers and stories straight to your phone, plus 20% off your next order</p>
    <form class="subscribe-form">
      <input type="email" placeholder="*Enter your email" required>
      <button type="submit">SUBSCRIBE</button>
    </form>
  </div>
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
