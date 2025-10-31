import java.util.InputMismatchException;

public class CalculosNumericos {

static void calcularLogaritmoNeperiano(double valor) {
    try {
        if (valor < 0) {
            // Si el valor es negativo, se genera una excepción aritmética
            throw new ArithmeticException("El valor debe ser un número positivo");
        }

        // Si el valor es positivo, se calcula el logaritmo neperiano
        double resultado = Math.log(valor);
        System.out.println("Resultado = " + resultado);

    } catch (ArithmeticException e) {
        /* Si ocurre una excepción aritmética, se muestra un mensaje de error */
        System.out.println("El valor debe ser un número positivo para calcular el logaritmo");

    } 
    catch (InputMismatchException e) {
        /* Si el valor a calcular no es numérico, se muestra un mensaje de error */
        System.out.println("El valor debe ser numérico para calcular el logaritmo");
    }
}
 static void calcularRaízCuadrada(double valor) {
 try {
        if (valor < 0) {
        // Si el valor es negativo, se genera una excepción aritmética
        throw new ArithmeticException("El valor debe ser un número positivo");
        }
        double resultado = Math.sqrt(valor); /* Si el valor es positivo, 
        se calcula la raíz cuadrada */

        System.out.println("Resultado = " + resultado);
    } 
 catch (ArithmeticException e) {
 /* Si ocurre una excepción aritmética, se muestra un mensaje 
de error */
    System.out.println("El valor debe ser un número positivo para calcular la raíz cuadrada");
    } 
catch (InputMismatchException e) {
 /* Si el valor a calcular no es numérico, se muestra un mensaje 
de error */
    System.out.println("El valor debe ser numérico para calcular la raíz cuadrada" );
    }
 }
}
