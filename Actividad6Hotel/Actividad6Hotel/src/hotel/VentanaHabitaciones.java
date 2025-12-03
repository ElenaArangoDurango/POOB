package hotel;

import javax.swing.*;
import java.awt.*;

public class VentanaHabitaciones extends JFrame {

    private Hotel hotel;
    private JLabel[] labels;
    private JSpinner spinner;

    public VentanaHabitaciones(Hotel hotel) {
        this.hotel = hotel;

        setTitle("Habitaciones");
        setSize(600, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(crearPanelHabitaciones(), BorderLayout.CENTER);
        add(crearPanelSeleccion(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelHabitaciones() {
        JPanel p = new JPanel(new GridLayout(2, 5));

        labels = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            Habitacion h = hotel.getHabitacion(i + 1);
            labels[i] = new JLabel("Habitacion " + h.getNumero() +
                    "  " + (h.isDisponible() ? "Disponible" : "No disponible"));
            p.add(labels[i]);
        }

        return p;
    }

    private JPanel crearPanelSeleccion() {
        JPanel p = new JPanel();

        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JButton b = new JButton("Aceptar");
        b.addActionListener(e -> seleccionar());

        p.add(new JLabel("Habitacion a reservar:"));
        p.add(spinner);
        p.add(b);

        return p;
    }

    private void seleccionar() {
        int numero = (Integer) spinner.getValue();
        Habitacion h = hotel.getHabitacion(numero);

        if (!h.isDisponible()) {
            JOptionPane.showMessageDialog(this, "La habitacion esta ocupada");
            return;
        }

        new VentanaIngreso(h, this).setVisible(true);
    }

    public void actualizar() {
        for (int i = 0; i < 10; i++) {
            Habitacion h = hotel.getHabitacion(i + 1);
            labels[i].setText("Habitacion " + h.getNumero() +
                    "  " + (h.isDisponible() ? "Disponible" : "No disponible"));
        }
    }
}
