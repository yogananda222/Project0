<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REVSHOP</title>
    <style>
    
    /* Basic reset and styling */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

h1 {
    text-align: center;
    color: #333;
}

.container {
    width: 80%;
    margin: 0 auto;
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form {
    max-width: 600px;
    margin: 0 auto;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="text"], input[type="email"], textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

textarea {
    resize: vertical;
}

input[type="submit"] {
    background-color: #28a745;
    color: white;
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 4px;
}

input[type="submit"]:hover {
    background-color: #218838;
}

.message {
    color: #d9534f;
    text-align: center;
    margin-bottom: 20px;
}

a {
    display: block;
    text-align: center;
    margin-top: 20px;
    color: #007bff;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}
    
    
    </style>
</head>
<body>
    <h1>Register a Complaint</h1>

    <!-- Display success or error message if available -->
    <c:if test="${not empty message}">
        <div class="message"></div>
    </c:if>

    <form action="BuyerServlet?taskType=registerComplaint" method="post">
       

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="contact">Contact Number:</label>
        <input type="text" id="contact" name="contact" required><br><br>

        <label for="complaintSubject">Complaint Subject:</label>
        <input type="text" id="complaintSubject" name="complaintSubject" required><br><br>

        <label for="complaintBody">Complaint Body:</label><br>
        <textarea id="complaintBody" name="complaintBody" rows="6" cols="40" required></textarea><br><br>

        <input type="submit" value="Submit Complaint">
    </form>

    <a href="HomePage.jsp">Back to Home</a>
</body>
<script>

document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', function(event) {
        let valid = true;
        let message = '';

        const name = document.getElementById('name').value.trim();
        const email = document.getElementById('email').value.trim();
        const contact = document.getElementById('contact').value.trim();
        const complaintSubject = document.getElementById('complaintSubject').value.trim();
        const complaintBody = document.getElementById('complaintBody').value.trim();

        if (!name) {
            message += 'Name is required.\n';
            valid = false;
        }
        
        if (!email || !validateEmail(email)) {
            message += 'A valid email is required.\n';
            valid = false;
        }

        if (!contact) {
            message += 'Contact number is required.\n';
            valid = false;
        }

        if (!complaintSubject) {
            message += 'Complaint subject is required.\n';
            valid = false;
        }

        if (!complaintBody) {
            message += 'Complaint body is required.\n';
            valid = false;
        }

        if (!valid) {
            alert(message);
            event.preventDefault();
        }
    });

    function validateEmail(email) {
        const re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        return re.test(email);
    }
});


</script>
</html>
