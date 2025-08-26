<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EJERCICIO 04</title>

    <link rel="stylesheet" href="./css/styles.css?v=1" />

    <style>
        table {
            width: auto;
            border-radius: 4px;
            box-shadow: rgba(60, 66, 87, 0.12) 0px 7px 14px 0px, rgba(0, 0, 0, 0.12) 0px 3px 6px 0px;
        }
        td, th {
            padding: 3px 35px;
        }
    </style>

</head>
<body>

<section class="section banner banner-section">
    <div class="container banner-column">
        <div class="container">
            <h2>Top proveedor de productos</h2>
            <br>
            <table>
                <tr><th>NRO</th><th>Nombre</th><th>Cantidad</th></tr>
                <%
                    // Crear una lista interna que contiene esos arreglos
                    //List<String[]> ConsultaFila = new ArrayList<>();
                    List<String[]> ConsultaFila = (List<String[]>) request.getAttribute("ConsultaFila");
                    if (ConsultaFila != null) {
                        int i = 0;

                    for (int j = 0; j < ConsultaFila.size(); j++) {
                        String[] cliente = ConsultaFila.get(j);

                        String nombre = cliente[0];
//                        String apellido = cliente[1];
                        String total = cliente[1];
                %>
                <tr>
                    <td><%= ++i %></td>
                    <td><%= nombre %></td>
<%--                    <td><%= apellido %></td>--%>
                    <td><%= total %></td>
                </tr>
                <%
                    }
                    }
                %>
            </table>

            <br>

            <a class="btn btn-darken btn-inline"
               href="index.html">
                VOLVER
            </a>

        </div>
    </div>
</section>

<script src="./js/script.js"></script>
</body>
</html>