package ejercicios.ejercicio2_1;

public class Persona {
    // Atributos
    String nombre;
    String apellidos;
    String numeroDocumentoIdentidad;
    int anoNacimiento;

    // Constructor
    public Persona(String nombre, String apellidos, String numeroDocumentoIdentidad, int anoNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
        this.anoNacimiento = anoNacimiento;
    }

    // Método para imprimir
    public void imprimir() {
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellidos = " + apellidos);
        System.out.println("Numero de documento de identidad = " + numeroDocumentoIdentidad);
        System.out.println("Año de nacimiento = " + anoNacimiento);
        System.out.println();
    }
}