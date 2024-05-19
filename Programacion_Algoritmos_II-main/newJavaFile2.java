import java.util.Scanner;
public class newJavaFile2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese clave de seguridad:");
        String clave = lector.nextLine();
        String caracteres = "abcdefghijklmnñopqrstuvwxyz";
        String numeros = "1234567890";
        clave = clave.toLowerCase();
        System.out.println(clave);
        Boolean bucle = false;
        Integer i = 0;

        Integer letra = 0;
        Integer numero = 0;
        Integer noNumeroLetra = 0;
            while (i < clave.length()){
                if (caracteres.contains(Character.toString(clave.charAt(i)))){
                    letra++ ;
                }
                else if (numeros.contains(Character.toString(clave.charAt(i)))){
                    numero++;
                }else {
                    noNumeroLetra++;
                }
                i++;
            }
    
            if (clave.length() >= 6 && letra >= 1 && numero >= 1 && noNumeroLetra >= 1){
                System.out.println("La clave cumple con los requisitos");
            }else{
                System.out.println("la clave no cumple con los requisitos");
            }
            // System.out.println(letra);
            // System.out.println(numero);
            // System.out.println(noNumeroLetra);
    
            lector.close();

    }
}

