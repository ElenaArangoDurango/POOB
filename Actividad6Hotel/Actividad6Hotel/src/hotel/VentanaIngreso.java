package hotel;

import javax.swing.*;
import java.awt.*;

public class VentanaIngreso extends JFrame {

    private Habitacion habitacion;
    private VentanaHabitaciones ventanaPadre;

    private JTextField tFecha, tNombre, tApellidos, tDoc;

    public VentanaIngreso(Habitacion habitacion, VentanaHabitaciones padre) {
        this.habitacion = habitacion;
        this.ventanaPadre = padre;

        setTitle("Ingreso");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Habitacion: " + habitacion.getNumero()));
        add(new JLabel(""));

        add(new JLabel("Fecha (aaaa-mm-dd):"));
        tFecha = new JTextField();
        add(tFecha);

        add(new JLabel("Nombre:"));
        tNombre = new JTextField();
        add(tNombre);

        add(new JLabel("Apellidos:"));
        tApellidos = new JTextField();
        add(tApellidos);

        add(new JLabel("Documento:"));
        tDoc = new JTextField();
        add(tDoc);

        JButton b1 = new JButton("Aceptar");
        JButton b2 = new JButton("Cancelar");

        b1.addActionListener(e -> registrar());
        b2.addActionListener(e -> dispose());

        add(b1);
        add(b2);
    }

    private void registrar() {
        if (tFecha.getText().isEmpty() || tNombre.getText().isEmpty()
                || tApellidos.getText().isEmpty() || tDoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        Huesped h = new Huesped(tNombre.getText(),
                tApellidos.getText(),
                tDoc.getText());

        habitacion.ocupar(tFecha.getText(), h);

        ventanaPadre.actualizar();

        JOptionPane.showMessageDialog(this, "El huesped ha sido registrado");
        dispose();
    }
}
