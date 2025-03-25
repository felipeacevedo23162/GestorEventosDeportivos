<%--
  Created by IntelliJ IDEA.
  User: SoyElPipeAA
  Date: 24/03/2025
  Time: 8:22 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Jugador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Registrar Nuevo Jugador</h1>
    <form action="/GestorEventosDeportivos_war_exploded/jugador" method="post">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="number" class="form-control" id="id" name="id" required>
        </div>
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="apellido" name="apellido" required>
        </div>
        <div class="mb-3">
            <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
        </div>
        <div class="mb-3">
            <label for="nacionalidad" class="form-label">Nacionalidad</label>
            <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" required>
        </div>
        <div class="mb-3">
            <label for="posicion" class="form-label">Posición</label>
            <input type="text" class="form-control" id="posicion" name="posicion" required>
        </div>
        <div class="mb-3">
            <label for="numero" class="form-label">Número</label>
            <input type="number" class="form-control" id="numero" name="numero" required>
        </div>
        <div class="mb-3">
            <label for="equipoId" class="form-label">Equipo ID</label>
            <input type="number" class="form-control" id="equipoId" name="equipoId" required>
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="estadoActivo" name="estadoActivo">
            <label class="form-check-label" for="estadoActivo">Activo</label>
        </div>
        <button type="submit" class="btn btn-primary w-100">Guardar Jugador</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
