<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REVSHOP</title>
    <style>
    /* General Styles */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
    color: #333;
}

h1 {
    text-align: center;
    color: #007BFF;
    margin-top: 20px;
}

form {
    max-width: 600px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
}

input[type="text"],
input[type="number"],
textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}

textarea {
    resize: vertical;
    height: 100px;
}

button {
    background-color: #007BFF;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

a {
    display: block;
    text-align: center;
    margin-top: 20px;
    color: #007BFF;
    text-decoration: none;
    font-size: 16px;
}

a:hover {
    text-decoration: underline;
}

/* Responsive Design */
@media (max-width: 600px) {
    form {
        padding: 15px;
    }

    button {
        width: 100%;
    }
}
    
    </style>
</head>
<body>
    <h1>Update Product</h1>
    <form id="updateProductForm" action="RetailerServlet" method="post">
        <input type="hidden" name="taskType" value="updateProduct">
        
        <label>ProductId</label>
        <input type="number" id="productId" name="productId" value="">
        
        
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" value="" required>

        <label for="productDescription">Product Description:</label>
        <textarea id="productDescription" name="productDescription" required></textarea>

        <label for="productPrice">Product Price:</label>
        <input type="number" id="productPrice" name="productPrice" value="" step="0.01" required>

        <label for="imageUrl">Image URL:</label>
        <input type="text" id="imageUrl" name="imageUrl" value="" required>

        <label for="inventoryCount">Inventory Count:</label>
        <input type="number" id="inventoryCount" name="inventoryCount" value="" required>

        <button type="submit">Update Product</button>
    </form>
    <a href="retailerHomepage.jsp">Back to Homepage</a>
    <script src="scripts.js"></script>
</body>
</html>
