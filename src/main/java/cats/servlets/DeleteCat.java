package cats.servlets;


import cats.service.CatServiceImplementation;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCat")
public class DeleteCat extends HttpServlet {
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("catId"));
        CatServiceImplementation catServiceImplementation = new CatServiceImplementation();

        catServiceImplementation.deleteById(id);
        request.getRequestDispatcher("/jsp/deleteCat.jsp").forward(request, response);
    }
}