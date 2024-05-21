import java.util.Scanner;
public class Palindromo{
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el numero: ");
        String numero = input.nextLine();
        Integer contador = 0;
        for (int i = 0, x = -1; i < numero.length(); i++, x--){
            String ultimoDigAsc = Character.toString(numero.charAt(i));
            String ultimoDigDesc = Character.toString(numero.charAt(numero.length() + x));
            if (ultimoDigAsc.equals(ultimoDigDesc)) {
                contador++;
            }
        } 
        if (contador >= numero.length()){
            System.out.println("El numero " + numero + " es palindromo") ;
        }else {
            System.out.println("El numero" + " " + numero + " " +  "no es palindromo") ;
        }
    }
}