package hotel;

import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuItem itemConsultar, itemSalida;
    private Hotel hotel;

    public VentanaPrincipal() {
        hotel = new Hotel();

        setTitle("Hotel");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        crearMenu();
    }

    private void crearMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        itemConsultar = new JMenuItem("Consultar habitaciones");
        itemSalida = new JMenuItem("Salida de huespedes");

        itemConsultar.addActionListener(this);
        itemSalida.addActionListener(this);

        menu.add(itemConsultar);
        menu.add(itemSalida);
        barra.add(menu);

        setJMenuBar(barra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemConsultar) {
            new VentanaHabitaciones(hotel).setVisible(true);
        }
        if (e.getSource() == itemSalida) {
            new VentanaSalida(hotel).setVisible(true);
        }
    }
}
