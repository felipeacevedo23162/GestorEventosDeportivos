package co.edu.elpoli.ces3.gestoreventosdeportivos.modelo;

public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private String posicion;
    private int numero;
    private int equipoId;
    private boolean estadoActivo;

    public Jugador(int id, String nombre, String apellido, String fechaNacimiento, String nacionalidad,
                   String posicion, int numero, int equipoId, boolean estadoActivo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.numero = numero;
        this.equipoId = equipoId;
        this.estadoActivo = estadoActivo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getEquipoId() { return equipoId; }
    public void setEquipoId(int equipoId) { this.equipoId = equipoId; }

    public boolean isEstadoActivo() { return estadoActivo; }
    public void setEstadoActivo(boolean estadoActivo) { this.estadoActivo = estadoActivo; }

    @Override
    public String toString() {
        return id + "," + nombre + "," + apellido + "," + fechaNacimiento + "," + nacionalidad + "," + posicion + "," + numero + "," + equipoId + "," + estadoActivo;
    }

    public static Jugador fromString(String data) {
        String[] partes = data.split(",");
        return new Jugador(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3],
                partes[4],
                partes[5],
                Integer.parseInt(partes[6]),
                Integer.parseInt(partes[7]),
                Boolean.parseBoolean(partes[8])
        );
    }
}
