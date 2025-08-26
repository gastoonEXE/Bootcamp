package com.roshka;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/postCliente")

public class postCliente extends HttpServlet {

    private static final String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
    private static final String usuario = "postgres";
    private static final String contraseña = "postgres";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(request, response);

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nro_cedula = request.getParameter("nro_cedula");
        String telefono = request.getParameter("telefono");

        String loginMessage = null;

        int nuevoId = 1; // valor por defecto si la tabla está vacía

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                 Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM cliente")) {
                if (rs.next()) {
                    nuevoId = rs.getInt(1) + 1;
                }

                System.out.println("Insertar nuevo cliente \n");

                String insertSQL = "INSERT INTO cliente (id, nombre, apellido, nro_cedula, telefono) VALUES (?, ?, ?, ?, ?)";

                // Insertar nuevo cliente
                try (PreparedStatement insertStmt = conexion.prepareStatement(insertSQL)) {
                    insertStmt.setInt(1, nuevoId);
                    insertStmt.setString(2, nombre);
                    insertStmt.setString(3, apellido);
                    insertStmt.setString(4, nro_cedula);
                    insertStmt.setString(5, telefono);
                    int filasInsertadas = insertStmt.executeUpdate();

//                if (filasInsertadas > 0) {
//                    System.out.println("Cliente insertado correctamente.");
//                } else {
//                    System.out.println("No se pudo insertar el cliente.");
//                }
                }
                request.setAttribute("mensaje", "Cliente insertado correctamente");
            } catch (SQLException e) {
                System.err.println("Error al conectar con la base de datos:" +  e.getMessage());
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error al conectar con la base de datos:" +  e.getMessage());
        }



        request.getRequestDispatcher("/postCliente.jsp").forward(request, response);
//        request.getRequestDispatcher("/postCliente.jsp").forward(request, response);
    }

}


