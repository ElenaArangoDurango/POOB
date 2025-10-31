import java.util.InputMismatchException;

public class CalculosNumericos {

    public static double calcularLogaritmoNeperiano(double valor) {
        double resultado = 0;
        try {
            if (valor < 0) {
                // Si el valor es negativo, se genera una excepción aritmética
                throw new ArithmeticException("El valor debe ser un número positivo");
            }

            // Si el valor es positivo, se calcula el logaritmo neperiano
            resultado = Math.log(valor);
            return resultado;

        } catch (ArithmeticException e) {
            // Si ocurre una excepción aritmética, se muestra un mensaje de error
            System.out.println("El valor debe ser un número positivo para calcular el logaritmo");
            return resultado;

        } catch (InputMismatchException e) {
            // Si el valor a calcular no es numérico, se muestra un mensaje de error
            System.out.println("El valor debe ser numérico para calcular el logaritmo");
            return resultado;
        }
    }

    public static double calcularRaizCuadrada(double valor) {
        double resultado = 0;
        try {
            if (valor < 0) {
                // Si el valor es negativo, se genera una excepción aritmética
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            return Math.sqrt(valor);

        } catch (ArithmeticException e) {
            System.out.println("El valor debe ser un número positivo para calcular la raíz cuadrada");
            return resultado;

        } catch (InputMismatchException e) {
            System.out.println("El valor debe ser numérico para calcular la raíz cuadrada");
            return resultado;
        }
    }
}
