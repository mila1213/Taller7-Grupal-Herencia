package SistemaBancario;

public class Cliente extends Personas {

    // Constructor
    public Cliente(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono);
    }

    // Metodo
    public boolean ingresarAlSistema() {
        // Simulación básica
        return true;
    }

    public void registrarCuenta(String tipo) {
        System.out.println("Cuenta de tipo '" + tipo + "' registrada correctamente.");
    }

    public void solicitarPrestamo(double monto) {
        System.out.println("Solicitud de préstamo por $" + monto + " enviada.");
    }

    public void agregarTarjetaCredito(String tarjeta) {
        System.out.println("Tarjeta de crédito '" + tarjeta + "' agregada al cliente.");
    }

    public void verResumenFinanciero() {
        System.out.println("Mostrando resumen financiero de: " + nombre);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol:Cliente bancario");
    }
}