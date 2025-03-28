package co.edu.elpoli.ces3.gestoreventosdeportivos.servlet;

import co.edu.elpoli.ces3.gestoreventosdeportivos.dao.EventoDAOArchivo;
import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Evento;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/evento")
public class EventoServlet extends HttpServlet {
    private EventoDAOArchivo eventoDAO = new EventoDAOArchivo();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String idParam = request.getParameter("id");
        Gson gson = new Gson();
        String jsonResponse;

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                Evento evento = eventoDAO.obtenerPorId(id);

                if (evento != null) {
                    jsonResponse = gson.toJson(evento);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    jsonResponse = "{\"error\": \"Evento no encontrado\"}";
                }

            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonResponse = "{\"error\": \"ID inválido\"}";
            }
        } else {
            List<Evento> eventos = eventoDAO.obtenerTodos();
            jsonResponse = gson.toJson(eventos);
        }

        response.getWriter().write(jsonResponse);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String lugar = request.getParameter("lugar");
        String deporte = request.getParameter("deporte");
        int entradasVendidas = Integer.parseInt(request.getParameter("entradasVendidas"));
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        String estado = request.getParameter("estado");

        int id = (int) (Math.random() * 10000);
        Evento nuevoEvento = new Evento(id, nombre, fecha, lugar, deporte, entradasVendidas, capacidad, estado);
        eventoDAO.guardarEvento(nuevoEvento);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(gson.toJson(nuevoEvento));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del evento es requerido en la URL\"}");
                return;
            }
            int id = Integer.parseInt(idParam);
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha");
            String lugar = request.getParameter("lugar");
            String deporte = request.getParameter("deporte");
            int entradasVendidas = Integer.parseInt(request.getParameter("entradasVendidas"));
            int capacidad = Integer.parseInt(request.getParameter("capacidad"));
            String estado = request.getParameter("estado");

            Evento eventoActualizado = new Evento(id, nombre, fecha, lugar, deporte, entradasVendidas, capacidad, estado);
            eventoDAO.actualizarEvento(eventoActualizado);

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(gson.toJson(eventoActualizado));
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Error actualizando el evento: " + e.getMessage() + "\"}");
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"El ID del evento es requerido en la URL\"}");
                return;
            }
            int id = Integer.parseInt(idParam);
            eventoDAO.eliminarEvento(id);

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"message\":\"Evento eliminado correctamente.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Error eliminar el evento: " + e.getMessage() + "\"}");

        }

    }
}
