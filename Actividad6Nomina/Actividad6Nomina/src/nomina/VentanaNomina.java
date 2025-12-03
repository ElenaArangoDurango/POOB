package nomina;

import javax.swing.*;
import java.awt.*;

public class VentanaNomina extends JFrame {

    public VentanaNomina(ListaEmpleados lista) {

        setTitle("Nómina");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[][] datos = lista.obtenerMatriz();
        String[] titulos = {"Nombre", "Apellidos", "Sueldo"};

        JTable tabla = new JTable(datos, titulos);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JLabel total = new JLabel("Total nómina: $" +
                String.format("%.2f", lista.calcularTotalNomina()));

        add(total, BorderLayout.SOUTH);
    }
}
