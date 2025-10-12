import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton btnCilindro, btnEsfera, btnPiramide;

    public VentanaPrincipal() {
        setTitle("Figuras geométricas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initUI();

        // tamaño y centrado
        setSize(360, 160);
        setLocationRelativeTo(null);
    }

    private void initUI() {
        contenedor = getContentPane();
        contenedor.setLayout(null); // absoluto para replicar el ejemplo del libro

        btnCilindro = new JButton("Cilindro");
        btnEsfera   = new JButton("Esfera");
        btnPiramide = new JButton("Pirámide");

        btnCilindro.setBounds(20, 50, 90, 25);
        btnEsfera.setBounds(130, 50, 90, 25);
        btnPiramide.setBounds(240, 50, 90, 25);

        btnCilindro.addActionListener(this);
        btnEsfera.addActionListener(this);
        btnPiramide.addActionListener(this);

        contenedor.add(btnCilindro);
        contenedor.add(btnEsfera);
        contenedor.add(btnPiramide);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnEsfera) {
            new VentanaEsfera().setVisible(true);
        } else if (src == btnCilindro) {
            new VentanaCilindro().setVisible(true);
        } else if (src == btnPiramide) {
            new VentanaPiramide().setVisible(true);
        }
    }
}
