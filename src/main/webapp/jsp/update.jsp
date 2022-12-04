<%@ page import="cats.service.CatServiceImplementation" %>
<%@ page import="cats.model.Cat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 026 26.10.22
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update cat.</title>
</head>
<body>
<h1>Cat updated</h1>
<form action="/Cats/update" method="POST">

    Age of the cat: <input type="text" name="age">
    <br><br>

    Name of the cat: <input type="text" name="name">
    <br><br>

    Gender of the cat:
    <select name = "gender">
        <option value="female"> female</option>
        <option value="male"> male </option>
    </select>
    <br><br>

    Fathers of the cat:
    <select name = "fatherId">
        <%
            CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
            List<Cat> fathersList = catServiceImplementation.createFathersList();
            for (Cat cat : fathersList) {
                out.print("<option value = '"+ cat.getId()+"'>" + cat.getName() + " " + cat.getAge() + "</option>");
            }
            out.print("<option value='0'> unknown </option>");
        %>
    </select>
    <br><br>

    Mothers of the cat:
    <select name = "motherId">
        <%
            List<Cat> mothersList = catServiceImplementation.createMothersList();
            for (Cat cat : mothersList) {
                out.print("<option value = '"+ cat.getId()+"'>" + cat.getName() + " " + cat.getAge() + "</option>");
            }
            out.print("<option value='0'> unknown </option>");
        %>
    </select>
    <br><br>

    Color of the cat: <input type="text" name="color">
    <br><br>
    <button> Select.</button>
    <br><br>
</form>
<p>
<form action="/Cats/mainJsp" method="GET"></p>
    <button> Return to main page.</button>
    <br><br>
</form>
<p><h1 align="center">Tab to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats/mainJsp"><img src="img/logo.jpg" width="500" height="500" ></a></p>
</body>
</html>