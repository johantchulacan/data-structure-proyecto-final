
// Clase principal con menú usando if/else y se usa while
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaBanco bank = new SistemaBanco(); // mi sistema bancario
        int option = -1;

        while (option != 0) {

            // menú principal
            System.out.println("\n=== BANKING MANAGEMENT SYSTEM ===");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir");
            System.out.println("5. Mostrar todas las cuentas (ordenadas)");
            System.out.println("6. Ver historial de transacciones");
            System.out.println("7. Recorrido IN-ORDER del árbol (BST)");
            System.out.println("8. Buscar cuenta usando el Árbol Binario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();

            if (option == 1) {
                System.out.print("Número de cuenta: ");
                int num = sc.nextInt();
                sc.nextLine();
                System.out.print("Titular: ");
                String name = sc.nextLine();
                System.out.print("Depósito inicial: ");
                double dep = sc.nextDouble();
                bank.createAccount(num, name, dep);

            } else if (option == 2) {
                System.out.print("Cuenta: ");
                int num = sc.nextInt();
                System.out.print("Monto: ");
                double dep = sc.nextDouble();
                bank.deposit(num, dep);

            } else if (option == 3) {
                System.out.print("Cuenta: ");
                int num = sc.nextInt();
                System.out.print("Monto: ");
                double dep = sc.nextDouble();
                bank.retirar(num, dep);

            } else if (option == 4) {
                System.out.print("Cuenta origen: ");
                int from = sc.nextInt();
                System.out.print("Cuenta destino: ");
                int to = sc.nextInt();
                System.out.print("Monto: ");
                double amt = sc.nextDouble();
                bank.transfer(from, to, amt);

            } else if (option == 5) {
                bank.showAllAccountsSorted();

            } else if (option == 6) {
                bank.showHistory();

            }

            else if (option == 7) {
                bank.showTreeInOrder();

            } else if (option == 8) {
                System.out.print("Ingrese número de cuenta a buscar: ");
                int num = sc.nextInt();
                Cuenta acc = bank.findAccount(num);

                if (acc != null) {
                    System.out.println("\nCuenta encontrada:");
                    acc.displayInfo();
                } else {
                    System.out.println("No existe una cuenta con ese número.");
                }

            } else if (option == 0) {
                System.out.println(" Saliendo del sistema...");

            } else {
                System.out.println(" Opción inválida, intente de nuevo.");
            }
        }

        sc.close();
    }
}