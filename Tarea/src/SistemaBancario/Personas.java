package SistemaBancario;

public abstract class Personas {
    protected String nombre;
    protected String cedula;
    protected String direccion;
    protected String telefono;

    // Constructor
    public Personas(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Método para actualizar datos comunes
    public void actualizarDatos(String nuevaDireccion, String nuevoTelefono) {
        this.direccion = nuevaDireccion;
        this.telefono = nuevoTelefono;
    }

    // Método abstracto que debe implementarse en las subclases
    public abstract void mostrarRol();

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
