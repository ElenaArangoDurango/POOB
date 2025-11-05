import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JTextField txtNum, txtDen, txtRes, txtTexto;
    private JLabel lblMsgError, lblMsgTexto;
    private JButton btnCalc, btnLimpiar;

    public VentanaPrincipal() {
        setTitle("División");
        setSize(320, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Campos y etiquetas
        add(new JLabel("Numerador:")).setBounds(20, 20, 100, 25);
        txtNum = new JTextField();
        txtNum.setBounds(130, 20, 130, 25);
        add(txtNum);

        add(new JLabel("Denominador:")).setBounds(20, 55, 100, 25);
        txtDen = new JTextField();
        txtDen.setBounds(130, 55, 130, 25);
        add(txtDen);

        add(new JLabel("Resultado:")).setBounds(20, 90, 100, 25);
        txtRes = new JTextField();
        txtRes.setBounds(130, 90, 130, 25);
        txtRes.setEditable(false);
        add(txtRes);

        add(new JLabel("Texto:")).setBounds(20, 125, 100, 25);
        txtTexto = new JTextField();
        txtTexto.setBounds(130, 125, 130, 25);
        add(txtTexto);

        // Botones
        btnCalc = new JButton("Calcular");
        btnCalc.setBounds(50, 160, 90, 25);
        btnCalc.addActionListener(this);
        add(btnCalc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(160, 160, 90, 25);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        // Mensajes
        lblMsgError = new JLabel();
        lblMsgError.setBounds(30, 190, 250, 25);
        lblMsgError.setForeground(Color.RED);
        add(lblMsgError);

        lblMsgTexto = new JLabel();
        lblMsgTexto.setBounds(30, 210, 250, 25);
        lblMsgTexto.setForeground(new Color(0, 128, 0)); // verde
        add(lblMsgTexto);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalc) {
            lblMsgError.setText("");
            lblMsgTexto.setText("");
            txtRes.setText("");

            try {
                double num = Double.parseDouble(txtNum.getText());
                double den = Double.parseDouble(txtDen.getText());
                String texto = txtTexto.getText().trim();

                // 1️⃣ Validar denominador
                if (den <= 0) {
                    lblMsgError.setText("Denominador debe ser mayor a 0");
                    return;
                }

                // 2️⃣ Calcular división
                double res = Validacion.calcularDivision(num, den);
                txtRes.setText(String.valueOf(res));

                // 3️⃣ Validar texto (no bloquea cálculo)
                if (texto.isEmpty()) {
                    lblMsgTexto.setText("Texto vacío");
                } else {
                    lblMsgTexto.setText("Texto: " + Validacion.ObtenerTexto(texto));
                }

                // Ejecutar bloques try del ejercicio base
                ManejoExcepciones.ejecutarBloques();

            } catch (NumberFormatException ex) {
                lblMsgError.setText("Ingresa solo números válidos");
            }
        }

        if (e.getSource() == btnLimpiar) {
            txtNum.setText("");
            txtDen.setText("");
            txtRes.setText("");
            txtTexto.setText("");
            lblMsgError.setText("");
            lblMsgTexto.setText("");
        }
    }
}
