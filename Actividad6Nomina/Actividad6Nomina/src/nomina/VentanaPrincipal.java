package nomina;

import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private ListaEmpleados empleados;
    private JMenuItem itemAgregar, itemNomina, itemGuardar;

    public VentanaPrincipal() {
        empleados = new ListaEmpleados();

        setTitle("Nómina");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        crearMenu();
    }

    private void crearMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        itemAgregar = new JMenuItem("Agregar empleado");
        itemNomina = new JMenuItem("Calcular nómina");
        itemGuardar = new JMenuItem("Guardar archivo");

        itemAgregar.addActionListener(this);
        itemNomina.addActionListener(this);
        itemGuardar.addActionListener(this);

        menu.add(itemAgregar);
        menu.add(itemNomina);
        menu.addSeparator();
        menu.add(itemGuardar);

        barra.add(menu);
        setJMenuBar(barra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemAgregar) {
            new VentanaAgregarEmpleado(empleados).setVisible(true);
        }
        if (e.getSource() == itemNomina) {
            new VentanaNomina(empleados).setVisible(true);
        }
        if (e.getSource() == itemGuardar) {
            guardarArchivo();
        }
    }

    private void guardarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                var carpeta = fc.getSelectedFile();
                var archivo = new java.io.File(carpeta, "nomina.txt");
                java.nio.file.Files.writeString(archivo.toPath(), empleados.convertirTexto());
                JOptionPane.showMessageDialog(this, "Archivo guardado correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo.");
            }
        }
    }
}
