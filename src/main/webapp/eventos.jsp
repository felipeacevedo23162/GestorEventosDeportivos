<%--
  Created by IntelliJ IDEA.
  User: SoyElPipeAA
  Date: 23/03/2025
  Time: 3:27 p. m.
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="co.edu.elpoli.ces3.gestoreventosdeportivos.dao.EventoDAOArchivo" %>
<%@ page import="co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Evento" %>
<%@ page import="java.util.List" %>

<%
    EventoDAOArchivo eventoDAO = new EventoDAOArchivo();
    List<Evento> eventos = eventoDAO.obtenerTodos();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Eventos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h1 class="mb-4 text-center">Lista de Eventos</h1>

    <table class="table table-striped table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Fecha</th>
            <th>Lugar</th>
            <th>Deporte</th>
            <th>Equipos Participantes</th>
            <th>Capacidad</th>
            <th>Entradas Vendidas</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <% for (Evento evento : eventos) { %>
        <tr>
            <td><%= evento.getId() %></td>
            <td><%= evento.getNombre() %></td>
            <td><%= evento.getFecha() %></td>
            <td><%= evento.getLugar() %></td>
            <td><%= evento.getDeporte() %></td>
            <td><%= evento.getEquiposParticipantes().toString() %></td>
            <td><%= evento.getCapacidad() %></td>
            <td><%= evento.getEntradasVendidas() %></td>
            <td><%= evento.getEstado() %></td>
            <td>
                <a href="editarEvento.jsp?id=<%= evento.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                <a href="eliminarEvento.jsp?id=<%= evento.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro que quieres eliminar este evento?');">Eliminar</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="nuevoEvento.jsp" class="btn btn-primary">Agregar nuevo evento</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>