<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EJERCICIO 01</title>

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
            <h2>Top clientes con más facturas</h2>
            <br>
            <table>
                <tr><th>NRO</th><th>Nombre</th><th>Apellido</th><th>Cantidad</th></tr>
                <%
                    List<String> topClientes = (List<String>) request.getAttribute("topClientes");
                    if (topClientes != null) {
                        int i = 0;
                    for (String cliente : topClientes) {
                        String[] partes = cliente.split(" - ");
                        String[] nombreApellido = partes[0].split(" ");
                        String cantidad = partes[1].replace(" facturas", "");
                %>
                <tr>
                    <td><%= ++i %></td>
                    <td><%= nombreApellido[0] %></td>
                    <td><%= nombreApellido[1] %></td>
                    <td><%= cantidad %></td>
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