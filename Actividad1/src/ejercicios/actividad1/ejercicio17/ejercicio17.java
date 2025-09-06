package ejercicios.actividad1.ejercicio17;

import java.util.Scanner;

public class ejercicio17 {
    public static void main(String[] args) {
        double radio, area, perimetro;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el radio del circulo:");
        radio = scanner.nextDouble();

        perimetro = Calculos17.calcular_perimetro(radio);
        area = Calculos17.calcular_area(radio);

        System.out.println("El perímetro de círculo es: "+ perimetro);
        System.out.println("El área del círculo es: " + area );

        scanner.close();
    }

}
