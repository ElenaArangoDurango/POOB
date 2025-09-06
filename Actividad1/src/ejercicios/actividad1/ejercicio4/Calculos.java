package ejercicios.actividad1.ejercicio4;
//cada clase describe atributos/metodos. Al ser una clase publica puede accederse a ella desde cualquier otra clase
public class Calculos {
//double devuelve un número decimal, el método se llama calcularEdadAlberto
    public double calcularEdadAlberto(double edadJuan) {
        return (2.0 / 3.0) * edadJuan;
    }

    public double calcularEdadAna(double edadJuan) {
        return (4.0 / 3.0) * edadJuan;
    }

    public double calcularEdadMama(double edadJuan, double edadAlberto, double edadAna) {
        return edadJuan + edadAlberto + edadAna;
    }
    
}
//la clase calculos no recuerda nada por sí sola, los métodos tampoco, reciben parámetros y devuelven un resultado 