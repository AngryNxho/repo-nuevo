package demo;
import java.util.Scanner;

public class Main {
    
    public void comprobarRut(String rut) {
        System.out.println(rut);
        }

    public static void main(String[] args) {
        System.out.println("Hola");
        Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("\n1. Registrar Socio" +
                "\n2. Ver datos del socio" +
                "\n3. Pagar cuota del socio" +
                "\n4. Consultar Numero de Cuotas por Cancelar" +
                "\n5. Consultar Monto Total de Cuotas canceladas del Socio" +
                "\n6. Salir del Programa");
                System.out.println("Ingrese la opción que desea realizar: ");
                String pregunta = input.nextLine();
                if (pregunta.equals("1")) {
                    
                    System.out.println("Ingrese su rut: ");
                    String rut = input.nextLine();
                    while (rut.length() > 12 || rut.length() < 11) {
                        System.out.println(rut + " es invalido: "
                        +"\nEl rut debe contener un minimo de 11 y un maximo de 12 caracteres");
                        rut = input.nextLine();
                        if (!rut.contains(".") || !rut.contains("-")) {
                            System.out.println("El Rut debe incluir  puntos y guion"); 
                        }
                    
                    }
                    System.out.println(rut.length());

                    System.out.println("Ingrese su Nombre: ");
                    String nombre = input.nextLine();

                    System.out.println("Ingrese su Apellido paterno: ");
                    String paterno = input.nextLine();

                    System.out.println("Ingrese su Apellido materno: ");
                    String materno = input.nextLine();

                    System.out.println("Ingrese su Correo: ");
                    String correo = input.nextLine();

                    System.out.println("Ingrese su Domicilio: ");
                    String domicilio = input.nextLine();

                    System.out.println("Ingrese su Region: ");
                    String region = input.nextLine();

                    System.out.println("Ingrese su Ciudad: ");
                    String ciudad = input.nextLine();

                    System.out.println("Ingrese su Comuna: ");
                    String comuna = input.nextLine();
                    
                    System.out.println("Ingrese su telefono: ");
                    String telefono = input.nextLine();

                    // Socio cliente = new Socio(rut,
                    // nombre,
                    // paterno,
                    // materno,
                    // correo,
                    // domicilio,
                    // region,
                    // ciudad,
                    // comuna,
                    // telefono);
                } else if (pregunta.equals("2")) {
                    System.out.println("datos");
                } else if (pregunta.equals("3")) {
                    System.out.println("Ingrese un monto de cuota a cancelar: ");
                    int montoCuota = input.nextInt();
                    while (montoCuota < 1) {
                        System.out.println("Debe Ingresar un monto Superior a 0. Ingrese nuevamente: ");
                        montoCuota = input.nextInt();
                        System.out.println("Pago realizado de manera exitosa!");

                    } 
                }
                else if (pregunta.equals("6")) {
                    break;
                }
        }
        
    }

    
}
