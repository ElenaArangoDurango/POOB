package ejercicios.actividad1.ejercicio5;

import java.util.Scanner;

public class ejercicio5 {
   public static void main(String[] args) {
    double suma, x, y;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingresa un número para suma:");
    suma = scanner.nextDouble(); 
    // Lee desde el teclado y asigna la variable correspondiente

    System.out.println("Ingresa un número para x:");
    x = scanner.nextDouble(); 

    System.out.println("Ingresa un número para y:");
    y = scanner.nextDouble(); 


    suma = Calculos5.calcular_suma(suma, x);
    x = Calculos5.calcular_x(x,y);
    suma = suma + (x/y);

    System.out.println("El valor de la suma es: " + suma);

    scanner.close();

   
    } 


}
