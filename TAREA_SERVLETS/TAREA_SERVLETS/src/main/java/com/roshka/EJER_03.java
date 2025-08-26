package com.roshka;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EJER_03")

public class EJER_03 extends HttpServlet {

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


        String sql = "SELECT moneda.nombre, COUNT(*) AS cantidad " +
                "FROM factura " +
                "JOIN moneda ON factura.moneda_id = moneda.id " +
                "GROUP BY moneda.nombre " +
                "ORDER BY cantidad DESC";


        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top monedas más utilizadas: \n");
            while (rs.next()) {
                String nombreMoneda = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");

                String[] fila = {nombreMoneda, String.valueOf(cantidad)};
                ConsultaFila.add(fila);

                //System.out.printf("%s | %d usos %n", nombreMoneda, cantidad);
            }


        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("TOTAL DE FILAS: " + ConsultaFila.size());
        request.setAttribute("ConsultaFila", ConsultaFila);
        request.getRequestDispatcher("/EJER_03.jsp").forward(request, response);
    }


}


