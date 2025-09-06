package ejercicios.actividad1.ejercicio4; //paquete en el que se encuentra el archivo

import java.util.Scanner;
// Esta clase contiene el main que es el punto de entrada
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la edad de Juan: ");
        double edadJuan = sc.nextDouble();
//Aquí se crea un objeto de la clase Calculos, Calculos es la plantilla y calculos es el objeto real 
        Calculos calculos = new Calculos();
        //Aquí se llama a un método del objeto calculos
        double edadAlberto = calculos.calcularEdadAlberto(edadJuan);
        double edadAna     = calculos.calcularEdadAna(edadJuan);
        double edadMama    = calculos.calcularEdadMama(edadJuan, edadAlberto, edadAna);

        System.out.println("Edad de Juan: " + edadJuan);
        System.out.println("Edad de Alberto: " + edadAlberto);
        System.out.println("Edad de Ana: " + edadAna);
        System.out.println("Edad de Mamá: " + edadMama);

        sc.close();
    }
    
}
