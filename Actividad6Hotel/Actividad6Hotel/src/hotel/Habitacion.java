package hotel;

public class Habitacion {

    private int numero;
    private boolean disponible;
    private double precio;
    private String fechaIngreso;
    private Huesped huesped;

    public Habitacion(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.disponible = true;
    }

    public int getNumero() { return numero; }
    public boolean isDisponible() { return disponible; }
    public double getPrecio() { return precio; }
    public String getFechaIngreso() { return fechaIngreso; }
    public Huesped getHuesped() { return huesped; }

    public void ocupar(String fecha, Huesped h) {
        this.disponible = false;
        this.fechaIngreso = fecha;
        this.huesped = h;
    }

    public void liberar() {
        this.disponible = true;
        this.fechaIngreso = null;
        this.huesped = null;
    }
}

