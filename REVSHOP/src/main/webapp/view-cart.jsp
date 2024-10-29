<%@ page import="java.util.List" %>
<%@ page import="com.revshop.entity.cart" %>
<%@ page import="com.revshop.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            // Handle quantity change
            $(".update-quantity").on("change", function() {
                var productId = $(this).data("product-id");
                var quantity = $(this).val();
                
                $.ajax({
                    type: "POST",
                    url: "BuyerServlet",
                    data: {
                        taskType: "updateQuantity",
                        productId: productId,
                        quantity: quantity
                    },
                    success: function(response) {
                        $("#cart").html(response);
                    },
                    error: function() {
                        alert("Error updating quantity. Please try again.");
                    }
                });
            });

            // Handle item removal
            $(".remove-item").on("click", function() {
                var productId = $(this).data("product-id");

                $.ajax({
                    type: "POST",
                    url: "BuyerServlet",
                    data: {
                        taskType: "deleteFromCart",
                        productId: productId
                    },
                    success: function(response) {
                        $("#cart").html(response);
                    },
                    error: function() {
                        alert("Error removing item. Please try again.");
                    }
                });
            });
            
           


            // Handle quantity button clicks
            $(document).on('click', '.quantity-btn', function() {
                var $input = $(this).siblings('input');
                var currentValue = parseInt($input.val());
                var action = $(this).data('action');

                if (action === 'increase') {
                    $input.val(currentValue + 1);
                } else if (action === 'decrease' && currentValue > 1) {
                    $input.val(currentValue - 1);
                }
                
                $input.change(); // Trigger change event to update the cart
            });
        });
    </script>
    <style>
       /* General Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
    color: #333;
    margin: 0;
    padding: 0;
}

h2 {
    text-align: center;
    color: #333;
    margin-top: 20px;
}

/* Cart Table Styles */
#cart {
    width: 80%;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    padding: 10px;
    text-align: center;
    border: 1px solid #ddd;
}

th {
    background-color: #f4f4f4;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

img {
    width: 100px;
    height: auto;
    border-radius: 4px;
}

/* Quantity Input Styles */
.quantity-input {
    display: flex;
    align-items: center;
    justify-content: center;
}

.quantity-input button {
    background-color: #007bff;
    border: none;
    color: #fff;
    padding: 5px 10px;
    cursor: pointer;
    font-size: 16px;
    border-radius: 4px;
}

.quantity-input button:hover {
    background-color: #0056b3;
}

.quantity-input input {
    width: 50px;
    text-align: center;
    margin: 0 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 5px;
}

/* Actions Styles */
td a {
    color: #ff0000;
    text-decoration: none;
    font-weight: bold;
}

td a:hover {
    text-decoration: underline;
}

/* Footer Styles */
tfoot {
    font-weight: bold;
    background-color: #f4f4f4;
}

/* Alerts and Messages */
alert {
    font-size: 16px;
    color: #d9534f;
}

a {
    color: #007bff;
    text-decoration: none;
    font-weight: bold;
    padding: 10px;
    display: inline-block;
    border-radius: 4px;
    background-color: #e7f0ff;
}

a:hover {
    background-color: #cfe3ff;
}

/* Responsive Styles */
@media (max-width: 768px) {
    #cart {
        width: 95%;
    }

    table, th, td {
        display: block;
    }

    th, td {
        text-align: left;
        padding: 10px;
        border: none;
    }

    th {
        background-color: #f4f4f4;
    }

    tr {
        margin-bottom: 10px;
        border-bottom: 1px solid #ddd;
        display: block;
        padding: 10px;
    }
}

    </style>
</head>
<body>
    <h2>Your Shopping Cart</h2>

    <div id="cart">
        <form id="cart-form">
            <table border="1" cellspacing="0" cellpadding="5">
                <thead>
                    <tr>
                        <th>Product Image</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<cart> cartItems = (List<cart>) request.getAttribute("cartItems");
                        double grandTotal = 0.0;

                        if (cartItems != null && !cartItems.isEmpty()) {
                            for (cart item : cartItems) {
                                Product product = item.getProductId();
                                double total = product.getProductPrice() * item.getQuantity();
                                grandTotal += total;
                    %>
                    <tr>
                        <td><img src="<%= product.getImageUrl() %>" alt="Product Image"></td>
                        <td><%= product.getProductName() %></td>
                        <td>$<%= product.getProductPrice() %></td>
                        <td>
                            <div class="quantity-input">
                                <button type="button" class="quantity-btn" data-action="decrease">-</button>
                                <input type="number" class="update-quantity" data-product-id="<%= product.getProductId() %>" value="<%= item.getQuantity() %>" min="1">
                                <button type="button" class="quantity-btn" data-action="increase">+</button>
                            </div>
                        </td>
                        <td>$<%= total %></td>
                        <td>
                            <a type="button" class="remove-item" data-product-id="<%= product.getProductId() %>" href="#">Remove</a>
                        </td>
                    </tr>
                    <% 
                            }
                        }
                    %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4">Grand Total</td>
                        <td>$<%= grandTotal %></td>
                        <td></td>
                    </tr>
                </tfoot>
            </table>
        </form>
        <% 
            String successMessage = (String) request.getAttribute("successMessage");
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (successMessage != null) {
        %>
        <script>
            alert("<%= successMessage %>");
        </script>
        <% 
            }
            if (errorMessage != null) {
        %>
        <script>
            alert("<%= errorMessage %>");
        </script>
        <% 
            }
        %>
        <a href="BuyerServlet?taskType=viewAllProducts">Continue Shopping</a>
        <a href="">Place the order</a>
    </div>
</body>
</html>
