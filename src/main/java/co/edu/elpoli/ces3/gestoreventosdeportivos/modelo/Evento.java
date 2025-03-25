package co.edu.elpoli.ces3.gestoreventosdeportivos.modelo;

import java.util.ArrayList;

public class Evento {
    private int id;
    private String nombre;
    private String fecha;
    private String lugar;
    private String deporte;
    private ArrayList<Integer> equiposParticipantes;
    private int capacidad;
    private int entradasVendidas;
    private String estado;

    public Evento(int id, String nombre, String fecha, String lugar, String deporte, int entradasVendidas, int capacidad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.deporte = deporte;
        this.equiposParticipantes = new ArrayList<>();
        this.capacidad = capacidad;
        this.entradasVendidas = entradasVendidas;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public String getDeporte() { return deporte; }
    public void setDeporte(String deporte) { this.deporte = deporte; }

    public ArrayList<Integer> getEquiposParticipantes() { return equiposParticipantes; }
    public void agregarEquipo(int equipoId) { this.equiposParticipantes.add(equipoId); }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public int getEntradasVendidas() { return entradasVendidas; }
    public void venderEntradas(int cantidad) {
        if (this.entradasVendidas + cantidad <= capacidad) {
            this.entradasVendidas += cantidad;
        } else {
            System.out.println("No hay suficientes entradas disponibles.");
        }
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Convertir el objeto a una línea de texto
    @Override
    public String toString() {
        return id + "," + nombre + "," + fecha + "," + lugar + "," + deporte + "," +
                capacidad + "," + entradasVendidas + "," + estado + "," +
                equiposParticipantes.toString().replace("[", "").replace("]", "").replace(" ", "");
    }

    // Crear un objeto EventoDAO desde una línea de texto
    public static Evento fromString(String data) {
        String[] partes = data.split(",");
        Evento evento = new Evento(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3],
                partes[4],
                Integer.parseInt(partes[6]),
                Integer.parseInt(partes[5]),
                partes[7]
        );
        if (partes.length > 8) {
            for (int i = 8; i < partes.length; i++) {
                evento.agregarEquipo(Integer.parseInt(partes[i]));
            }
        }

        return evento;
    }
}
