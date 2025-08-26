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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@WebServlet("/EJER_02")

public class EJER_02 extends HttpServlet {

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


        String sql = "SELECT cliente.nombre, cliente.apellido, " +
                "SUM(producto.precio * factura_detalle.cantidad) AS total " +
                "FROM cliente " +
                "JOIN factura ON cliente.id = factura.cliente_id " +
                "JOIN factura_detalle ON factura.id = factura_detalle.factura_id " +
                "JOIN producto ON factura_detalle.producto_id = producto.id " +
                "GROUP BY cliente.nombre, cliente.apellido " +
                "ORDER BY total DESC " +
                "LIMIT 10";


        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top clientes que más gastaron: \n");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double total = rs.getDouble("total");

                // Configurar formato con separador de miles (.) y decimal (,)
                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator('.');
                symbols.setDecimalSeparator(',');

                // Crear el formato: separador de miles y dos decimales
                DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);

                // Convertir a String con formato
                String totalFormateado = formatter.format(total);


                String[] cliente = {nombre, apellido, totalFormateado};
                ConsultaFila.add(cliente);
//                System.out.printf("%s | %s | $%.2f %n", nombre, apellido, total);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("TOTAL DE FILAS: " + ConsultaFila.size());
        request.setAttribute("ConsultaFila", ConsultaFila);
        request.getRequestDispatcher("/EJER_02.jsp").forward(request, response);
    }


}


