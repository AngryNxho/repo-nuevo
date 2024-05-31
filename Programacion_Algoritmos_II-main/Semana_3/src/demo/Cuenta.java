package demo;

public class Cuenta {
    int numeroCuenta;
    int totalPagado;
    int cuotasPagadas;
    int cuotasPendientes;

    public Cuenta(int numeroCuenta, int totalPagado, int cuotasPagadas, int cuotasPendientes) {
        this.numeroCuenta = numeroCuenta;
        this.totalPagado = totalPagado;
        this.cuotasPagadas = cuotasPagadas;
        this.cuotasPendientes = cuotasPendientes;
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public int getTotalPagado() {
        return this.totalPagado;
    }

    public int getCuotasPagadas() {
        return this.cuotasPagadas;
    }

    public int getCuotasPendientes() {
        return this.cuotasPendientes;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTotalPagado(int totalPagado) {
        this.totalPagado = totalPagado;
    }

    public void setCuotasPagadas(int cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public void setCuotasPendientes(int cuotasPendientes) {
        this.cuotasPendientes = cuotasPendientes;
    }

    public void pagarCuota(int monto) {
        this.totalPagado += monto;
        this.cuotasPagadas++;
        this.cuotasPendientes--;
    }

    public void consultarCuotasPagar() {
        System.out.println("Número de cuotas por pagar: " + this.cuotasPendientes);
    }

    public void consultarCuotasPagadas() {
        System.out.println("Número de cuotas pagadas: " + this.cuotasPagadas);
        System.out.println("Total pagado: " + this.totalPagado);
    }
}
