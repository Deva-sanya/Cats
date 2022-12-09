<%@ page import="cats.service.CatServiceImplementation" %>
<%@ page import="cats.model.Cat" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 024 24.10.22
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    body{
        background-color: #c7b39b
    }
</style>
<head>
    <title>AllCats</title>
</head>
<body>
<h1> Hello you can see all cats, congrats! </h1>
<table>
    <tr>
        <th>age</th>
        <th>father</th>
        <th>mother</th>
        <th>name</th>
        <th>color</th>
        <th>gender</th>
    </tr>

    <%
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        List<Cat> cats = catServiceImplementation.getAll();

        for (Cat cat : cats) {
            out.print("<tr>"  + "<td>" + cat.getAge() + "</td>" +"<td>" + cat.getFatherName() + "</td>"+ "<td>" + cat.getName() + "</td>" + "<td>" +
                    cat.getColor() + "</td>" + "<td>" + " " + cat.getGender() + "</td>" + "</tr>");
        }
    %>
</table>
<p>
<form action="/Cats_war/jsp/mainJsp.jsp" method="POST"></p>
    <button> Return to main page.</button>
    <br><br>
</form>
<p><h1 align="center">Tap to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats_war/mainJsp"><img src="img/logo.jpg" width="500" height="500" ></a></p>
</body>
</html>
