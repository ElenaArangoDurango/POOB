package nomina;

import java.util.ArrayList;

public class ListaEmpleados {

    private ArrayList<Empleado> lista = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        lista.add(e);
    }

    public double calcularTotalNomina() {
        return lista.stream().mapToDouble(Empleado::calcularNomina).sum();
    }

    public String[][] obtenerMatriz() {
        String[][] datos = new String[lista.size()][3];

        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = String.format("%.2f", e.calcularNomina());
        }
        return datos;
    }

    public String convertirTexto() {
        StringBuilder sb = new StringBuilder();

        for (Empleado e : lista) {
            sb.append("Nombre = ").append(e.getNombre()).append("\n");
            sb.append("Apellidos = ").append(e.getApellidos()).append("\n");
            sb.append("Cargo = ").append(e.getCargo()).append("\n");
            sb.append("Género = ").append(e.getGenero()).append("\n");
            sb.append("Salario = $").append(e.getSalarioDia()).append("\n");
            sb.append("Días trabajados = ").append(e.getDiasTrabajados()).append("\n");
            sb.append("Otros ingresos = ").append(e.getOtrosIngresos()).append("\n");
            sb.append("Pagos salud = ").append(e.getPagosSalud()).append("\n");
            sb.append("Aportes pensiones = ").append(e.getAportePensiones()).append("\n");
            sb.append("----------\n");
        }

        sb.append("Total nómina = $").append(String.format("%.2f", calcularTotalNomina()));

        return sb.toString();
    }
}
