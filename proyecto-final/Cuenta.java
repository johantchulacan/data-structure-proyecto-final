// Clase que representa una cuenta bancaria
public class Cuenta {
    private int cuentaNumber;
    private String titularName;
    private double balance;

    public Cuenta(int cuentaNumber, String titularName, double balance) {
        this.cuentaNumber = cuentaNumber;
        this.titularName = titularName;
        this.balance = balance;

    }

    public int getCuentaNumber() { return cuentaNumber; }
    public String gettitularName() { return titularName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean retirar(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.printf("Cuenta #%d | Titular: %s | Saldo: %.2f%n", cuentaNumber, titularName, balance);
    }
}