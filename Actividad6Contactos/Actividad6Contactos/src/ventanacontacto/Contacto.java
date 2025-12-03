package ventanacontacto;

import java.time.LocalDate;

public class Contacto {
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion; // Variable que queremos mostrar
    private String telefono;
    private String correo;

    public Contacto(String nombres, String apellidos, LocalDate fechaNacimiento,
                    String direccion, String telefono, String correo) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion; // Se almacena correctamente
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Se modifica el método toString() para incluir la dirección.
     * El formato ahora es: Nombres Apellidos | Fecha | Dirección | Teléfono | Correo
     */
    @Override
    public String toString() {
        // Se añade " | " + direccion a la cadena de retorno
        return nombres + " " + apellidos + " | " + fechaNacimiento +
                " | " + direccion + " | " + telefono + " | " + correo; 
    }
}