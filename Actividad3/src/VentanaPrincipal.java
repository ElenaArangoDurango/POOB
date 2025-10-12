import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container cont;
    private JLabel nota1, nota2, nota3, nota4, nota5;
    private JLabel promedioLbl, desviacionLbl, mayorLbl, menorLbl;
    private JTextField campo1, campo2, campo3, campo4, campo5;
    private JButton calcularBtn, limpiarBtn;

    private static final Locale ES = Locale.forLanguageTag("es-CO");

    public VentanaPrincipal() {
        setTitle("Notas");
        setSize(300, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initUI();
    }

    private void initUI() {
        cont = getContentPane();
        cont.setLayout(null);

        // Etiquetas
        nota1 = new JLabel("Nota 1:"); nota2 = new JLabel("Nota 2:");
        nota3 = new JLabel("Nota 3:"); nota4 = new JLabel("Nota 4:");
        nota5 = new JLabel("Nota 5:");

        // Campos alineados a la derecha
        campo1 = new JTextField(); campo1.setHorizontalAlignment(JTextField.RIGHT);
        campo2 = new JTextField(); campo2.setHorizontalAlignment(JTextField.RIGHT);
        campo3 = new JTextField(); campo3.setHorizontalAlignment(JTextField.RIGHT);
        campo4 = new JTextField(); campo4.setHorizontalAlignment(JTextField.RIGHT);
        campo5 = new JTextField(); campo5.setHorizontalAlignment(JTextField.RIGHT);

        int xL = 20, xF = 105, wL = 70, wF = 150, h = 23, y = 20, dy = 30;
        nota1.setBounds(xL, y, wL, h);        campo1.setBounds(xF, y, wF, h);        y += dy;
        nota2.setBounds(xL, y, wL, h);        campo2.setBounds(xF, y, wF, h);        y += dy;
        nota3.setBounds(xL, y, wL, h);        campo3.setBounds(xF, y, wF, h);        y += dy;
        nota4.setBounds(xL, y, wL, h);        campo4.setBounds(xF, y, wF, h);        y += dy;
        nota5.setBounds(xL, y, wL, h);        campo5.setBounds(xF, y, wF, h);        y += dy;

        calcularBtn = new JButton("Calcular");
        limpiarBtn  = new JButton("Limpiar");
        calcularBtn.setBounds(40, y, 100, h);
        limpiarBtn.setBounds(150, y, 100, h);

        // 🔴 MUY IMPORTANTE: registrar listeners
        calcularBtn.addActionListener(this);
        limpiarBtn.addActionListener(this);
        y += 40;

        promedioLbl   = new JLabel("Promedio = ");
        desviacionLbl = new JLabel("Desviación estándar = ");
        mayorLbl      = new JLabel("Valor mayor = ");
        menorLbl      = new JLabel("Valor menor = ");

        promedioLbl.setBounds(xL, y, 240, h); y += dy;
        desviacionLbl.setBounds(xL, y, 240, h); y += dy;
        mayorLbl.setBounds(xL, y, 240, h); y += dy;
        menorLbl.setBounds(xL, y, 240, h);

        cont.add(nota1); cont.add(campo1);
        cont.add(nota2); cont.add(campo2);
        cont.add(nota3); cont.add(campo3);
        cont.add(nota4); cont.add(campo4);
        cont.add(nota5); cont.add(campo5);
        cont.add(calcularBtn); cont.add(limpiarBtn);
        cont.add(promedioLbl); cont.add(desviacionLbl);
        cont.add(mayorLbl); cont.add(menorLbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularBtn) calcular();
        if (e.getSource() == limpiarBtn)  limpiar();
    }

    private void calcular() {
        try {
            Notas n = new Notas();
            // aquí usamos punto decimal (4.3). Si quieres aceptar coma, te doy otra versión.
            n.listaNotas[0] = Double.parseDouble(campo1.getText().trim());
            n.listaNotas[1] = Double.parseDouble(campo2.getText().trim());
            n.listaNotas[2] = Double.parseDouble(campo3.getText().trim());
            n.listaNotas[3] = Double.parseDouble(campo4.getText().trim());
            n.listaNotas[4] = Double.parseDouble(campo5.getText().trim());

            double prom = n.calcularPromedio();
            double desv = n.calcularDesviacion();

            promedioLbl.setText("Promedio = " + String.format(ES, "%.2f", prom));
            desviacionLbl.setText("Desviación estándar = " + String.format(ES, "%.2f", desv));
            mayorLbl.setText("Valor mayor = " + String.format(ES, "%.1f", n.calcularMayor()));
            menorLbl.setText("Valor menor = " + String.format(ES, "%.1f", n.calcularMenor()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Ingresa 5 números válidos (usa punto decimal, ej: 4.3).",
                "Entrada inválida",
                JOptionPane.WARNING_MESSAGE);
        }
    }

    private void limpiar() {
        campo1.setText(""); campo2.setText(""); campo3.setText("");
        campo4.setText(""); campo5.setText("");
        promedioLbl.setText("Promedio = ");
        desviacionLbl.setText("Desviación estándar = ");
        mayorLbl.setText("Valor mayor = ");
        menorLbl.setText("Valor menor = ");
    }
}
