package ejercicios.ejercicio2_5;

// Clase en PascalCase y archivo con el mismo nombre: CuentaBancaria.java
public class CuentaBancaria {

      // Tipo de cuenta: restringe el número de cuenta a dos valores válidos: AHORROS o CORRIENTE
    public enum Tipo { AHORROS, CORRIENTE }

//atributos, tipo y nombre (Estado del objeto)
    private String nombresTitular;
    private String apellidosTitular;
    private int numeroCuenta;
    private Tipo tipoCuenta;
    private int saldo = 0; 
      // constructor, inicializa los atributos obligatorios
      // this. = atributo del objeto
    public CuentaBancaria(String nombresTitular, String apellidosTitular, int numeroCuenta, Tipo tipoCuenta) {
        this.nombresTitular = nombresTitular;  
        this.apellidosTitular = apellidosTitular;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }

      // Imprimir datos de la cuenta //
    public void imprimir() {
        System.out.println("Nombres del titular = " + nombresTitular);
        System.out.println("Apellidos del titular = " + apellidosTitular);
        System.out.println("Número de cuenta = " + numeroCuenta);
        System.out.println("Tipo de cuenta = " + tipoCuenta);
        System.out.println("Saldo = $" + saldo);
    }

    /** Consulta de saldo */
    public void consultarSaldo() {
        System.out.println("El saldo actual es = $" + saldo);
    }

    /** Consignar dinero (>0) */
    public boolean consignar(int valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Se ha consignado $" + valor +" en la cuenta. El nuevo saldo es $" + saldo);
            return true;
        } else {
            System.out.println("El valor a consignar debe ser mayor que cero.");
            return false;
        }
    }

    /** Retirar dinero (>0 y <= saldo) */
    public boolean retirar(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Se ha retirado $" + valor +
                               " en la cuenta. El nuevo saldo es $" + saldo);
            return true;
        } else {
            System.out.println("El valor a retirar debe ser mayor que cero y no superar el saldo actual.");
            return false;
        }
    }

    
    }


