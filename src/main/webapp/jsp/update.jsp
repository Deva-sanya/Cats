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
<form action="/Cats_war/update" method="POST">
    Age of the cat: <input type="number" name="age">
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
            for (Cat catFather : fathersList) {
                out.print("<option value = '"+ catFather.getId()+"'>" + catFather.getName() + " " + catFather.getAge() + "</option>");
            }
            out.print("<option value='0'> unknown </option>");
        %>
    </select>
    <br><br>

    Mothers of the cat:
    <select name = "motherId">
        <%
            List<Cat> mothersList = catServiceImplementation.createMothersList();
            for (Cat catMother : mothersList) {
                out.print("<option value = '"+ catMother.getId()+"'>" + catMother.getName() + " " + catMother.getAge() + "</option>");
            }
            out.print("<option value='0'> unknown </option>");
        %>
    </select>
    <br><br>
    Color of the cat: <input type="text" name="color">
    <br><br>
    <button>Update cat.</button>
</form>
<p>
<p><h1 align="center">Tab to logo to go to main page.</h1></p>
<p><a href="http://localhost:8080/Cats_war/mainJsp"><img src="img/logo.jpg" width="500" height="500" method="POST"></a></p>
</body>
</html>