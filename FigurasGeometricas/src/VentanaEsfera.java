import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radioLbl, volumenLbl, superficieLbl;
    private JTextField campoRadio;
    private JButton calcularBtn;

    private static final Locale ES = Locale.forLanguageTag("es-CO");

    public VentanaEsfera() {
        initUI();
        setTitle("Esfera");
        setSize(300, 200);
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

        calcularBtn = new JButton("Calcular");
        calcularBtn.setBounds(140, 50, 130, 23);
        calcularBtn.addActionListener(this);

        volumenLbl = new JLabel("Volumen (cm³):");
        volumenLbl.setBounds(20, 90, 240, 23);

        superficieLbl = new JLabel("Superficie (cm²):");
        superficieLbl.setBounds(20, 120, 240, 23);

        contenedor.add(radioLbl);     contenedor.add(campoRadio);
        contenedor.add(calcularBtn);
        contenedor.add(volumenLbl);   contenedor.add(superficieLbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double r = Double.parseDouble(campoRadio.getText().trim());

            Esfera esf = new Esfera(r);

            volumenLbl.setText("Volumen (cm³): " + String.format(ES, "%.2f", esf.getVolumen()));
            superficieLbl.setText("Superficie (cm²): " + String.format(ES, "%.2f", esf.getSuperficie()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Campo nulo o número inválido.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
