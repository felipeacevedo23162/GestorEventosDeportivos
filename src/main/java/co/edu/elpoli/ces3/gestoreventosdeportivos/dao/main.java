package co.edu.elpoli.ces3.gestoreventosdeportivos.dao;

import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Equipo;
import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Evento;
import co.edu.elpoli.ces3.gestoreventosdeportivos.modelo.Jugador;

public class main {
    public static void main(String[] args) {
        EventoDAOArchivo dao = new EventoDAOArchivo();

        // Crear eventos
        Evento evento1 = new Evento(1, "Final Copa Libertadores", "2025-12-10", "Estadio Maracaná", "Fútbol", 80000, "Programado");
        evento1.agregarEquipo(1);
        evento1.agregarEquipo(2);

        dao.guardarEvento(evento1);

        // Leer eventos guardados
        System.out.println("Eventos guardados:");
        dao.obtenerTodos().forEach(System.out::println);

        // Actualizar evento
        evento1.setEstado("Finalizado");
        evento1.venderEntradas(30000);
        dao.actualizarEvento(evento1);

        System.out.println("\nEventos después de la actualización:");
        dao.obtenerTodos().forEach(System.out::println);



//        EquipoDAOArchivo dao = new EquipoDAOArchivo();
//
//        // Crear y guardar equipos
//        Equipo equipo1 = new Equipo(1, "Atlético Nacional", "Fútbol", "Medellín", "1947-03-07", "logo1.png");
//        equipo1.agregarJugador(10);
//        equipo1.agregarJugador(23);
//        dao.guardarEquipo(equipo1);
//
//        Equipo equipo2 = new Equipo(2, "Medellín", "Fútbol", "Medellín", "1913-11-14", "logo2.png");
//        equipo2.agregarJugador(7);
//        equipo2.agregarJugador(11);
//        dao.guardarEquipo(equipo2);
//
//        // Leer todos los equipos
//        System.out.println("Equipos guardados:");
//        dao.obtenerTodos().forEach(System.out::println);
//
//        // Actualizar equipo
//        equipo1.setNombre("Atlético Nacional S.A.");
//        dao.actualizarEquipo(equipo1);
//
//        System.out.println("\nEquipos después de la actualización:");
//        dao.obtenerTodos().forEach(System.out::println);
//

//        JugadorDAOArchivo dao = new JugadorDAOArchivo();
//
//        // Crear y guardar jugadores
//        Jugador jugador1 = new Jugador(1, "Lionel", "Messi", "1987-06-24", "Argentina", "Delantero", 10, 1, true);
//        dao.guardarJugador(jugador1);
//
//        Jugador jugador2 = new Jugador(2, "Cristiano", "Ronaldo", "1985-02-05", "Portugal", "Delantero", 7, 2, true);
//        dao.guardarJugador(jugador2);
//
//        // Leer todos los jugadores
//        System.out.println("Jugadores guardados:");
//        dao.obtenerTodos().forEach(System.out::println);
//
//        // Actualizar jugador
//        jugador1.setPosicion("Mediocampista");
//        dao.actualizarJugador(jugador1);
//
//        System.out.println("\nJugadores después de la actualización:");
//        dao.obtenerTodos().forEach(System.out::println);

//        // Eliminar un jugador
//        dao.eliminarJugador(2);
//
//        System.out.println("\nJugadores después de eliminar a Cristiano:");
//        dao.obtenerTodos().forEach(System.out::println);
    }
}
