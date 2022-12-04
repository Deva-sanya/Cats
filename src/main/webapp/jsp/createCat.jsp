<%@ page import="cats.model.Cat" %>
<%@ page import="cats.service.CatServiceImplementation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 027 27.10.22
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating new cat!</title>
</head>
<section id="create">
    <body>
    <h1>Lets create your cat!</h1>
    <style type="text/css">
        body {
            background-color: coral;
            text-align: center;
        }
    </style>

    <form action="/Cats/create" method="POST">

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
        <br/>
        <button> Select.</button>
        <br><br>
    </form>
    <p><h1 align="center">Tab to logo to go to main page.</h1></p>
    <p><a href="http://localhost:8080/Cats/mainJsp"><img src="img/logo.jpg" width="500" height="500" ></a></p>
    </body>
</section>
</html>
