package cats.servlets;

import cats.model.User;
import cats.service.CatServiceImplementation;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();

        String login = String.valueOf(request.getParameter("login"));
        String password = String.valueOf(request.getParameter("password"));

        user.setLogin(login);
        user.setPassword(password);

        catServiceImplementation.deleteUser(login);
        request.getRequestDispatcher("/jsp/deleteUser.jsp").forward(request, response);
    }
}
