package co.edu.elpoli.ces3.gestoreventosdeportivos.servlet;

import co.edu.elpoli.ces3.gestoreventosdeportivos.dao.EquipoDAOArchivo;
import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Equipo;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/equipos")
public class EquipoServlet extends HttpServlet {

    private final EquipoDAOArchivo equipoDAO = new EquipoDAOArchivo();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String idParam = request.getParameter("id");
        String jsonResponse;

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                Equipo equipo = equipoDAO.obtenerPorId(id);

                if (equipo != null) {
                    jsonResponse = gson.toJson(equipo);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    jsonResponse = "{\"error\": \"Equipo no encontrado\"}";
                }

            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonResponse = "{\"error\": \"ID inválido\"}";
            }
        } else {
            List<Equipo> equipos = equipoDAO.obtenerTodos();
            jsonResponse = gson.toJson(equipos);
        }

        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String deporte = request.getParameter("deporte");
        String ciudad = request.getParameter("ciudad");
        String fechaFundacion = request.getParameter("fechaFundacion");
        String logo = request.getParameter("logo");

        int id = (int) (Math.random() * 10000);
        Equipo equipo = new Equipo(id, nombre, deporte, ciudad, fechaFundacion, logo);

        equipoDAO.guardarEquipo(equipo);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(gson.toJson(equipo));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String deporte = request.getParameter("deporte");
        String ciudad = request.getParameter("ciudad");
        String fechaFundacion = request.getParameter("fechaFundacion");
        String logo = request.getParameter("logo");

        Equipo equipoActualizado = new Equipo(id, nombre, deporte, ciudad, fechaFundacion, logo);
        equipoDAO.actualizarEquipo(equipoActualizado);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(gson.toJson(equipoActualizado));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        equipoDAO.eliminarEquipo(id);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"message\":\"Equipo eliminado correctamente.\"}");
    }
}
