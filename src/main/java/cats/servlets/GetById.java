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


@WebServlet(name = "GetById")
public class GetById extends HttpServlet {
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cat cat = new Cat();
        Long id = Long.valueOf(request.getParameter("catId"));
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        cat = catServiceImplementation.getById(id);

        request.setAttribute("cat", cat);
        request.setAttribute("age", cat.getAge());
        request.setAttribute("name", cat.getName());
        request.setAttribute("color", cat.getColor());

        request.getRequestDispatcher("/jsp/getById.jsp").forward(request, response);
    }
}