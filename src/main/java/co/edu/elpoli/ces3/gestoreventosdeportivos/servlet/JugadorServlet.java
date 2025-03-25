package co.edu.elpoli.ces3.gestoreventosdeportivos.servlet;

import co.edu.elpoli.ces3.gestoreventosdeportivos.dao.JugadorDAOArchivo;
import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Jugador;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/jugador")
public class JugadorServlet extends HttpServlet {
    private final JugadorDAOArchivo jugadorDAO = new JugadorDAOArchivo();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String idParam = request.getParameter("id");
        String jsonResponse;

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                Jugador jugador = jugadorDAO.obtenerPorId(id);

                if (jugador != null) {
                    jsonResponse = gson.toJson(jugador);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    jsonResponse = "{\"error\": \"Jugador no encontrado\"}";
                }

            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonResponse = "{\"error\": \"ID inválido\"}";
            }
        } else {
            List<Jugador> jugadores = jugadorDAO.obtenerTodos();
            jsonResponse = gson.toJson(jugadores);
        }

        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String nacionalidad = request.getParameter("nacionalidad");
        String posicion = request.getParameter("posicion");
        int numero = Integer.parseInt(request.getParameter("numero"));
        int equipoId = Integer.parseInt(request.getParameter("equipoId"));
        boolean estadoActivo = Boolean.parseBoolean(request.getParameter("estadoActivo"));

        Jugador nuevoJugador = new Jugador(id, nombre, apellido, fechaNacimiento, nacionalidad, posicion, numero, equipoId, estadoActivo);
        jugadorDAO.guardarJugador(nuevoJugador);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(gson.toJson(nuevoJugador));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener el ID desde los parámetros de la URL (ejemplo: ?id=3)
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del jugador es requerido en la URL\"}");
                return;
            }
            System.out.println(idParam);
            int id = Integer.parseInt(idParam);

            // Leer el cuerpo como JSON
            BufferedReader reader = request.getReader();
            StringBuilder jsonBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBody.append(line);
            }

            // Parsear el JSON a un objeto Jugador
            Jugador jugadorActualizado = gson.fromJson(jsonBody.toString(), Jugador.class);
            jugadorActualizado.setId(id); // Asegurarse de que el ID sea el de la URL

            // Actualizar el jugador usando el DAO
            jugadorDAO.actualizarJugador(jugadorActualizado);

            // Responder con el JSON actualizado
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(gson.toJson(jugadorActualizado));

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"El ID debe ser un número válido\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Error actualizando el jugador: " + e.getMessage() + "\"}");
        }
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del jugador es requerido en la URL\"}");
                return;
            }
            int id = Integer.parseInt(idParam);
            jugadorDAO.eliminarJugador(id);

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"message\":\"Jugador eliminado correctamente.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Error eliminar el jugador: " + e.getMessage() + "\"}");
        }

    }
}
