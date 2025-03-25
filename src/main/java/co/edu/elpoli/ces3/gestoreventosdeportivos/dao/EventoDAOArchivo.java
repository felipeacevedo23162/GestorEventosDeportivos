package co.edu.elpoli.ces3.gestoreventosdeportivos.dao;

import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Evento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOArchivo {
    private static final String FILE_NAME = "C:/Users/SoyElPipeAA/IdeaProjects/GestorEventosDeportivos/eventos.txt";

    // Guardar un evento nuevo
    public void guardarEvento(Evento evento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(evento.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el evento: " + e.getMessage());
        }
    }

    // Leer todos los eventos
    public List<Evento> obtenerTodos() {
        List<Evento> eventos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                eventos.add(Evento.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error al leer los eventos: " + e.getMessage());
        }
        return eventos;
    }

    // Obtener un evento por ID
    public Evento obtenerPorId(int id) {
        List<Evento> eventos = obtenerTodos();
        for (Evento evento : eventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null; // Retorna null si no encuentra el evento
    }

    // Actualizar un evento existente
    public void actualizarEvento(Evento eventoActualizado) {
        List<Evento> eventos = obtenerTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Evento evento : eventos) {
                if (evento.getId() == eventoActualizado.getId()) {
                    writer.write(eventoActualizado.toString());
                } else {
                    writer.write(evento.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el evento: " + e.getMessage());
        }
    }

    // Eliminar un evento por su ID
    public void eliminarEvento(int id) {
        List<Evento> eventos = obtenerTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Evento evento : eventos) {
                if (evento.getId() != id) {
                    writer.write(evento.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar el evento: " + e.getMessage());
        }
    }
}
