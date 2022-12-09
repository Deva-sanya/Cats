<%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 008 08.11.22
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        form {
            border: 3px solid #f1f1f1;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
        #mainPage{
            background-color: darkolivegreen;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }
    </style>
<body>
<form action="/Cats_war/login" method="POST">
    Login: <input type="text" name="login">
    <br><br>
    Password: <input type="password" name="password">
    <br><br>
    <button> Login.</button>
    <br/>
</form>
<p>
<form action="/Cats_war/mainJsp" method="POST">
    <button id ="mainPage"> Go to site. </button>
    <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
    <br><br>
</form>
</p>
</body>
</html>
