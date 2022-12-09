package cats.servlets;

import cats.model.Cat;
import cats.service.CatServiceImplementation;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CreateCat")
public class CreateCat extends HttpServlet {

    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/createCat.jsp").forward(request, response);
    }

    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        Cat cat = new Cat();

        Long age = Long.valueOf(request.getParameter("age"));
        String name = String.valueOf(request.getParameter("name"));
        Long fatherId = Long.valueOf(request.getParameter("fatherId"));
        Long motherId = Long.valueOf(request.getParameter("motherId"));
        String color = String.valueOf(request.getParameter("color"));
        String gender = String.valueOf(request.getParameter("gender"));

        cat.setAge(age);
        cat.setName(name);
        cat.setFatherId(fatherId);
        cat.setMotherId(motherId);
        cat.setColor(color);
        cat.setGender(gender);

        try {
            catServiceImplementation.createCat(cat);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/jsp/createCat.jsp").forward(request, response);

    }
}