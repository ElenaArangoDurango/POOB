package ventanacontacto;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class VentanaContacto extends JFrame {

    // Campos
    private JTextField tNombres, tApellidos, tDireccion, tTelefono, tCorreo;
    private JSpinner fechaSpinner;
    private JList<String> listaVisual;
    private DefaultListModel<String> modeloLista;

    private ListaContactos lista;

    public VentanaContacto() {
        lista = new ListaContactos();
        construirVentana();
    }

    private void construirVentana() {

        setTitle("Agenda de Contactos");
        setSize(600, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255)); // Azul suave
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Fecha con SpinnerDateModel
        SpinnerDateModel dateModel = new SpinnerDateModel();
        fechaSpinner = new JSpinner(dateModel);
        fechaSpinner.setEditor(new JSpinner.DateEditor(fechaSpinner, "yyyy-MM-dd"));

        // Campos
        tNombres = new JTextField();
        tApellidos = new JTextField();
        tDireccion = new JTextField();
        tTelefono = new JTextField();
        tCorreo = new JTextField();

        // Lista
        modeloLista = new DefaultListModel<>();
        listaVisual = new JList<>(modeloLista);
        listaVisual.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Botón agregar
        JButton agregar = new JButton("Agregar");
        agregar.setBackground(new Color(102, 153, 255));
        agregar.setForeground(Color.WHITE);
        agregar.setFocusPainted(false);

        agregar.addActionListener(e -> agregarContacto());

        // --- Colocar componentes ---

        addCelda(panel, new JLabel("Nombres:"), 0, 0, c);
        addCelda(panel, tNombres, 1, 0, c);

        addCelda(panel, new JLabel("Apellidos:"), 0, 1, c);
        addCelda(panel, tApellidos, 1, 1, c);

        addCelda(panel, new JLabel("Fecha nacimiento:"), 0, 2, c);
        addCelda(panel, fechaSpinner, 1, 2, c);

        addCelda(panel, new JLabel("Dirección:"), 0, 3, c);
        addCelda(panel, tDireccion, 1, 3, c);

        addCelda(panel, new JLabel("Teléfono:"), 0, 4, c);
        addCelda(panel, tTelefono, 1, 4, c);

        addCelda(panel, new JLabel("Correo:"), 0, 5, c);
        addCelda(panel, tCorreo, 1, 5, c);

        // Botón
        c.gridwidth = 2;
        addCelda(panel, agregar, 0, 6, c);

        // Lista a la derecha
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 7;
        c.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(listaVisual), c);

        add(panel);
    }

    private void addCelda(JPanel p, Component comp, int x, int y, GridBagConstraints c) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        p.add(comp, c);
    }

    private void agregarContacto() {

        String a = tNombres.getText().trim();
        String b = tApellidos.getText().trim();
        String d = tDireccion.getText().trim();
        String e = tTelefono.getText().trim();
        String f = tCorreo.getText().trim();

        if (a.isEmpty() || b.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se permiten campos vacíos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date fecha = (Date) fechaSpinner.getValue();
        LocalDate fechaNac = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Contacto c = new Contacto(a, b, fechaNac, d, e, f);
        lista.agregarContacto(c);

        modeloLista.addElement(c.toString());

        tNombres.setText("");
        tApellidos.setText("");
        tDireccion.setText("");
        tTelefono.setText("");
        tCorreo.setText("");
    }

    public static void main(String[] args) {
        new VentanaContacto().setVisible(true);
    }
}
