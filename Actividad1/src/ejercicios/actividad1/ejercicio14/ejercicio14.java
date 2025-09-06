package ejercicios.actividad1.ejercicio14;

import java.util.Scanner;

public class ejercicio14 {
   public static void main(String[] args) {
    double numero, cuadrado, cubo;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese un número:");
    numero = scanner.nextDouble();

    cuadrado = Calculos14.calcular_cuadrado(numero);
    cubo = Calculos14.calcular_cubo(numero);

    System.out.println("Numero: " + numero);
    System.out.println("El cuadrado de " + numero + " es: " + cuadrado);
    System.out.println("El cubo de " + numero + " es: " + cubo );
    scanner.close(); // Cerrar el scanner al final
    
   } 
}
