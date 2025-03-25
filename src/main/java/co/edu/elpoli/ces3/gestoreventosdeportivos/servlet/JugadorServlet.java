package co.edu.elpoli.ces3.gestoreventosdeportivos.servlet;

import co.edu.elpoli.ces3.gestoreventosdeportivos.dao.JugadorDAOArchivo;
import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Jugador;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String nacionalidad = request.getParameter("nacionalidad");
        String posicion = request.getParameter("posicion");
        int numero = Integer.parseInt(request.getParameter("numero"));
        int equipoId = Integer.parseInt(request.getParameter("equipoId"));
        boolean estadoActivo = Boolean.parseBoolean(request.getParameter("estadoActivo"));

        Jugador jugadorActualizado = new Jugador(id, nombre, apellido, fechaNacimiento, nacionalidad, posicion, numero, equipoId, estadoActivo);
        jugadorDAO.actualizarJugador(jugadorActualizado);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(gson.toJson(jugadorActualizado));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        jugadorDAO.eliminarJugador(id);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"message\":\"Jugador eliminado correctamente.\"}");
    }
}
