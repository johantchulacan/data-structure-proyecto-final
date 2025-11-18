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

    // Mostrar todas las cuentas (ordenadas por saldo usando Bubble Sort)
    public void showAllAccountsSorted() {
        ArrayList<Account> sortedList = new ArrayList<>(accounts);
        bubbleSortByBalance(sortedList);
        System.out.println("\n📋 Lista de cuentas ordenadas por saldo:");
        for (Account a : sortedList) {
            a.displayInfo();
        }
    }

    // Algoritmo Bubble Sort

    // Mostrar todas las cuentas (ordenadas por saldo 
    private void bubbleSortByBalance(ArrayList<Account> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getBalance() > list.get(j + 1).getBalance()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

// aroboles binaios
// diagrama de clases
    



    // Mostrar historial de transacciones
    public void showHistory() {
        System.out.println("\n📜 Historial de transacciones:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            for (String s : transactionHistory) {
                System.out.println(s);
            }
        }
    }
}
    
