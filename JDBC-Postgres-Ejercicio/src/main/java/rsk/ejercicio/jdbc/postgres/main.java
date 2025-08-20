package rsk.ejercicio.jdbc.postgres;

import java.sql.*;

//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.SQLException;

public class main {

    private static final String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
    private static final String usuario = "postgres";
    private static final String contraseña = "postgres";

    public static void main(String[] args) throws SQLException {
//        Connection conn = DriverManager.getConnection(url, usuario, contraseña);
//        try (Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery ("SELECT * FROM cliente")) {
//            while (rs.next()) {
//                String nombre = rs.getString("nombre");
//                String apellido = rs.getString("apellido");
//                String nro_cedula = rs.getString("nro_cedula");
//                System.out.println("Clientes: " + nombre + " " + apellido + " - " + nro_cedula);
//            }
//        }
        Ejercicio_1();
        Ejercicio_2();
        Ejercicio_3();
        Ejercicio_4();
        Ejercicio_5();
        Ejercicio_6();
        Ejercicio_7(13);
        Ejercicio_8();
        Ejercicio_9();
    }

    static void Ejercicio_1(){
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

    }

    static void Ejercicio_2() {
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

                System.out.printf("%s | %s | $%.2f %n", nombre, apellido, total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_3() {
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

                System.out.printf("%s | %d usos %n", nombreMoneda, cantidad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_4() {
        String sql = "SELECT proveedor.nombre, COUNT(*) AS cantidad " +
                "FROM producto " +
                "JOIN proveedor ON producto.proveedor_id = proveedor.id " +
                "GROUP BY proveedor.nombre " +
                "ORDER BY cantidad DESC";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top proveedores por cantidad de productos: \n");
            while (rs.next()) {
                String nombreProveedor = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");

                System.out.printf("%s | %d productos %n", nombreProveedor, cantidad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_5() {
        String sql = "SELECT producto.nombre, SUM(factura_detalle.cantidad) AS cantidad " +
                "FROM factura_detalle " +
                "JOIN producto ON factura_detalle.producto_id = producto.id " +
                "GROUP BY producto.nombre " +
                "ORDER BY cantidad DESC " +
                "LIMIT 10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top productos más vendidos: \n");
            while (rs.next()) {
                String nombreProducto = rs.getString("nombre");
                int cantidadVendida = rs.getInt("cantidad");

                System.out.printf("%s | %d unidades vendidas %n", nombreProducto, cantidadVendida);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_6() {
        String sql = "SELECT producto.nombre, SUM(factura_detalle.cantidad) AS cantidad " +
                "FROM factura_detalle " +
                "JOIN producto ON factura_detalle.producto_id = producto.id " +
                "GROUP BY producto.nombre " +
                "ORDER BY cantidad ASC " +
                "LIMIT 10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top productos menos vendidos: \n");
            while (rs.next()) {
                String nombreProducto = rs.getString("nombre");
                int cantidadVendida = rs.getInt("cantidad");

                System.out.printf("%s | %d unidades vendidas %n", nombreProducto, cantidadVendida);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_7(int facturaId) {
        String sql = "SELECT factura.fecha_emision, cliente.nombre, cliente.apellido, " +
                "producto.nombre AS producto_nombre, factura_detalle.cantidad, factura_tipo.nombre AS tipo_factura " +
                "FROM factura_detalle " +
                "JOIN factura ON factura_detalle.factura_id = factura.id " +
                "JOIN cliente ON factura.cliente_id = cliente.id " +
                "JOIN factura_tipo ON factura.factura_tipo_id = factura_tipo.id " +
                "JOIN producto ON factura_detalle.producto_id = producto.id " +
                "WHERE factura.id = ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, facturaId);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("Detalle de la factura #%d:\n\n", facturaId);
            while (rs.next()) {
                Date fechaEmision = rs.getDate("fecha_emision");
                String nombreCliente = rs.getString("nombre");
                String apellidoCliente = rs.getString("apellido");
                String nombreProducto = rs.getString("producto_nombre");
                int cantidad = rs.getInt("cantidad");
                String tipoFactura = rs.getString("tipo_factura");

                System.out.printf("Fecha: %s | Cliente: %s %s | Producto: %s | Cantidad: %d | Tipo: %s%n",
                        fechaEmision, nombreCliente, apellidoCliente, nombreProducto, cantidad, tipoFactura);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_8() {
        String sql = "SELECT factura.id, SUM(producto.precio * factura_detalle.cantidad) AS total " +
                "FROM factura_detalle " +
                "JOIN factura ON factura_detalle.factura_id = factura.id " +
                "JOIN cliente ON factura.cliente_id = cliente.id " +
                "JOIN factura_tipo ON factura.factura_tipo_id = factura_tipo.id " +
                "JOIN producto ON factura_detalle.producto_id = producto.id " +
                "GROUP BY factura.id " +
                "ORDER BY total DESC " +
                "LIMIT 10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top 10 facturas por monto total: \n");
            while (rs.next()) {
                int facturaId = rs.getInt("id");
                double total = rs.getDouble("total");

                System.out.printf("Factura #%d | Total: $%.2f%n", facturaId, total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void Ejercicio_9() {
        String sql = "SELECT factura.id, " +
                "SUM(producto.precio * factura_detalle.cantidad) AS total, " +
                "ROUND(SUM(producto.precio * factura_detalle.cantidad) * 0.10) AS iva_10 " +
                "FROM factura_detalle " +
                "JOIN factura ON factura_detalle.factura_id = factura.id " +
                "JOIN cliente ON factura.cliente_id = cliente.id " +
                "JOIN factura_tipo ON factura.factura_tipo_id = factura_tipo.id " +
                "JOIN producto ON factura_detalle.producto_id = producto.id " +
                "GROUP BY factura.id " +
                "ORDER BY total DESC";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Montos totales de facturas con IVA 10%: \n");
            while (rs.next()) {
                int facturaId = rs.getInt("id");
                double total = rs.getDouble("total");
                double iva = rs.getDouble("iva_10");

                System.out.printf("Factura #%d | Total: $%.2f | IVA 10%%: $%.2f%n", facturaId, total, iva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}


