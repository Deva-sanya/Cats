package cats.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainJsp")
public class MainJsp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/mainJsp.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fatherName = String.valueOf(request.getParameter("fatherName"));
        String motherName = String.valueOf(request.getParameter("motherName"));
        Long fatherId = Long.valueOf(request.getParameter("fatherId"));
        Long motherId = Long.valueOf(request.getParameter("motherId"));
        request.getRequestDispatcher("/jsp/mainJsp.jsp").forward(request, response);
    }
}

