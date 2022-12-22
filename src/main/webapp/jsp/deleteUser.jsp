<%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 018 18.12.22
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Delete Account</title>
<p>
<h1 align="center">Tap to logo to go to main page.</h1></p>
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

<form action="/Cats_war/deleteUser" method="POST">
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
    <button>Delete account</button>
</form>
<p><a href="http://localhost:8080/Cats_war/mainJsp"><img src="img/logo.jpg" width="500" height="500" method="POST"></a>
</p>
</body>
</html>
