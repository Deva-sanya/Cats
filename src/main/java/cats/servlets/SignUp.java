package cats.servlets;

import cats.model.User;
import cats.service.CatServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignUp")
public class SignUp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/signUp.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();

        String login = String.valueOf(request.getParameter("login"));
        String password = String.valueOf(request.getParameter("password"));

        user.setLogin(login);
        user.setPassword(password);

            try {
                catServiceImplementation.createUser(user);
                response.sendRedirect("http://localhost:8080/Cats_war/jsp/signUp.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }