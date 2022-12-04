<%@ page import="cats.service.CatServiceImplementation" %>
<%@ page import="cats.model.Cat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexchem
  Date: 024 24.10.22
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page of cats</title>
    <style type="text/css">
        body {
            background-color: darkseagreen;
            text-align: center;
        }

        table {
            width: 300px; /* Ширина таблицы */
            border: 5px solid green; /* Рамка вокруг таблицы */
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }

        td {
            text-align: center; /* Выравниваем текст по центру ячейки */
        }

        h1 {
            color: blue;
        }

        h3 {
            color: darkgreen;
        }
    </style>
</head>
<section id="cats">
    <script>
        function findCat() {
            window.location.href = "http://localhost:8080/Cats/jsp/getById.jsp?catId=" + document.querySelector('.messageCheckbox:checked').value;
        }

        function deleteCat() {
            window.location.href = " http://localhost:8080/Cats/jsp/deleteCat.jsp?catId=" + document.querySelector('.messageCheckbox:checked').value;
        }

        function updateColor() {
            window.location.href = " http://localhost:8080/Cats/jsp/update.jsp?catId=" + document.querySelector('.messageCheckbox:checked').value;
        }
    </script>
    <body>

    <h1> Hello you can create data base, congrats! </h1>
    <p>
    <h2>This app made to create data base of cats. You can add new cat, delete cat, update cat and see all cats.
        <br>Enjoy!</br>
    </h2>
    </p>
    <table>
        <tr>
            <h3>List of all cats from data base.</h3>
            <th></th>
            <th>age</th>
            <th>name</th>
            <th>color</th>
            <th>gender</th>
            <th>father</th>
            <th>mother</th>
        </tr>

        <%
            CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
            List<Cat> cats = catServiceImplementation.getAll();

            for (Cat catFromList : cats) {
                {
                    Cat father = catServiceImplementation.getById(catFromList.getFatherId());
                    Cat mother = catServiceImplementation.getById(catFromList.getMotherId());

                    Long fatherId = catFromList.getFatherId();
                    Long motherId = catFromList.getMotherId();
                    String fatherName = null;
                    String motherName = null;

                    if (fatherId == 0) {
                        fatherName = "unknown";
                    } else {
                        fatherName = father.getName();
                    }

                    if (motherId == 0) {
                        motherName = "unknown";
                    } else {
                        motherName = mother.getName();
                    }

                    out.print("<tr><td><input type='checkbox' class= messageCheckbox name='catId' value='" + catFromList.getId() + "' </td><td>" + catFromList.getAge() + "</td>" + "<td>" + catFromList.getName() + "</td>" + "<td>" +
                            catFromList.getColor() + "</td>" + "<td>" + " " + catFromList.getGender() + "</td>" + "<td>" + " " + fatherName + "</td>" + "<td>" + motherName + "</td>" + "</tr>");
                }
            }
        %>
    </table>
    <br>
    <div class="container-buttons">
        <button onclick=deleteCat() type="submit"> Delete cat.
        </button>
        <button onclick=findCat() type="submit"> View information about cat.
        </button>
        <button onclick=updateColor() type="submit"> Update cat.
        </button>
        <form action="/Cats/jsp/createCat.jsp" method="POST">
            <button>Create new cat.</button>
        </form>
    </div>
    </body>
</section>
</html>
