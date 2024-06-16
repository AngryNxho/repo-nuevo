import java.util.ArrayList();

public class Producto {
    private int identificador;
    private String descripcion;
    private int precio;
    private Categoria categoria;

    public Producto(int identificador, String descripcion, int precio, Categoria categoria) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public static void main(String args[]) {
        Categoria cat1 = new Categoria(1, "Electro");
        Categoria cat2 = new Categoria(2, "afds");

        Producto prod1 = new Producto(111, "Licuadora", 123123, cat1);
        Producto prod2 = new Producto(123, "ora", 8943, cat2);
    }
}
