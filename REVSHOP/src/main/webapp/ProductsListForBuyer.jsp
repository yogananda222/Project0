<%@ page import="java.util.List" %>
<%@ page import="com.revshop.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arial">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>REVSHOP</title>
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
/* Product Cards Container */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 100px;
}

.row{
  gap:60px;
}

/* Product Card Styling */
.product-card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100%;
  border: 1px solid #ddd;
  border-radius: 5px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

/* Image Styling */
.product-card img {
  max-height: 200px;
  object-fit: contain;
  border-bottom: 1px solid #ddd;
}

/* Product Card Body */
.product-card-body {
  padding: 15px;
  text-align: center;
}

/* Product Title */
.product-card-title {
  font-size: 1.2em;
  margin-bottom: 10px;
  color: #333;
}

/* Product Price */
.product-card-body p {
  margin-bottom: 10px;
  color: #777;
}

/* Quantity Input Styling */
.quantity-input {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}

.quantity-btn {
  border: none;
  background-color: #ddd;
  font-size: 1.2em;
  padding: 5px 10px;
  cursor: pointer;
}

.quantity-btn:hover {
  background-color: #ccc;
}

.quantity-input input {
  width: 50px;
  text-align: center;
  font-size: 1em;
  border: 1px solid #ddd;
  border-radius: 3px;
}

/* Add to Cart Button */
.btn-add-to-cart {
  background-color: #ff6035;
  color: #fff;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1em;
  width: 100%;
  margin-top: 10px;
  transition: background-color 0.3s ease;
}

.btn-add-to-cart:hover {
  background-color: #e6552e;
}

/* Ensuring All Product Cards Have the Same Height */
.row {
  display: flex;
  flex-wrap: wrap;
}

.col-md-4 {
  display: flex;
}

.product-card {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.product-card-body {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  flex-grow: 1;
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
</head>
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
    <div class="container mt-4">
        <h1 class="mb-4">Product List</h1>
        <div class="row">
            <% 
                List<Product> products = (List<Product>) request.getAttribute("products");
                
                if (products == null || products.isEmpty()) {
            %>
            <div class="col-12 no-products">
                <p>No products available.</p>
            </div>
            <% 
                } else {
                    for (Product product : products) {
            %>
            <div class="col-md-4 mb-4">
                <div class="card product-card">
                    <!-- Ensure that imageUrl is correct or prepend context path if necessary -->
                    <img src="<%= product.getImageUrl() %>" alt="<%= product.getProductName() %>" class="card-img-top">
                    <div class="card-body product-card-body">
                        <h5 class="card-title product-card-title"><%= product.getProductName() %></h5>
                        <p class="card-text">Price: $<%= product.getProductPrice() %></p>
                        <p class="card-text"><%= product.getProductDescription() %></p>
                        
                        <!-- Add to Cart Form -->
                        <form action="BuyerServlet" method="post">
                            <input type="hidden" name="taskType" value="addToCart">
                            <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                            <div class="form-group">
                                <label for="quantity-<%= product.getProductId() %>">Quantity:</label>
                                <div class="quantity-input">
                                    <button type="button" class="quantity-btn" data-action="decrease">-</button>
                                    <input type="number" id="quantity-<%= product.getProductId() %>" name="quantity" value="1" min="1" required class="form-control">
                                    <button type="button" class="quantity-btn" data-action="increase">+</button>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-add-to-cart">Add to Cart</button>
                        </form>
                        
                    </div>
                </div>
            </div>
            <% 
                  }
                }
            %>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        document.querySelectorAll('.quantity-btn').forEach(button => {
            button.addEventListener('click', function() {
                const input = this.parentElement.querySelector('input');
                let currentValue = parseInt(input.value);
                if (this.dataset.action === 'increase') {
                    input.value = currentValue + 1;
                } else if (this.dataset.action === 'decrease' && currentValue > 1) {
                    input.value = currentValue - 1;
                }
            });
        });
    </script>
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
    
</body>
</html>