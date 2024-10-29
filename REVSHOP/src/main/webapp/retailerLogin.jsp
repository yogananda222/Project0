<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REVSHOP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style> 
        body {
            margin: 0;
            font-family: 'Times New Roman', Times, serif;
            background-image: url('images/retailer2.jpg');
            background-size: cover; 
            background-repeat: no-repeat; 
            background-position: center; 
            height: 100vh;
            display: flex;
            align-items: center; 
            justify-content: center; 
        }

        .main-container {
            padding: 20px;
            border-radius: 10px;
            width: 90%;
            max-width: 600px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
           
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        fieldset {
            border: 1px solid #fff;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
        }

        legend {
            font-weight: bold;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            vertical-align: middle;
        }

        .input-container {
            position: relative;
            color:#000;
        }

        .input-container input[type="text"], 
        .input-container input[type="password"], 
        .input-container input[type="email"] {
            width: 50%;
            padding: 10px 40px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background: transparent;
            color: #000;
            font-size:15px;
        }

        .input-container .icon {
            position: absolute;
            top: 50%;
            left: 10px;
            transform: translateY(-50%);
            color: #333;
        }

        .input-container .toggle-password {
            position: absolute;
            top: 50%;
            right: 200px;
            transform: translateY(-50%);
            cursor: pointer;
            color: #333;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
            width: 60%;
            margin-left:100px;
        }

        button:hover {
            background-color: #45a049;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #000;
            text-decoration: none;
            font-size: 20px;
        }

        a:hover{
            color: #cd4545;
        }

        p {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
    <section class="main-container">
        <h2>Retailer Login</h2>
        <form action="RetailerServlet" method="post">
            <input type="hidden" name="taskType" value="login">
            <table>
                <tr>
                    <td><label for="email"><b></b></label></td>
                    <td>
                        <div class="input-container">
                            <i class="fas fa-envelope icon"></i>
                            <input type="email" id="email" name="emailaddress" placeholder="Enter your email" required autocomplete="email">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><label for="password"><b></b></label></td>
                    <td>
                        <div class="input-container">
                            <i class="fas fa-lock icon"></i>
                            <input type="password" id="password" name="password" placeholder="Create a password" required autocomplete="new-password">
                            <i class="fas fa-eye toggle-password" id="togglePassword"></i>
                        </div>
                    </td>
                </tr>
            </table>
                    <div class="forgot-password"> <a href="retailerForgotPassword.jsp">Forgot Password?</a></div>
            <button type="submit">Login</button>
        </form>

        <a href="retailerRegister.jsp"><b>A New Retailer? Register here!</b></a>


    <p style="color:red;">
        <% if (request.getAttribute("error") != null) { %>
            <%= request.getAttribute("error") %>
        <% } %>
    </p>
    </section>

    <script>
        const togglePassword = document.querySelector('#togglePassword');
        const password = document.querySelector('#password');

        togglePassword.addEventListener('click', function () {
            // Toggle the type attribute
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            // Toggle the eye icon
            this.classList.toggle('fa-eye-slash');
        });
    </script>
</body>
</html>

