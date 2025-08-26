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

@WebServlet("/EJER_04")

public class EJER_04 extends HttpServlet {

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

//      List<String> topClientes = new ArrayList<>();
        // Crear una lista interna que contiene esos arreglos
        List<String[]> ConsultaFila = new ArrayList<>();


        String sql = "SELECT proveedor.nombre, COUNT(*) AS cantidad " +
                "FROM producto " +
                "JOIN proveedor ON producto.proveedor_id = proveedor.id " +
                "GROUP BY proveedor.nombre " +
                "ORDER BY cantidad DESC " +
                "LIMIT 10; ";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top proveedores por cantidad de productos: \n");
            while (rs.next()) {
                String nombreProveedor = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");

                String[] fila = {nombreProveedor, String.valueOf(cantidad)};
                ConsultaFila.add(fila);

                //System.out.printf("%s | %d usos %n", nombreMoneda, cantidad);
            }


        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("TOTAL DE FILAS: " + ConsultaFila.size());
        request.setAttribute("ConsultaFila", ConsultaFila);
        request.getRequestDispatcher("/EJER_04.jsp").forward(request, response);
    }


}


