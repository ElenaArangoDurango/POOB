package hotel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaSalida extends JFrame {

    private Hotel hotel;

    private JTextField tFechaSalida;
    private JLabel lInfo;
    private JLabel lDias;
    private JLabel lTotal;
    private Habitacion hab;

    public VentanaSalida(Hotel hotel) {
        this.hotel = hotel;

        int numero = pedirNumero();

        if (numero == -1) {
            dispose();
            return;
        }

        hab = hotel.getHabitacion(numero);

        if (hab == null || hab.isDisponible()) {
            JOptionPane.showMessageDialog(this, "Habitacion invalida o no ocupada");
            dispose();
            return;
        }

        construirVentana();
    }

    private int pedirNumero() {
        try {
            String s = JOptionPane.showInputDialog(this, "Ingrese numero de habitacion");
            if (s == null) return -1;
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }

    private void construirVentana() {
        setTitle("Salida huesped");
        setSize(350, 280);
        setLocationRelativeTo(null);
        setLayout(null);

        lInfo = new JLabel("Habitacion: " + hab.getNumero()
                + " - Ingreso: " + hab.getFechaIngreso());
        lInfo.setBounds(20, 20, 300, 25);
        add(lInfo);

        JLabel l1 = new JLabel("Fecha de salida (aaaa-mm-dd):");
        l1.setBounds(20, 60, 300, 25);
        add(l1);

        tFechaSalida = new JTextField();
        tFechaSalida.setBounds(20, 85, 150, 25);
        add(tFechaSalida);

        JButton bCalcular = new JButton("Calcular");
        bCalcular.setBounds(200, 85, 100, 25);
        add(bCalcular);

        lDias = new JLabel("Dias: ");
        lDias.setBounds(20, 130, 300, 25);
        add(lDias);

        lTotal = new JLabel("Total: ");
        lTotal.setBounds(20, 160, 300, 25);
        add(lTotal);

        JButton bRegistrar = new JButton("RegistrarSalida");
        bRegistrar.setEnabled(false);
        bRegistrar.setBounds(100, 200, 150, 30);
        add(bRegistrar);

        bCalcular.addActionListener(e -> calcular(bRegistrar));
        bRegistrar.addActionListener(e -> registrarSalida());
    }

    private void calcular(JButton bRegistrar) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date fIngreso = sdf.parse(hab.getFechaIngreso());
            Date fSalida = sdf.parse(tFechaSalida.getText());

            if (fSalida.compareTo(fIngreso) <= 0) {
                JOptionPane.showMessageDialog(this, "Fecha de salida invalida");
                return;
            }

            long dif = fSalida.getTime() - fIngreso.getTime();
            int dias = (int) (dif / (1000 * 60 * 60 * 24));

            double total = dias * hab.getPrecio();

            lDias.setText("Dias: " + dias);
            lTotal.setText("Total: $" + total);

            bRegistrar.setEnabled(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en fecha");
        }
    }

    private void registrarSalida() {
        hab.liberar();
        JOptionPane.showMessageDialog(this, "Salida registrada");
        dispose();
    }
}
