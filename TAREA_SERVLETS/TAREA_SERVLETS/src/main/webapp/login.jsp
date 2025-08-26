<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

    <link rel="stylesheet" href="./css/styles.css?v=1" />
</head>
<body>

<h1> PAGINA DE LOGIN</h1>

<h2> Current time: <%= new java.util.Date() %></h2>

<a class="btn btn-darken btn-inline"
    href="index.html">
    VOLVER
</a>

<hr><hr>

<section class="section banner banner-section">
    <div class="container">

        <div class="login-card padding-horizontal--48">
            <h2>Welcome Back</h2>
            <p class="paragraph">Please enter your FBank credentials</p>

            <div class="margin-bottom--12 content-center">
                <%-- Check if loginMessage attribute exists --%>
                <% if (request.getAttribute("loginMessage") != null) { %>
                <p style="color: red">
                    <%= request.getAttribute("loginMessage") %>
                </p>
                <% } %>
            </div>

            <form class="login-form" action="login" method="post">
                <div class="field">
                    <label for="username">Username</label>
                    <input
                            type="text"
                            name="username"
                            placeholder="Enter your username"
                            required
                    />
                </div>
                <div class="field">
                    <label for="password">Password</label>
                    <input
                            type="password"
                            name="password"
                            placeholder="Enter your password"
                            required
                    />
                </div>

                <div class="padding-top--12">
                    <button
                            class="btn btn-darken btn-inline login-btn"
                            type="submit"
                    >
                        Login
                    </button>
                </div>
                <div class="footer-link padding-top--12">
                            <span>
                                Don't have an account?
                                <a href="">Register</a>
                            </span>
                </div>
            </form>

        </div>

    </div>
</section>


<script src="./js/script.js"></script>
</body>
</html>