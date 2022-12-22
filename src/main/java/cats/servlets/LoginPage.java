package cats.servlets;

import cats.model.User;
import cats.service.CatServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginPage")
public class LoginPage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/loginPage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        User userFromDataBase;

        String login = String.valueOf(request.getParameter("login"));
        String password = String.valueOf(request.getParameter("password"));

        user.setLogin(login);
        user.setPassword(password);
        userFromDataBase = catServiceImplementation.getByLogin(login);
        String usersPasswordFromDataBase = userFromDataBase.getPassword();

        if (usersPasswordFromDataBase != null && usersPasswordFromDataBase.equals(password) && userFromDataBase != null) {
            response.sendRedirect("http://localhost:8080/Cats_war/jsp/mainJsp.jsp");
        } else {
            try {
                response.sendRedirect("http://localhost:8080/Cats_war/jsp/signUp.jsp");
            } catch (Exception e) {
                throw new RuntimeException("error password or login!");
            }
        }
    }
}