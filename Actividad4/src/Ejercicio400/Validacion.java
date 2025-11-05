package Ejercicio400;
public class Validacion {

    public static double calcularDivision(double numerador, double denominador) {
        double cociente = 0;

        try {
            if (denominador > 0) {
                cociente = numerador / denominador;
            }
        } catch (ArithmeticException e) {
            return cociente;
        }

        return cociente;
    }

    public static String ObtenerTexto(String mensaje) {
        try {
            if (!mensaje.isEmpty()) {
                return mensaje;
            }
        } catch (Exception ex) {
            return "Error: " + ex.getMessage();
        }
        return "Texto vacío";
    }
}
