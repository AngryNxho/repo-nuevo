import java.util.Scanner;

public class Aplicacion  {
    String codigo;
    String descripcionP; 
    String precioP;

    public Aplicacion (String codigo, String descripcionP, String precioP){
        this.codigo = codigo;
        this.descripcionP = descripcionP;
        this.precioP = precioP;
    }
    

    public static void main (String args[]){
        Scanner inputNumero = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        String numero = inputNumero.nextLine();

        Integer i = 0;
        Integer x = 0;
        Integer z = 0;

        while (numero.length() == 0 && i < 2){
            inputNumero = new Scanner(System.in);
            System.out.println("Ingrese un numero entero: ");
            numero = inputNumero.nextLine();
            i++;
            if (i == 2 && numero.length() == 0){
                System.exit(0);
            }
        }

        Scanner inputDesc = new Scanner(System.in);
        System.out.println("Ingrese una descripcion: ");
        String descripcion = inputDesc.nextLine();

        while (descripcion.length() == 0 && x < 2){
            inputDesc = new Scanner(System.in);
            System.out.println("Ingrese una descripcion: ");
            descripcion = inputDesc.nextLine();
            x++;

            if (x == 2 && descripcion.length() == 0){
                System.exit(0);
            }
        }

        Scanner inputPrecio = new Scanner(System.in);
        System.out.println("Ingrese el precio: ");
        String precio = inputDesc.nextLine();
        
        while (precio.length() == 0 && z < 2){
            inputPrecio = new Scanner(System.in);
            System.out.println("Ingrese el precio: ");
            precio = inputPrecio.nextLine();
            z++;

            if (z == 2 && precio.length() == 0){
                System.exit(0);
            }
        }

        Aplicacion programa = new Aplicacion(numero, descripcion, precio);

        System.out.println("Datos del producto");

        System.out.println("\nCódigo: " + programa.codigo);
        System.out.println("\nDescripción: " + programa.descripcionP);
        System.out.println("\nPrecio: " + programa.precioP);
        // Aplicacion camioneta;
        // Aplicacion auto;
        // camioneta = new Aplicacion("Hola", 3);
        // auto = new Aplicacion("Chao",2);

        // System.out.println(camioneta.nombre);
        // System.out.println(auto.nombre);
    }
}