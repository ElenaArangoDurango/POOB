import javax.swing.UIManager;

public class ejercicioN28 {
    public static void main(String[] args) {
        // Look & Feel del sistema para que se vea como en Windows
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}

        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}