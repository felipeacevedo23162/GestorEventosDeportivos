<%--
  Created by IntelliJ IDEA.
  User: SoyElPipeAA
  Date: 23/03/2025
  Time: 3:27 p. m.
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>


<html>
<head>
    <title>Gestor de Eventos Deportivos</title>
    <link rel="stylesheet" href="style.css">
    <script>
        async function cargarEventos() {
            const deporte = document.getElementById("deporte").value;
            const estado = document.getElementById("estado").value;
            const url = `/eventos?deporte=${encodeURIComponent(deporte)}&estado=${encodeURIComponent(estado)}`;


            const response = await fetch(url);
            const eventos = await response.json();
            const tableBody = document.getElementById("tablaEventos");

            tableBody.innerHTML = ""; // Limpiar la tabla antes de agregar los nuevos datos

            eventos.forEach(evento => {
                const equipos = evento.equiposParticipantes.join(", ");
                tableBody.innerHTML += `
                    <tr>
                        <td>${evento.nombre}</td>
                        <td>${evento.fecha}</td>
                        <td>${evento.lugar}</td>
                        <td>${evento.deporte}</td>
                        <td>${evento.capacidad}</td>
                        <td>${evento.entradasVendidas}</td>
                        <td>${evento.estado}</td>
                        <td>${equipos}</td>
                    </tr>`;
            });
        }

        // Cargar eventos al cargar la página
        window.onload = cargarEventos;
    </script>
</head>

<body>
<h1>Eventos Deportivos</h1>

<!-- Formulario para filtrar eventos -->
<form onsubmit="cargarEventos(); return false;">
    <label for="deporte">Deporte:</label>
    <input type="text" id="deporte" name="deporte" placeholder="Ejemplo: Fútbol">

    <label for="estado">Estado:</label>
    <select id="estado" name="estado">
        <option value="">-- Todos los estados --</option>
        <option value="Programado">Programado</option>
        <option value="En curso">En curso</option>
        <option value="Finalizado">Finalizado</option>
        <option value="Cancelado">Cancelado</option>
    </select>

    <button type="submit">Filtrar</button>
</form>

<!-- Tabla de eventos deportivos -->
<table border="1">
    <thead>
    <tr>
        <th>Nombre del evento</th>
        <th>Fecha</th>
        <th>Lugar</th>
        <th>Deporte</th>
        <th>Capacidad</th>
        <th>Entradas Vendidas</th>
        <th>Estado</th>
        <th>Equipos Participantes</th>
    </tr>
    </thead>
    <tbody id="tablaEventos">
    <!-- Los eventos se llenarán dinámicamente -->
    </tbody>
</table>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestor de Eventos Deportivos</title>
    <link rel="stylesheet" href="style.css">
    <script>
        async function cargarEventos() {
            const deporte = document.getElementById("deporte").value;
            const estado = document.getElementById("estado").value;
            const url = `/eventos?deporte=${encodeURIComponent(deporte)}&estado=${encodeURIComponent(estado)}`;

            const response = await fetch(url);
            const eventos = await response.json();
            const tableBody = document.getElementById("tablaEventos");

            tableBody.innerHTML = ""; // Limpiar la tabla antes de agregar los nuevos datos

            eventos.forEach(evento => {
                const equipos = evento.equiposParticipantes.join(", ");
                tableBody.innerHTML += `
                    <tr>
                        <td>${evento.nombre}</td>
                        <td>${evento.fecha}</td>
                        <td>${evento.lugar}</td>
                        <td>${evento.deporte}</td>
                        <td>${evento.capacidad}</td>
                        <td>${evento.entradasVendidas}</td>
                        <td>${evento.estado}</td>
                        <td>${equipos}</td>
                    </tr>`;
            });
        }

        // Cargar eventos al cargar la página
        window.onload = cargarEventos;
    </script>
</head>

<body>
<h1>Eventos Deportivos</h1>

<!-- Formulario para filtrar eventos -->
<form onsubmit="cargarEventos(); return false;">
    <label for="deporte">Deporte:</label>
    <input type="text" id="deporte" name="deporte" placeholder="Ejemplo: Fútbol">

    <label for="estado">Estado:</label>
    <select id="estado" name="estado">
        <option value="">-- Todos los estados --</option>
        <option value="Programado">Programado</option>
        <option value="En curso">En curso</option>
        <option value="Finalizado">Finalizado</option>
        <option value="Cancelado">Cancelado</option>
    </select>

    <button type="submit">Filtrar</button>
</form>

<!-- Tabla de eventos deportivos -->
<table border="1">
    <thead>
    <tr>
        <th>Nombre del evento</th>
        <th>Fecha</th>
        <th>Lugar</th>
        <th>Deporte</th>
        <th>Capacidad</th>
        <th>Entradas Vendidas</th>
        <th>Estado</th>
        <th>Equipos Participantes</th>
    </tr>
    </thead>
    <tbody id="tablaEventos">
    <!-- Los eventos se llenarán dinámicamente -->
    </tbody>
</table>
</body>
</html>
