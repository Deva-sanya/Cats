<%@ page import="cats.service.CatServiceImplementation" %>
<%@ page import="cats.model.Cat" %><%--
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
<%
    Cat cat = new Cat();
    CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
    Long id = Long.valueOf(request.getParameter("catId"));
    cat = catServiceImplementation.getById(id);

    if (cat != null) {
        out.print("Age:" + " " + cat.getAge() + " " + "Name:" + " " + cat.getName() + " " + "Color:" + " " + cat.getColor());
    } else out.print("Cat not found");

%>

<p>
<p><h1 align="center">Tab to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats/mainJsp"><img src="img/logo.jpg" width="500" height="500" ></a></p>
</body>
</html>
