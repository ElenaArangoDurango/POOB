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

    // ✅ Evita el constructor deprecado:
    // private final Locale ES = new Locale("es", "CO");
    private static final Locale ES = Locale.forLanguageTag("es-CO"); // o Locale.of("es","CO") en Java 19+

    public VentanaPrincipal() {
        setTitle("Notas");
        setSize(300, 350);                 // ✅ sin nombres de parámetro
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);               // ✅ sin nombres de parámetro
        initUI();
    }

    private void initUI() {
        cont = getContentPane();
        cont.setLayout(null);              // ✅ null directo

        // ✅ Constructores correctos
        nota1 = new JLabel("Nota 1:");
        nota2 = new JLabel("Nota 2:");
        nota3 = new JLabel("Nota 3:");
        nota4 = new JLabel("Nota 4:");
        nota5 = new JLabel("Nota 5:");

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
    
    // ... (resto igual: actionPerformed, calcular(), limpiar())
}
