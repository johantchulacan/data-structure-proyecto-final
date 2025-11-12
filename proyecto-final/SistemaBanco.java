// Clase principal del sistema bancario
public class SistemaBanco {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Stack<String> transactionHistory = new Stack<>();

    // Crear nueva cuenta
    public void createAccount(int CuentaNumber, String name, double initialDeposit) {
        if (findAccount(cuentaNumber) != null) {
            System.out.println(" Ya existe una cuenta con ese número.");
            return;
        }
        accounts.add(new Account(cuentaNumber, name, initialDeposit));
        transactionHistory.push("Cuenta creada: #" + cuentaNumber);
        System.out.println(" Cuenta creada exitosamente.");

    }


    // Buscar cuenta por número (búsqueda lineal o binaria si está ordenado)
    public Account findAccount(int number) {
        for (Account acc : accounts) {
            if (acc.getCuentaNumber() == number)
                return acc;
        }
        return null;
    }


    // Depósito
    public void deposit(int number, double amount) {
        Account acc = findAccount(number);
        if (acc != null) {
            acc.deposit(amount);
            transactionHistory.push("Depósito en #" + number + " de $" + amount);
            System.out.println(" Depósito exitoso.");
        } else System.out.println(" Cuenta no encontrada.");
    }


    // Retiro
    public void retirar(int number, double amount) {
        Account acc = findAccount(number);
        if (acc != null) {
            if (acc.retirar(amount)) {
                transactionHistory.push("Retiro en #" + number + " de $" + amount);
                System.out.println(" Retiro exitoso.");
            } else 
                System.out.println(" Saldo insuficiente.");
        } else 
            System.out.println(" Cuenta no encontrada.");
    }

    // Transferencia
    public void transfer(int from, int to, double amount) {
        Account acc1 = findAccount(from);
        Account acc2 = findAccount(to);
        if (acc1 != null && acc2 != null) {
            if (acc1.retirar(amount)) {
                acc2.deposit(amount);
                transactionHistory.push("Transferencia de #" + from + " a #" + to + " por $" + amount);
                System.out.println(" Transferencia completada.");
            } else 
                System.out.println(" Fondos insuficientes.");
        } else 
            System.out.println(" Una o ambas cuentas no existen.");
    }

    
