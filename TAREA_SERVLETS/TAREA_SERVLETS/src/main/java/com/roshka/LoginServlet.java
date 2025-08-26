package com.roshka;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    private static final String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
    private static final String usuario = "postgres";
    private static final String contraseña = "postgres";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String loginMessage = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al conectar con la base de datos:" +  e.getMessage());
        }




        String sql = "SELECT nombre, apellido, COUNT(*) AS cantidad " +
                    "FROM cliente " +
                    "JOIN factura ON cliente.id = cliente_id " +
                    "GROUP BY nombre, apellido " +
                    "ORDER BY cantidad DESC";

//        try {
//            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
//
//            String sql = "SELECT nombre, apellido, COUNT(*) AS cantidad " +
//                    "FROM cliente " +
//                    "JOIN factura ON cliente.id = cliente_id " +
//                    "GROUP BY nombre, apellido " +
//                    "ORDER BY cantidad DESC";
//
//
//        }
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top clientes con más facturas: \n");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cantidad = rs.getInt("cantidad");

                System.out.printf("%s | %s | %d %n", nombre, apellido, cantidad);
            }

        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos:" +  e.getMessage());
            throw new RuntimeException(e);
        }

        if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
            request.setAttribute("loginMessage", "You are logged in");
        } else  {
            request.setAttribute("loginMessage", "Invalid username or password, please try again");
        }
//        Ejercicio_1();
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

}

/*static void Ejercicio_1(){
//        System.out.println("Ejercicio 1");

    String sql = "SELECT nombre, apellido, COUNT(*) AS cantidad " +
            "FROM cliente " +
            "JOIN factura ON cliente.id = cliente_id " +
            "GROUP BY nombre, apellido " +
            "ORDER BY cantidad DESC";

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
         Statement stmt = conexion.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("Top clientes con más facturas: \n");
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int cantidad = rs.getInt("cantidad");

            System.out.printf("%s | %s | %d %n", nombre, apellido, cantidad);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }


}*/
