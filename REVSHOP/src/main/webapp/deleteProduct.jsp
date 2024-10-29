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

header {
    background-color: #007BFF;
    color: #fff;
    padding: 20px;
    text-align: center;
}

header h1 {
    margin: 0;
    font-size: 2rem;
}

main {
    display: flex;
    justify-content: center;
    align-items: center;
    height: calc(100vh - 120px); /* Adjust height based on header and footer */
    padding: 20px;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    width: 100%;
}

label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
}

input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}

button {
    background-color: #dc3545;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #c82333;
}

footer {
    background-color: #333;
    color: #fff;
    text-align: center;
    padding: 10px;
    position: absolute;
    bottom: 0;
    width: 100%;
    font-size: 0.9rem;
}

/* Responsive Design */
@media (max-width: 600px) {
    header h1 {
        font-size: 1.5rem;
    }

    main {
        height: auto; /* Adjust height on smaller screens */
    }

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
    <header>
        <h1>Delete Product</h1>
    </header>
    
    <main>
        <form action="RetailerServlet" method="post">
            <input type="hidden" name="taskType" value="deleteProduct">
            <label for="productId">Product ID:</label>
            <input type="text" id="productId" name="productId" required>
            <button type="submit">Delete Product</button>
        </form>
    </main>
    
    <footer>
        <p>&copy; 2024 RevShop</p>
    </footer>
</body>
</html>
