<%@ page import="cats.service.CatServiceImplementation" %>
<%@ page import="cats.model.Cat" %>
<%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 026 26.10.22
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get cat by id.</title>
</head>
<body>
<h1>Cat found.</h1>

<p>Cat age: ${age}</p>
<p>Cat name: ${name}</p>
<p>Cat color: ${color}</p>
<h1 align="center">Tap to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats_war/mainJsp"><img src="img/logo.jpg" width="500" height="500" method="POST"></a>
</p>
</body>
</html>
