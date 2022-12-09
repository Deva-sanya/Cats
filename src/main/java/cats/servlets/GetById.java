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

import static java.lang.System.out;

@WebServlet(name = "GetById")
public class GetById extends HttpServlet {


    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long catId = Long.valueOf(request.getParameter("catId"));
        Cat cat = new Cat();
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();
        cat = catServiceImplementation.getById(catId);

        request.setAttribute("name",cat.getName());
        request.getRequestDispatcher("/jsp/getById.jsp").forward(request, response);
    }
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/getById.jsp").forward(request, response);
    }
}