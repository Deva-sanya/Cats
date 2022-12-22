<%@ page import="cats.model.User" %><%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 011 11.12.22
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout page</title>
</head>
<body>
<h1>See you again soon, have a nice day!</h1>
<p><h1 align="center">Tap to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats_war/mainJsp"><img src="img/logo.jpg" width="500" height="500" method="POST"></a></p>
<form action="/Cats_war/signUp" method="POST">
    <button>Sign Up</button>
</form>
<form action="/Cats_war/login" method="POST">
    <button>Login</button>
</form>
</body>
</html>
