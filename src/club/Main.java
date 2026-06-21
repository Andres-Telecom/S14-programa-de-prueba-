package club;

import java.util.Scanner;
import club.Socio.Tipo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        Club c = new Club();

        do {
            System.out.println("\n--- MENÚ DEL CLUB SOCIAL ---");
            System.out.println("1. Afiliar un socio al club.");
            System.out.println("2. Registrar una persona autorizada por un socio.");
            System.out.println("3. Pagar una factura.");
            System.out.println("4. Registrar un consumo en la cuenta de un socio.");
            System.out.println("5. Aumentar fondos de la cuenta de un socio.");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");

            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: {
                        System.out.print("Ingrese la cédula del socio: ");
                        String cedula = sc.nextLine();
                        System.out.print("Ingrese el nombre del socio: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el tipo de socio (1. Regular, 2. VIP ");
                        int tipoInt = Integer.parseInt(sc.nextLine());

                        Tipo tipo;
                        if (tipoInt == 1) {
                            tipo = Tipo.REGULAR;
                        } else if (tipoInt == 2) {
                            tipo = Tipo.VIP;
                        } else {
                            System.out.println("[Error] Tipo de socio inválido.");
                            break;
                        }

                        c.afiliarSocio(cedula, nombre, tipo);
                        System.out.println("¡Socio afiliado exitosamente!");
                        break;
                    }

                    case 2: {
                        System.out.print("Ingrese la cédula del socio: ");
                        String cedulaSocio = sc.nextLine();
                        System.out.print("Ingrese el nombre de la persona autorizada: ");
                        String nombreAutorizado = sc.nextLine();

                        c.agregarAutorizadoSocio(cedulaSocio, nombreAutorizado);
                        System.out.println("¡Persona autorizada registrada con éxito!");
                        break;
                    }

                    case 3: {
                        System.out.print("Ingrese la cédula del socio: ");
                        String cedulaSocio = sc.nextLine();
                        System.out.print("Ingrese el número/índice de la factura a pagar: ");
                        int numFactura = Integer.parseInt(sc.nextLine());

                        c.pagarFacturaSocio(cedulaSocio, numFactura);
                        System.out.println("¡Factura pagada con éxito!");
                        break;
                    }

                    case 4: {
                        System.out.print("Ingrese el concepto del consumo: ");
                        String concepto = sc.nextLine();
                        System.out.print("Ingrese el valor del consumo: ");
                        double valor = Double.parseDouble(sc.nextLine());
                        System.out.print("Ingrese la cédula del socio: ");
                        String cedulaSocio = sc.nextLine();
                        System.out.print("Ingrese el nombre del consumidor (socio o autorizado): ");
                        String consumidor = sc.nextLine();

                        try {
                            c.registrarConsumo(cedulaSocio, consumidor, concepto, valor);
                            System.out.println("¡Consumo registrado con éxito!");
                        } catch (Exception e) {
                            System.out.println("Error al registrar consumo: " + e.getMessage());
                        }
                        break;
                    }

                    case 5: {
                        System.out.print("Ingrese la cédula del socio: ");
                        String cedulaSocio = sc.nextLine();
                        System.out.print("Ingrese el valor a recargar: ");
                        double monto = Double.parseDouble(sc.nextLine());

                        c.aumentarFondosSocio(cedulaSocio, monto);
                        System.out.println("¡Fondos aumentados correctamente!");
                        break;
                    }

                    case 6: {
                        System.out.println("¡Gracias por usar el sistema!");
                        break;
                    }

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("[Error de Formato] Por favor ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("[Error de Negocio] " + e.getMessage());
            }

        } while (op != 6);

        sc.close();
    }
}