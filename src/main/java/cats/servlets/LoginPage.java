package cats.servlets;

import cats.model.Users;
import cats.service.CatServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginPage")
public class LoginPage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/loginPage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        Users user = new Users();

        String login = String.valueOf(request.getParameter("login"));
        String password = String.valueOf(request.getParameter("password"));

        user.setLogin(login);
        user.setLogin(password);
        try {
            catServiceImplementation.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/jsp/loginPage.jsp").forward(request, response);
    }
}