public class Cilindro extends FiguraGeometrica {
    private final double radio;
    private final double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        // Calcula y guarda en la superclase
        setVolumen(calcularVolumen());
        setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * altura * Math.pow(radio, 2.0);
    }

    public double calcularSuperficie() {
        double lateral = 2.0 * Math.PI * radio * altura;
        double tapas   = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return lateral + tapas;
    }

    public double getRadio()  { return radio;  }
    public double getAltura() { return altura; }
}
