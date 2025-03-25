package co.edu.elpoli.ces3.gestoreventosdeportivos.dao;

import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Equipo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAOArchivo {
    private static final String FILE_NAME = "C:/Users/SoyElPipeAA/IdeaProjects/GestorEventosDeportivos/equipos.txt";

    // Guardar un equipo (agrega una línea nueva)
    public void guardarEquipo(Equipo equipo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(equipo.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el equipo: " + e.getMessage());
        }
    }

    // Obtener todos los equipos
    public List<Equipo> obtenerTodos() {
        List<Equipo> equipos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                equipos.add(Equipo.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error al leer los equipos: " + e.getMessage());
        }
        return equipos;
    }

    // Actualizar un equipo
    public void actualizarEquipo(Equipo equipoActualizado) {
        List<Equipo> equipos = obtenerTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Equipo equipo : equipos) {
                if (equipo.getId() == equipoActualizado.getId()) {
                    writer.write(equipoActualizado.toString());
                } else {
                    writer.write(equipo.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el equipo: " + e.getMessage());
        }
    }

    // Eliminar un equipo
    public void eliminarEquipo(int id) {
        List<Equipo> equipos = obtenerTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Equipo equipo : equipos) {
                if (equipo.getId() != id) {
                    writer.write(equipo.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar el equipo: " + e.getMessage());
        }
    }
    public Equipo obtenerPorId(int id) {
        List<Equipo> equipos = obtenerTodos();
        for (Equipo equipo : equipos) {
            if (equipo.getId() == id) {
                return equipo;
            }
        }
        return null; // Devuelve null si no encuentra el equipo con ese id
    }

}
