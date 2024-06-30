package com.westmarket.busines; 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final List<Producto> productos;
    private final List<Categoria> categorias;

    public Main() {
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Bebidas"));
        categorias.add(new Categoria(2, "Congelados"));
        categorias.add(new Categoria(3, "Lácteos"));
        categorias.add(new Categoria(4, "Aseo"));
        productos = new ArrayList<>();
        
        
    }
    
//
//
    public static void main(String[] args) {
        Main miniMarket = new Main();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion = 0;
//
            do {
                System.out.println("\n--- West Market ---");
                System.out.println("1. Registrar producto");
                System.out.println("2. Imprimir datos del producto");
                System.out.println("3. Eliminar producto");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); 
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); 
                    continue;
                }
//
                switch (opcion) {
                    case 1:
                        miniMarket.registrarProducto(scanner);
                        break;
                    case 2:
                        miniMarket.imprimirProductos();
                        break;
                    case 3:
                        miniMarket.eliminarProducto(scanner);
                        break;
                    case 4:
                        System.out.println("Ha salido del sistema");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } while (opcion != 4);
        }
    }
//
    private void registrarProducto(Scanner scanner) {
        int codigo = ingresarEntero(scanner, "Ingrese código del producto: ");
        String descripcion = ingresarTexto(scanner, "Ingrese descripción del producto: ");
        int precio = ingresarEntero(scanner, "Ingrese precio del producto: ");
        int stock = ingresarEntero(scanner, "Ingrese stock del producto: ");
        Categoria categoria = seleccionarCategoria(scanner);
//
        Producto producto = new Producto(codigo, descripcion, precio, stock, categoria);
        productos.add(producto);
        System.out.println("Producto registrado exitosamente.");
    }
//
    private int ingresarEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        int intentos = 0;
        boolean valido = false;
        while (!valido && intentos < 3) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine(); 
                valido = true;
            } else {
                System.out.println("Debe ingresar un número entero.");
                scanner.nextLine();
                intentos++;
                if (intentos >= 3) {
                    salirSistema();
                }
            }
        }
        return valor;
    }
//
    private String ingresarTexto(Scanner scanner, String mensaje) {
        String texto = "";
        int intentos = 0;
        boolean valido = false;
        while (!valido && intentos < 3) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (!texto.isEmpty()) {
                valido = true;
            } else {
                System.out.println("Debe ingresar un texto.");
                intentos++;
                if (intentos >= 3) {
                    salirSistema();
                }
            }
        }
        return texto;
    }
//
    private Categoria seleccionarCategoria(Scanner scanner) {
        System.out.println("Seleccione una categoría:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
//
        int codigoCategoria;
        int intentos = 0;
        Categoria categoriaSeleccionada = null;
        while (categoriaSeleccionada == null && intentos < 3) {
            System.out.print("Ingrese el código de la categoría: ");
            if (scanner.hasNextInt()) {
                codigoCategoria = scanner.nextInt();
                scanner.nextLine(); 
                for (Categoria categoria : categorias) {
                    if (categoria.getCodigo() == codigoCategoria) {
                        categoriaSeleccionada = categoria;
                        break;
                    }
                }
                if (categoriaSeleccionada == null) {
                    System.out.println("Categoría inválida.");
                    intentos++;
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                scanner.nextLine(); 
                intentos++;
            }
            if (intentos >= 3) {
                salirSistema();
            }
        }
        return categoriaSeleccionada;
    }
//
    private void imprimirProductos() {
        System.out.println("--- Listado de productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            productos.forEach(producto -> {
                producto.imprimirListado();
            });
        }
    }
//
    private void eliminarProducto(Scanner scanner) {
        System.out.println("\n--- Productos ingresados ---");
        for (Producto lista : productos) {
            System.out.println("\nCódigo: " + lista.getCodigo() + "\nDescripción: " +lista.getDescripcion() + "\n--------------------------------------------");
        }
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
//
        int codigo = ingresarEntero(scanner, "Ingrese el código del producto a eliminar: ");
        Producto productoAEliminar = null;
//
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                productoAEliminar = producto;
                break;
            }
        }
//
        if (productoAEliminar != null) {
            //productoAEliminar.imprimirListadoSimple(); 
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
//
    private void salirSistema() {
        System.out.println("Ha superado la cantidad máxima de intentos.");
        System.exit(0);
    }
    
    
//}



//package com.westmarket.busines; 

//import com.westmarket.ui.Ventana;

//public class Main {
   public static void main(String args[]) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
//}

package com.westmarket.busines;

import com.westmarket.ui.Ingrese_datos;
import com.westmarket.ui.Ventana;

public class Main {
    public static void main(String[] args) {
        Ingrese_datos ingr = new Ingrese_datos();
        ingr.setVisible(true);
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        
    }
    
    
    
}

