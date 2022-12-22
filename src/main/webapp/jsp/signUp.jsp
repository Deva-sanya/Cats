<%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 022 22.12.22
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <h1>Hello, you can login or sign up on this page.</h1>
    <style type="text/css">
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
            width: 50%;
        }
    </style>
<body>

<form action="/Cats_war/signUp" method="POST">
    <table style="with: 50%">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
    </table>
    <button>Sign Up</button>
</form>
</body>
</html>

