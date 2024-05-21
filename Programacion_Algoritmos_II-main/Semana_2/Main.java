public class Main {
    public class Vehiculo {
        String ppu;
        String color;
        String marca;
        String modelo;
        int nroPuertas;
        int nroAsientos;
        float velocidad;
        boolean estadoMotor;

        Vehiculo (){
             
        }
        public Vehiculo (String ppu, 
        String color,
        String marca, 
        String modelo,
        int nroPuertas,
        int nroAsientos,
        int velocidad,
        Boolean estadoMotor){
            this.ppu = ppu;
            this.color = color;
            this.marca = marca;
            this.modelo = modelo;
            this.nroPuertas = nroPuertas;
            this.nroAsientos = nroAsientos;
            this.velocidad = velocidad;
            this.estadoMotor = estadoMotor;
        }

    }

    public static void main (String args[]){
        Vehiculo camioneta;
        camioneta = new Vehiculo();


    }
}