package co.edu.elpoli.ces3.gestoreventosdeportivos.dao;

import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAOArchivo {
    private static final String FILE_NAME = "C:/Users/SoyElPipeAA/IdeaProjects/GestorEventosDeportivos/jugadores.txt";

    public void guardarJugador(Jugador jugador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(jugador.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el jugador: " + e.getMessage());
        }
    }

    public List<Jugador> obtenerTodos() {
        List<Jugador> jugadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jugadores.add(Jugador.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error al leer los jugadores: " + e.getMessage());
        }
        return jugadores;
    }

    public void actualizarJugador(Jugador jugadorActualizado) {
        List<Jugador> jugadores = obtenerTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Jugador jugador : jugadores) {
                if (jugador.getId() == jugadorActualizado.getId()) {
                    writer.write(jugadorActualizado.toString());
                } else {
                    writer.write(jugador.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el jugador: " + e.getMessage());
        }
    }

    public void eliminarJugador(int id) {
        List<Jugador> jugadores = obtenerTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Jugador jugador : jugadores) {
                if (jugador.getId() != id) {
                    writer.write(jugador.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar el jugador: " + e.getMessage());
        }
    }
    public Jugador obtenerPorId(int id) {
        List<Jugador> jugadores = obtenerTodos();
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }

}
