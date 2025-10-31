import java.util.Scanner;

public class VentanaPrincipal {
     public static void main(String args[]) {
 System.out.print("Valor numérico = ");
 Scanner teclado = new Scanner(System.in);
 double valor = teclado.nextDouble();
  calcularLogaritmoNeperiano(valor);
  calcularRaízCuadrada(valor);
 }
 }
}
