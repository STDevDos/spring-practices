package com.froyo.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Froy
 */
@WebServlet(urlPatterns = "/app/pais/*", loadOnStartup = 1)
public class PaisServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getSession();
        out.println("<h3>México</h3>");
        out.println("User: " + request.getServletContext().getAttribute("user"));
        out.println("</br>");
        out.println("Name: " + request.getServletContext().getAttribute("name"));
        out.println("</br>");
        out.println("Dato: " + request.getServletContext().getAttribute("dato"));
    }
}

