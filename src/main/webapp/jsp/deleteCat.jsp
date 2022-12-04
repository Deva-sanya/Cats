<%@ page import="cats.service.CatServiceImplementation" %><%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 025 25.10.22
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cat has deleted.</title>
</head>
<body>
<h1>Cat delete.</h1>
<%
    Long id = Long.valueOf(request.getParameter("catId"));
    CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
    catServiceImplementation.deleteById(id);
%>
<p>
<p><h1 align="center">Tab to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats/mainJsp"><img src="img/logo.jpg" width="500" height="500" ></a></p>
</body>
</html>
