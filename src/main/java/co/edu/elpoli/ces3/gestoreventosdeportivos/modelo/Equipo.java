package co.edu.elpoli.ces3.gestoreventosdeportivos.modelo;

import java.util.ArrayList;

public class Equipo {
    private int id;
    private String nombre;
    private String deporte;
    private String ciudad;
    private String fechaFundacion;
    private String logo;
    private ArrayList<Integer> jugadores;

    public Equipo(int id, String nombre, String deporte, String ciudad, String fechaFundacion, String logo) {
        this.id = id;
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.fechaFundacion = fechaFundacion;
        this.logo = logo;
        this.jugadores = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDeporte() { return deporte; }
    public void setDeporte(String deporte) { this.deporte = deporte; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getFechaFundacion() { return fechaFundacion; }
    public void setFechaFundacion(String fechaFundacion) { this.fechaFundacion = fechaFundacion; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

    public ArrayList<Integer> getJugadores() { return jugadores; }
    public void agregarJugador(int jugadorId) { this.jugadores.add(jugadorId); }

    @Override
    public String toString() {
        return id + "," + nombre + "," + deporte + "," + ciudad + "," + fechaFundacion + "," + logo + "," + jugadores.toString().replace("[", "").replace("]", "").replace(" ", "");
    }

    public static Equipo fromString(String data) {
        String[] partes = data.split(",");
        Equipo equipo = new Equipo(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3],
                partes[4],
                partes[5]
        );

        // Cargar jugadores si hay
        if (partes.length > 6) {
            for (int i = 6; i < partes.length; i++) {
                equipo.agregarJugador(Integer.parseInt(partes[i]));
            }
        }

        return equipo;
    }
}
