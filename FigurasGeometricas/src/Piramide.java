public class Piramide extends FiguraGeometrica {
    private final double base;     // lado de la base cuadrada
    private final double altura;
    private final double apotema;  // apotema lateral

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        setVolumen(calcularVolumen());
        setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return (Math.pow(base, 2.0) * altura) / 3.0;
    }

    public double calcularSuperficie() {
        double areaBase = Math.pow(base, 2.0);
        double areaLados = 2.0 * base * apotema;
        return areaBase + areaLados;
    }

    public double getBase()    { return base; }
    public double getAltura()  { return altura; }
    public double getApotema() { return apotema; }
}
