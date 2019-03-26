<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>${messages["header_text"]}</title> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css" />

    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="./index">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="./login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./nuevoCliente">Nuevo cliente <span class="sr-only">(current)</span></a>
                    </li>
                    <c:if test="${!empty logeado}">

                        <li class="nav-item">
                            <a class="nav-link" href="#">Nuevo propietario</a>
                        </li>
                    </c:if>

                    <li class="nav-item">
                        <a class="nav-link" href="./verClientes">Ver Clientes</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="./verInmuebles">Ver Inmuebles</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="container">

            <div id="body">
