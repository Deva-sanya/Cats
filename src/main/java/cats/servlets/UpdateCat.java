package cats.servlets;

import cats.model.Cat;
import cats.service.CatServiceImplementation;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCat")
public class UpdateCat extends HttpServlet {
    public Long catId;

    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        catId = Long.valueOf(request.getParameter("catId"));
        request.setAttribute("age", 10);
        request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);

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

        cat.setId(catId);
        cat.setAge(age);
        cat.setName(name);
        cat.setFatherId(fatherId);
        cat.setMotherId(motherId);
        cat.setColor(color);
        cat.setGender(gender);
        catServiceImplementation.update(cat);

        request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
    }
}