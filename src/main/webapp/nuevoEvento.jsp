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
    <title>Nuevo Evento Deportivo</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Registrar Nuevo Evento Deportivo</h1>

<form action="/GestorEventosDeportivos_war_exploded/eventos" method="post">
    <label for="nombre">Nombre del evento:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" required><br><br>

    <label for="lugar">Lugar:</label>
    <input type="text" id="lugar" name="lugar" required><br><br>

    <label for="deporte">Deporte:</label>
    <input type="text" id="deporte" name="deporte" required><br><br>

    <label for="capacidad">Capacidad:</label>
    <input type="number" id="capacidad" name="capacidad" min="1" required><br><br>

    <label for="equipos">Equipos participantes (IDs separados por comas):</label>
    <input type="text" id="equipos" name="equipos" placeholder="Ejemplo: 1,2,3" required><br><br>

    <button type="submit">Registrar Evento</button>
</form>

<br>
<a href="/GestorEventosDeportivos_war_exploded/eventos.jsp">Volver a la lista de eventos</a>
</body>
</html>
