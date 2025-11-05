package Ejercicio412;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal412 extends JFrame {
    private JTextField txtNumero, txtRaiz, txtLog;
    private JButton btnCalcular, btnLimpiar;

    public VentanaPrincipal412() {
        setTitle("Cálculos Numéricos");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Ingrese un número:");
        txtNumero = new JTextField();

        JLabel lblRaiz = new JLabel("Raíz cuadrada:");
        txtRaiz = new JTextField();
        txtRaiz.setEditable(false);

        JLabel lblLog = new JLabel("Logaritmo neperiano:");
        txtLog = new JTextField();
        txtLog.setEditable(false);

        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(txtNumero.getText());

                    // Validación de número negativo o cero
                    if (valor <= 0) {
                        JOptionPane.showMessageDialog(
                            null,
                            "El valor debe ser un número positivo para calcular la raíz cuadrada y el logaritmo.",
                            "Error de valor",
                            JOptionPane.ERROR_MESSAGE
                        );
                        txtRaiz.setText("");
                        txtLog.setText("");
                        return;
                    }

                    // Si es positivo, calcula normalmente
                    double raiz = CalculosNumericos.calcularRaizCuadrada(valor);
                    double log = CalculosNumericos.calcularLogaritmoNeperiano(valor);

                    txtRaiz.setText(String.valueOf(raiz));
                    txtLog.setText(String.valueOf(log));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar un número válido.",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText("");
                txtRaiz.setText("");
                txtLog.setText("");
            }
        });

        add(lblNumero); add(txtNumero);
        add(lblRaiz); add(txtRaiz);
        add(lblLog); add(txtLog);
        add(btnCalcular); add(btnLimpiar);
    }
}
