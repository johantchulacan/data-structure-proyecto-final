
// Clase principal del sistema bancario
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SistemaBanco {

    // Lista principal de cuentas (almacenamiento general)
    private ArrayList<Cuenta> accounts = new ArrayList<>();

    // Pila para guardar el historial (LIFO)
    private Stack<String> transactionHistory = new Stack<>();

    // Árbol para hacer búsquedas rápidas y ordenar por número
    private BinarySearchTree bst = new BinarySearchTree();

    // Crear nueva cuenta
    public void createAccount(int cuentaNumber, String name, double initialDeposit) {

        // primero verifico si ya existe usando el árbol
        if (bst.search(cuentaNumber) != null) {
            System.out.println(" Ya existe una cuenta con ese número.");
            return;
        }

        // creo la nueva cuenta
        Cuenta acc = new Cuenta(cuentaNumber, name, initialDeposit);

        // la guardo en las estructuras principales
        accounts.add(acc); // Lista principal
        bst.insert(acc); // Insertar en el árbol BST

        // registro en el historial
        transactionHistory.push("Cuenta creada: #" + cuentaNumber);
        System.out.println(" Cuenta creada exitosamente.");

    }

    // Buscar cuenta por número (búsqueda binaria si está ordenado)
    public Cuenta findAccount(int number) {
        return bst.search(number);
    }

    // Depósito
    public void deposit(int number, double amount) {
        Cuenta acc = findAccount(number);
        if (acc != null) {
            acc.deposit(amount);
            transactionHistory.push("Depósito en #" + number + " de $" + amount);
            System.out.println(" Depósito exitoso.");
        } else
            System.out.println(" Cuenta no encontrada.");
    }

    // Retiro
    public void retirar(int number, double amount) {
        Cuenta acc = findAccount(number);
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
        Cuenta acc1 = findAccount(from);
        Cuenta acc2 = findAccount(to);

        // verifico que ambas existan
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

        // copio la lista para no alterar el orden original
        ArrayList<Cuenta> sortedList = new ArrayList<>(accounts);
        bubbleSortByBalance(sortedList);
        System.out.println("\n Lista de cuentas ordenadas por saldo:");
        for (Cuenta a : sortedList) {
            a.displayInfo();
        }
    }

    // Implementación de algoritmo bubble sort
    private void bubbleSortByBalance(ArrayList<Cuenta> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                // comparo dos saldos
                if (list.get(j).getBalance() > list.get(j + 1).getBalance()) {
                    // si están invertidos, los intercambio
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    // Mostrar historial de transacciones
    public void showHistory() {
        System.out.println("\n Historial de transacciones:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            for (String s : transactionHistory) {
                System.out.println(s);
            }
        }
    }

    // Mostrar recorrido INORDER del árbol (cuentas ordenadas por número)
    public void showTreeInOrder() {
        System.out.println("\n Recorrido IN-ORDER del Árbol BST:");
        bst.inorder();
    }
}
