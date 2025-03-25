<%--
  Created by IntelliJ IDEA.
  User: SoyElPipeAA
  Date: 23/03/2025
  Time: 5:16 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Evento</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h1 class="mb-4 text-center">Agregar Nuevo Evento</h1>

    <form action="/GestorEventosDeportivos_war_exploded/evento" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre del evento</label>
            <input type="text" id="nombre" name="nombre" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="fecha" class="form-label">Fecha</label>
            <input type="date" id="fecha" name="fecha" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="lugar" class="form-label">Lugar</label>
            <input type="text" id="lugar" name="lugar" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="deporte" class="form-label">Deporte</label>
            <input type="text" id="deporte" name="deporte" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="capacidad" class="form-label">Capacidad</label>
            <input type="number" id="capacidad" name="capacidad" class="form-control" min="1" required>
        </div>

        <div class="mb-3">
            <label for="entradasVendidas" class="form-label">Entradas Vendidas</label>
            <input type="number" id="entradasVendidas" name="entradasVendidas" class="form-control" min="0" required>
        </div>

        <div class="mb-3">
            <label for="estado" class="form-label">Estado</label>
            <select id="estado" name="estado" class="form-select" required>
                <option value="Programado">Programado</option>
                <option value="En curso">En curso</option>
                <option value="Finalizado">Finalizado</option>
                <option value="Cancelado">Cancelado</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Guardar Evento</button>
        <a href="eventos.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
