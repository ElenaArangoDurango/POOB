package nomina;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarEmpleado extends JFrame {

    private ListaEmpleados lista;

    private JTextField tNombre, tApellidos, tSalario, tOtros, tSalud, tPensiones;
    private JSpinner sDias;
    private JComboBox<String> cCargo;
    private JRadioButton rM, rF;

    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;

        setTitle("Agregar empleado");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(crearFormulario(), BorderLayout.CENTER);
        add(crearBotones(), BorderLayout.SOUTH);
    }

    private JPanel crearFormulario() {
        JPanel p = new JPanel(new GridLayout(10, 2, 5, 5));

        tNombre = new JTextField();
        tApellidos = new JTextField();
        tSalario = new JTextField();
        tOtros = new JTextField();
        tSalud = new JTextField();
        tPensiones = new JTextField();

        sDias = new JSpinner(new SpinnerNumberModel(30, 1, 31, 1));
        cCargo = new JComboBox<>(new String[]{"Directivo", "Estratégico", "Operativo"});

        rM = new JRadioButton("Masculino", true);
        rF = new JRadioButton("Femenino");
        ButtonGroup g = new ButtonGroup();
        g.add(rM); g.add(rF);

        p.add(new JLabel("Nombre:"));
        p.add(tNombre);
        p.add(new JLabel("Apellidos:"));
        p.add(tApellidos);
        p.add(new JLabel("Cargo:"));
        p.add(cCargo);
        p.add(new JLabel("Género:"));
        JPanel pg = new JPanel(); pg.add(rM); pg.add(rF);
        p.add(pg);
        p.add(new JLabel("Salario por día:"));
        p.add(tSalario);
        p.add(new JLabel("Días trabajados:"));
        p.add(sDias);
        p.add(new JLabel("Otros ingresos:"));
        p.add(tOtros);
        p.add(new JLabel("Pagos salud:"));
        p.add(tSalud);
        p.add(new JLabel("Aportes pensiones:"));
        p.add(tPensiones);

        return p;
    }

    private JPanel crearBotones() {
        JPanel p = new JPanel();
        JButton bAgregar = new JButton("Agregar");
        JButton bLimpiar = new JButton("Limpiar");

        bAgregar.addActionListener(e -> agregarEmpleado());
        bLimpiar.addActionListener(e -> limpiar());

        p.add(bAgregar);
        p.add(bLimpiar);

        return p;
    }

    private void limpiar() {
        tNombre.setText("");
        tApellidos.setText("");
        tSalario.setText("");
        sDias.setValue(30);
        tOtros.setText("");
        tSalud.setText("");
        tPensiones.setText("");
    }

    private void agregarEmpleado() {
        try {
            TipoCargo cargo = switch (cCargo.getSelectedIndex()) {
                case 0 -> TipoCargo.DIRECTIVO;
                case 1 -> TipoCargo.ESTRATEGICO;
                default -> TipoCargo.OPERATIVO;
            };

            TipoGenero genero = rM.isSelected()
                    ? TipoGenero.MASCULINO
                    : TipoGenero.FEMENINO;

            Empleado e = new Empleado(
                tNombre.getText(),
                tApellidos.getText(),
                cargo,
                genero,
                Double.parseDouble(tSalario.getText()),
                (int) sDias.getValue(),
                Double.parseDouble(tOtros.getText()),
                Double.parseDouble(tSalud.getText()),
                Double.parseDouble(tPensiones.getText())
            );

            lista.agregarEmpleado(e);

            JOptionPane.showMessageDialog(this, "Empleado agregado.");
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: revise los campos.");
        }
    }
}
