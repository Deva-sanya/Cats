package cats.servlets;

import cats.model.Cat;
import cats.service.CatServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCat")
public class UpdateCat extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cat cat = new Cat();
        request.setAttribute("catId", cat);
        request.setAttribute("age", cat);
        request.setAttribute("name", cat);
        request.setAttribute("gender", cat);
        request.setAttribute("fatherId", cat);
        request.setAttribute("motherId", cat);
        request.setAttribute("color", cat);

        request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        Cat cat = new Cat();

        Long id = Long.valueOf(request.getParameter("catId"));
        Long age = Long.valueOf(request.getParameter("age"));

        String name = String.valueOf(request.getParameter("name"));

        String gender = String.valueOf(request.getParameter("gender"));
        Long fatherId = Long.valueOf(request.getParameter("fatherId"));
        Long motherId = Long.valueOf(request.getParameter("motherId"));

        String color = String.valueOf(request.getParameter("color"));

        cat.setId(id);
        cat.setAge(age);
        cat.setName(name);
        cat.setGender(gender);
        cat.setColor(color);
        cat.setMotherId(motherId);
        cat.setFatherId(fatherId);

        catServiceImplementation.update(cat);
        request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
    }
}