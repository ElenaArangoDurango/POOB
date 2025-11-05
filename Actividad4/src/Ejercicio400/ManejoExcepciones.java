package Ejercicio400;
public class ManejoExcepciones {

    public static void ejecutarBloques() {
        try {
            System.out.println("Primer try");
            double cociente = 10000 / 0;
        } catch (ArithmeticException e) {
            System.out.println("División por cero");
        } finally {
            System.out.println("Primer finally");
        }

        try {
            System.out.println("Segundo try");
            Object obj = null;
            obj.toString();
        } catch (Exception e) {
            System.out.println("Ocurrió una excepción");
        } finally {
            System.out.println("Segundo finally");
        }
    }
}
