import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel baseLbl, alturaLbl, apotemaLbl, volumenLbl, superficieLbl;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcularBtn;

    private static final Locale ES = Locale.forLanguageTag("es-CO");

    public VentanaPiramide() {
        initUI();
        setTitle("Pirámide");
        setSize(300, 245);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        baseLbl = new JLabel("Base (cm):");
        baseLbl.setBounds(20, 20, 120, 23);
        campoBase = new JTextField();
        campoBase.setHorizontalAlignment(JTextField.RIGHT);
        campoBase.setBounds(140, 20, 130, 23);

        alturaLbl = new JLabel("Altura (cm):");
        alturaLbl.setBounds(20, 50, 120, 23);
        campoAltura = new JTextField();
        campoAltura.setHorizontalAlignment(JTextField.RIGHT);
        campoAltura.setBounds(140, 50, 130, 23);

        apotemaLbl = new JLabel("Apotema (cm):");
        apotemaLbl.setBounds(20, 80, 120, 23);
        campoApotema = new JTextField();
        campoApotema.setHorizontalAlignment(JTextField.RIGHT);
        campoApotema.setBounds(140, 80, 130, 23);

        calcularBtn = new JButton("Calcular");
        calcularBtn.setBounds(140, 110, 130, 23);
        calcularBtn.addActionListener(this);

        volumenLbl = new JLabel("Volumen (cm³):");
        volumenLbl.setBounds(20, 140, 240, 23);

        superficieLbl = new JLabel("Superficie (cm²):");
        superficieLbl.setBounds(20, 170, 240, 23);

        contenedor.add(baseLbl);      contenedor.add(campoBase);
        contenedor.add(alturaLbl);    contenedor.add(campoAltura);
        contenedor.add(apotemaLbl);   contenedor.add(campoApotema);
        contenedor.add(calcularBtn);
        contenedor.add(volumenLbl);   contenedor.add(superficieLbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double b  = Double.parseDouble(campoBase.getText().trim());
            double h  = Double.parseDouble(campoAltura.getText().trim());
            double ap = Double.parseDouble(campoApotema.getText().trim());

            Piramide p = new Piramide(b, h, ap);

            volumenLbl.setText("Volumen (cm³): " + String.format(ES, "%.2f", p.getVolumen()));
            superficieLbl.setText("Superficie (cm²): " + String.format(ES, "%.2f", p.getSuperficie()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Campo nulo o número inválido.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

