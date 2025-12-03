package hotel;

public class Huesped {

    private String nombre;
    private String apellidos;
    private String documento;

    public Huesped(String nombre, String apellidos, String documento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getDocumento() { return documento; }
}

