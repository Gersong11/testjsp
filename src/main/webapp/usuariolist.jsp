<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Aplicacion Gestion de Usuarios</title>
</head>
<body>
<header>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">Gestion de Usuarios</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/list">Usuario</a>
    </li>
   
  </ul>
</nav>

</header>
<br>
		<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Usuarios</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Usuario</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Pais</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                           <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="usuario" items="${listUsuarios}">

                                <tr>
                                    <td>
                                        <c:out value="${usuario.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${usuario.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${usuario.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${usuario.pais}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${usuario.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${usuario.id}' />">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>

</body>
</html>