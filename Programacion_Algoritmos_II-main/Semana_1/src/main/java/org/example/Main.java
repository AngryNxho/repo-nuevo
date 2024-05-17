package org.example;

import java.util.Scanner;


public class Main {

    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("Ingrese clave de seguridad");
            String clave = leer.nextLine();
            if (clave.length() >= 6) {
                Boolean letra = false;
                Boolean digito = false;
                Boolean caracterEspecial = false;
                for (int i = 0; i < clave.length(); i++) {
                    char caracter = clave.charAt(i);
                    if (Character.isLetter(caracter)) {
                        letra = true;
                    } else if (Character.isDigit(caracter)) {
                        digito = true;
                    } else {
                        caracterEspecial = true;
                    }
                }
                if (letra && digito && caracterEspecial) {
                    System.out.println("La clave cumple con los requisitos");
                    break;
                }
            }
            System.out.println("La clave no cumple con los requisitos");
        } while (true);
        leer.close();
    }
}
