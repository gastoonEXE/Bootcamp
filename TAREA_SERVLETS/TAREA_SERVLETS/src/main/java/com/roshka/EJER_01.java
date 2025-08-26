package com.roshka;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EJER_01")

public class EJER_01 extends HttpServlet {

    private static final String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
    private static final String usuario = "postgres";
    private static final String contraseña = "postgres";

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver: " + e.getMessage());
        }

        List<String> topClientes = new ArrayList<>();

        String sql = "SELECT nombre, apellido, COUNT(*) AS cantidad " +
                "FROM cliente " +
                "JOIN factura ON cliente.id = cliente_id " +
                "GROUP BY nombre, apellido " +
                "ORDER BY cantidad DESC " +
                "LIMIT 10";


        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cantidad = rs.getInt("cantidad");

                String fila = nombre + " " + apellido + " - " + cantidad + " facturas";
                topClientes.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("TOTAL DE CLIENTES: " + topClientes.size());
        request.setAttribute("topClientes", topClientes);
        request.getRequestDispatcher("/EJER_01.jsp").forward(request, response);
    }



//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
////        AGREGAR EL INICIO DEL DRIVER POSTGRES
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.err.println("Error al conectar con la base de datos:" +  e.getMessage());
//        }
//
//        List<String> topClientes = new ArrayList<>();
//
//        String sql = "SELECT nombre, apellido, COUNT(*) AS cantidad " +
//                "FROM cliente " +
//                "JOIN factura ON cliente.id = cliente_id " +
//                "GROUP BY nombre, apellido " +
//                "ORDER BY cantidad DESC";
//
//        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
//             Statement stmt = conexion.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                String nombre = rs.getString("nombre");
//                String apellido = rs.getString("apellido");
//                int cantidad = rs.getInt("cantidad");
//
//                String fila = nombre + " " + apellido + " - " + cantidad + " facturas";
//                topClientes.add(fila);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Error al conectar con la base de datos:" +  e.getMessage());
//            throw new RuntimeException(e);
//        }
//        System.out.println("TOTAL DE CLIENTES: " + topClientes.size());
//        request.setAttribute("topClientes", topClientes);
//        request.getRequestDispatcher("/EJER_01.jsp").forward(request, response);
//
////        request.getRequestDispatcher("/login.jsp").forward(request, response);
//    }

}

//}
