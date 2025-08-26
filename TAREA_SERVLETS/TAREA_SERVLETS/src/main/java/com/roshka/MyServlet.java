package com.roshka;

// (Tomcat no encuentra la clase jakarta.servlet.http.HttpServlet en el classpath, lo que impide instanciar tu servlet.
// Este error es típico cuando hay una incompatibilidad entre la versión de Tomcat y las dependencias del proyecto.)

//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.ServletException;
//javax.servlet.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;




import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends  HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        super.doGet(req, resp);

        // ESTA CLASE GENERA UNA RESPUESTA HTML LA CUAL SE ACCEDE A TRAVES DE UN URL PATTERN
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MyServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet MyServlet</h1>");
        out.println("</body>");
        out.println("</html>");

    }

    public MyServlet() {
        System.out.println("MyServlet instantiated");
    }

}
