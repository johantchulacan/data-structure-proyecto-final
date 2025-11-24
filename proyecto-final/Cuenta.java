// Clase que representa una cuenta bancaria
public class Cuenta {
    private int cuentaNumber; // identificador único
    private String titularName; // nombre del titular
    private double balance; // saldo actual

    public Cuenta(int cuentaNumber, String titularName, double balance) {
        this.cuentaNumber = cuentaNumber;
        this.titularName = titularName;
        this.balance = balance;

    }

    // Gets normales
    public int getCuentaNumber() {
        return cuentaNumber;
    }

    public String getTitularName() {
        return titularName;
    }

    public double getBalance() {
        return balance;
    }

    // Depositar dinero
    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    // Retirar si hay saldo
    public boolean retirar(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Mostrar información de la cuenta
    public void displayInfo() {
        System.out.printf("Cuenta #%d | Titular: %s | Saldo: %.2f%n", cuentaNumber, titularName, balance);
    }
}