import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLbl, alturaLbl, volumenLbl, superficieLbl;
    private JTextField campoRadio, campoAltura;
    private JButton calcularBtn;

    private static final Locale ES = Locale.forLanguageTag("es-CO");

    public VentanaCilindro() {
        initUI();
        setTitle("Cilindro");
        setSize(300, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radioLbl = new JLabel("Radio (cm):");
        radioLbl.setBounds(20, 20, 120, 23);
        campoRadio = new JTextField();
        campoRadio.setHorizontalAlignment(JTextField.RIGHT);
        campoRadio.setBounds(140, 20, 130, 23);

        alturaLbl = new JLabel("Altura (cm):");
        alturaLbl.setBounds(20, 50, 120, 23);
        campoAltura = new JTextField();
        campoAltura.setHorizontalAlignment(JTextField.RIGHT);
        campoAltura.setBounds(140, 50, 130, 23);

        calcularBtn = new JButton("Calcular");
        calcularBtn.setBounds(140, 80, 130, 23);
        calcularBtn.addActionListener(this);

        volumenLbl = new JLabel("Volumen (cm³):");
        volumenLbl.setBounds(20, 110, 240, 23);

        superficieLbl = new JLabel("Superficie (cm²):");
        superficieLbl.setBounds(20, 140, 240, 23);

        contenedor.add(radioLbl);      contenedor.add(campoRadio);
        contenedor.add(alturaLbl);     contenedor.add(campoAltura);
        contenedor.add(calcularBtn);
        contenedor.add(volumenLbl);    contenedor.add(superficieLbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double r = Double.parseDouble(campoRadio.getText().trim());
            double h = Double.parseDouble(campoAltura.getText().trim());

            Cilindro c = new Cilindro(r, h);

            volumenLbl.setText("Volumen (cm³): " + String.format(ES, "%.2f", c.getVolumen()));
            superficieLbl.setText("Superficie (cm²): " + String.format(ES, "%.2f", c.getSuperficie()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Campo nulo o número inválido.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
