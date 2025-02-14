package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/student")
public class ServletStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String group = "IA-44";
        String subgroup = "35";
        String image = "";
        String dateOfBirth = "";

        if (!("Аріна".equals(name) && "Олех".equals(surname)) &&
                !("Дмитро".equals(name) && "Гладіголов".equals(surname)) &&
                !("Дмитро".equals(name) && "Набоков".equals(surname))) {
            request.getRequestDispatcher("/wrong-value.jsp").forward(request, response);
        }

        if ("Аріна".equals(name) && "Олех".equals(surname)) {
            dateOfBirth = "10.05.2007";
            image = "images/arinaO.jpg";
        }
        if ("Дмитро".equals(name) && "Гладіголов".equals(surname)) {
            dateOfBirth = "02.03.2006";
            image = "images/dimaH.jpg";
        }
        if ("Дмитро".equals(name) && "Набоков".equals(surname)) {
            dateOfBirth = "05.07.2005";
            image = "images/dimaN.jpg";
        }

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("group", group);
        request.setAttribute("subgroup", subgroup);
        request.setAttribute("dateOfBirth", dateOfBirth);
        request.setAttribute("image", image);

        request.getRequestDispatcher("js/student.jsp").forward(request, response);

    }
}

