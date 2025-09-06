package ejercicios.actividad1.ejercicio12;

import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args) {
    double horas_laboradas, valor_hora, retencion, salario_bruto, salario_neto, valor_retencion_fuente;

    Scanner scanner = new Scanner(System.in); //lectura de la entrada
        
    System.out.println("Ingresa el número de horas trabajadas: ");
    horas_laboradas = scanner.nextDouble();

    System.out.println("Ingresa el valor de la hora: ");
    valor_hora = scanner.nextDouble();
    
    System.out.println("Ingresa un numero para la retención ");
    retencion = scanner.nextDouble();
  
    salario_bruto = Calculos12.calcular_salario_bruto(horas_laboradas,valor_hora);
    retencion = Calculos12.calcular_porcentaje_retencion(retencion);
    valor_retencion_fuente = Calculos12.calcular_valor_retencion_fuente(retencion, salario_bruto);
    salario_neto = Calculos12.calcular_salario_neto (salario_bruto, valor_retencion_fuente);
     
    System.out.println("Salario bruto: " + salario_bruto);
    System.out.println("El valor de la retención en la fuente es: " + valor_retencion_fuente);
    System.out.println("Salario neto: " + salario_neto);
    
    scanner.close();

    }
}

    



