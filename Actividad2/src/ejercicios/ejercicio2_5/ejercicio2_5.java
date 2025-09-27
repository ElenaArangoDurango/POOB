package ejercicios.ejercicio2_5;

import java.util.Scanner;

public class ejercicio2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos al usuario
        System.out.print("Ingrese nombres del titular: ");
        String nombres = sc.nextLine();

        System.out.print("Ingrese apellidos del titular: ");
        String apellidos = sc.nextLine();

        System.out.print("Ingrese número de cuenta: ");
        int numeroCuenta = sc.nextInt();
        sc.nextLine(); // limpiar salto de línea

        System.out.print("Ingrese tipo de cuenta (AHORROS/CORRIENTE): ");
        String tipoTexto = sc.nextLine().toUpperCase();
        CuentaBancaria.Tipo tipoCuenta = CuentaBancaria.Tipo.valueOf(tipoTexto);

        // Crear cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria(nombres, apellidos, numeroCuenta, tipoCuenta);

        // Imprimir
        cuenta.imprimir();

        // Operaciones desde usuario
        System.out.print("¿Cuánto desea consignar? ");
        int valorConsignar = sc.nextInt();
        cuenta.consignar(valorConsignar);

        System.out.print("¿Cuánto desea retirar? ");
        int valorRetirar = sc.nextInt();
        cuenta.retirar(valorRetirar);
        cuenta.imprimir();

        sc.close();
    }
}
