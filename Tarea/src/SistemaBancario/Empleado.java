package SistemaBancario;

public class Empleado extends Personas {

    private String usuario;
    private String clave;
    private String rol; // Cajero, BalconServicios, JefeAgencia

    public Empleado(String nombre, String cedula, String direccion, String telefono,
                    String usuario, String clave, String rol) {
        super(nombre, cedula, direccion, telefono);
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }

    // Mwtodo
    public boolean autenticarEmpleado(String usuario, String clave) {
        return this.usuario.equals(usuario) && this.clave.equals(clave);
    }

    // Métodos comunes del empleado
    public void crearCuentaParaCliente(Cliente cliente, String tipo) {
        System.out.println("Empleado creó una cuenta tipo '" + tipo + "' para " + cliente.getNombre());
    }

    public void modificarDatosCliente(Cliente cliente) {
        System.out.println("Datos de cliente modificados: " + cliente.getNombre());
    }

    public void registrarPrestamo(Cliente cliente, double monto) {
        System.out.println("Empleado registró un préstamo de $" + monto + " para " + cliente.getNombre());
    }

    public void cerrarCuenta(Cliente cliente, String cuenta) {
        System.out.println("Cuenta '" + cuenta + "' cerrada para el cliente " + cliente.getNombre());
    }

    // Métodos según rol
    public void procesarRetiro(Cliente cliente, double monto) {
        if (rol.equalsIgnoreCase("Cajero")) {
            System.out.println("Retiro procesado por $" + monto + " al cliente " + cliente.getNombre());
        }
    }

    public void consultarSaldo(Cliente cliente) {
        if (rol.equalsIgnoreCase("Cajero")) {
            System.out.println("Consultando saldo para: " + cliente.getNombre());
        }
    }

    public void procesarDeposito(Cliente cliente, double monto) {
        if (rol.equalsIgnoreCase("Cajero")) {
            System.out.println("Depósito de $" + monto + " procesado para " + cliente.getNombre());
        }
    }

    public Cliente registrarNuevoCliente(String nombre, String cedula, String direccion, String telefono) {
        if (rol.equalsIgnoreCase("BalconServicios")) {
            System.out.println("Nuevo cliente registrado: " + nombre);
            return new Cliente(nombre, cedula, direccion, telefono);
        }
        return null;
    }

    public void actualizarDatosCliente(Cliente cliente, String direccion, String telefono) {
        if (rol.equalsIgnoreCase("BalconServicios")) {
            cliente.actualizarDatos(direccion, telefono);
            System.out.println("Datos actualizados para: " + cliente.getNombre());
        }
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {
        if (rol.equalsIgnoreCase("JefeAgencia")) {
            System.out.println("Préstamo aprobado para " + cliente.getNombre());
            return true;
        }
        return false;
    }

    public void generarReporteOperaciones() {
        if (rol.equalsIgnoreCase("JefeAgencia")) {
            System.out.println("Generando reporte de operaciones...");
        }
    }

    public void evaluarEmpleado(Empleado empleado) {
        if (rol.equalsIgnoreCase("JefeAgencia")) {
            System.out.println("Evaluando empleado: " + empleado.getNombre());
        }
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol del empleado: " + rol);
    }
}
