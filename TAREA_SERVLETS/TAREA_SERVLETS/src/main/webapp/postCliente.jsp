<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert</title>

    <link rel="stylesheet" href="./css/styles.css?v=1" />
</head>
<body>



<section class="section banner banner-section">
    <div class="container">

        <div class="login-card padding-horizontal--48">

            <h2>Cargar un Nuevo Cliente</h2>

            <br>

<%--            <p class="paragraph">Please enter your FBank credentials</p>--%>

            <form class="login-form" action="postCliente" method="post">
                <div class="field">
                    <label for="nombre">Nombre</label>
                    <input
                            type="text"
                            name="nombre"
                            placeholder="Ingresa el Nombre"
                            required
                    />
                </div>
                <div class="field">
                    <label for="apellido">Apellido</label>
                    <input
                            type="text"
                            name="apellido"
                            placeholder="Ingresa el Apellido"
                            required
                    />
                </div>

                <div class="field">
                    <label for="nro_cedula">Nro de Cedula</label>
                    <input
                            type="text"
                            name="nro_cedula"
                            placeholder="Ingresa el Nro de Cedula"
                            required
                    />
                </div>

                <div class="field">
                    <label for="telefono">Telefono</label>
                    <input
                            type="text"
                            name="telefono"
                            placeholder="Ingresa el Telefono"
                            required
                    />
                </div>

                <div class="padding-top--12">
                    <button
                            class="btn btn-darken btn-inline login-btn"
                            type="submit"
                    >
                        INSERTAR
                    </button>
                </div>
<%--                <div class="footer-link padding-top--12">--%>
<%--                            <span>--%>
<%--                                Don't have an account?--%>
<%--                                <a href="">Register</a>--%>
<%--                            </span>--%>
<%--                </div>--%>
            </form>


            <% if (request.getAttribute("mensaje") != null) { %>
            <p style="color: #00ff00">
                <%= request.getAttribute("mensaje") %>
            </p>
            <% } %>

            <br>
<%--            <h3><%= request.getAttribute("mensaje") %></h3>--%>
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