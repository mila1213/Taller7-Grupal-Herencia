package SistemaBancario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        Empleado empleado = null;

        int opcion = 0;

        do {
            try {
                System.out.println("\n---- SISTEMA BANCARIO ------");
                System.out.println("1. Registrar Cliente");
                System.out.println("2. Ingresar como Cliente");
                System.out.println("3. Ingresar como Empleado");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        System.out.println("\n--- Registro de Cliente ---");
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();
                        System.out.print("Direccion: ");
                        String direccion = sc.nextLine();
                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        cliente = new Cliente(nombre, cedula, direccion, telefono);
                        System.out.println("Cliente registrado exitosamente.");
                        break;

                    case 2:
                        if (cliente == null) {
                            System.out.println("No hay clientes registrados todavía.");
                            break;
                        }

                        System.out.println("\n--- Menú Cliente ---");
                        cliente.mostrarRol();
                        System.out.println("1. Registrar Cuenta");
                        System.out.println("2. Solicitar Préstamo");
                        System.out.println("3. Ver Resumen Financiero");
                        System.out.print("Seleccione una opción: ");

                        int opcCliente = Integer.parseInt(sc.nextLine());
                        switch (opcCliente) {
                            case 1:
                                System.out.print("Tipo de cuenta: ");
                                String tipo = sc.nextLine();
                                cliente.registrarCuenta(tipo);
                                break;
                            case 2:
                                System.out.print("Monto del préstamo: ");
                                double monto = Double.parseDouble(sc.nextLine());
                                cliente.solicitarPrestamo(monto);
                                break;
                            case 3:
                                cliente.verResumenFinanciero();
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Ingreso Empleado ---");
                        System.out.print("Usuario: ");
                        String user = sc.nextLine();
                        System.out.print("Clave: ");
                        String clave = sc.nextLine();

                        System.out.print("Rol (Cajero / BalconServicios / JefeAgencia): ");
                        String rol = sc.nextLine();

                        empleado = new Empleado("admi", "0000", "Oficina", "0000", user, clave, rol);

                        if (!empleado.autenticarEmpleado(user, clave)) {
                            System.out.println("Credenciales inválidas.");
                            break;
                        }

                        System.out.println("Ingreso exitoso.");

                        if (rol.equalsIgnoreCase("Cajero")) {
                            System.out.println("1. Procesar Retiro");
                            System.out.println("2. Procesar Depósito");
                            System.out.println("3. Consultar Saldo");
                            System.out.print("Seleccione: ");

                            int opcCajero = Integer.parseInt(sc.nextLine());

                            if (cliente == null) {
                                System.out.println("No existe cliente para operar.");
                                break;
                            }

                            switch (opcCajero) {
                                case 1:
                                    System.out.print("Monto: ");
                                    double ret = Double.parseDouble(sc.nextLine());
                                    empleado.procesarRetiro(cliente, ret);
                                    break;
                                case 2:
                                    System.out.print("Monto: ");
                                    double dep = Double.parseDouble(sc.nextLine());
                                    empleado.procesarDeposito(cliente, dep);
                                    break;
                                case 3:
                                    empleado.consultarSaldo(cliente);
                                    break;
                            }
                        }

                        if (rol.equalsIgnoreCase("BalconServicios")) {
                            System.out.println("1. Registrar Nuevo Cliente");
                            System.out.println("2. Actualizar Datos Cliente");
                            System.out.print("Seleccione: ");
                            int opcB = Integer.parseInt(sc.nextLine());

                            switch (opcB) {
                                case 1:
                                    System.out.print("Nombre: "); String n = sc.nextLine();
                                    System.out.print("Cedula: "); String c = sc.nextLine();
                                    System.out.print("Direccion: "); String d = sc.nextLine();
                                    System.out.print("Telefono: "); String t = sc.nextLine();
                                    empleado.registrarNuevoCliente(n, c, d, t);
                                    break;
                                case 2:
                                    if (cliente == null) {
                                        System.out.println("No hay cliente registrado.");
                                        break;
                                    }
                                    System.out.print("Nueva dirección: "); String nd = sc.nextLine();
                                    System.out.print("Nuevo teléfono: "); String nt = sc.nextLine();
                                    empleado.actualizarDatosCliente(cliente, nd, nt);
                                    break;
                            }
                        }

                        if (rol.equalsIgnoreCase("JefeAgencia")) {
                            System.out.println("1. Aprobar préstamo");
                            System.out.println("2. Generar reporte");
                            System.out.print("Seleccione: ");

                            int opcJ = Integer.parseInt(sc.nextLine());

                            if (cliente == null) {
                                System.out.println("No existe cliente para evaluar.");
                                break;
                            }

                            switch (opcJ) {
                                case 1:
                                    empleado.aprobarPrestamo(cliente, 5000);
                                    break;
                                case 2:
                                    empleado.generarReporteOperaciones();
                                    break;
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("Error: Entrada no válida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}

