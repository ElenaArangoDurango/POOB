/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arang
 */
public class Calculos {

    // Método para calcular el salario bruto
    public static double calcularSalarioBruto(double horas, double valorHora) {
        return horas * valorHora;
    }

    // Método para calcular la retención en la fuente
    public static double calcularRetencion(double salarioBruto, double porcentaje) {
        return salarioBruto * (porcentaje / 100);
    }

    // Método para calcular el salario neto
    public static double calcularSalarioNeto(double salarioBruto, double retencion) {
        return salarioBruto - retencion;
    }
}
