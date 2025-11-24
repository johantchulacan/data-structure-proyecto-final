public class BinarySearchTree {

    private Node root; // raíz del árbol, aquí empieza todo

    // Clase interna para representar cada nodo del árbol
    private class Node {
        Cuenta account; // cada nodo guarda una cuenta
        Node left, right; // referencias a los nodos hijos

        Node(Cuenta acc) {
            this.account = acc;
        }
    }

    // Inserta una cuenta nueva en el árbol (ordenado por número de cuenta)
    public void insert(Cuenta acc) {
        root = insertRec(root, acc);
    }

    // Inserción recursiva según las reglas del BST
    private Node insertRec(Node node, Cuenta acc) {
        if (node == null)
            return new Node(acc); // si el nodo está vacío, creo uno nuevo

        // si el número de cuenta es menor, va a la izquierda
        if (acc.getCuentaNumber() < node.account.getCuentaNumber()) {
            node.left = insertRec(node.left, acc);
        } else {
            // si es mayor o igual, lo mando a la derecha
            node.right = insertRec(node.right, acc);
        }
        return node;
    }

    // Búsqueda REAL por árbol binario
    // Búsqueda de una cuenta usando el árbol (más rápido que recorrer la lista)
    public Cuenta search(int number) {
        return searchRec(root, number);
    }

    private Cuenta searchRec(Node node, int number) {
        if (node == null)
            return null; // no existe la cuenta

        if (number == node.account.getCuentaNumber())
            return node.account; // cuenta encontrada

        if (number < node.account.getCuentaNumber())
            return searchRec(node.left, number); // busco por la izquierda

        return searchRec(node.right, number); // busco por la derecha
    }

    // Recorrido InOrder
    // me muestra las cuentas ordenadas
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left); // primero izquierda
            System.out.println(node.account.getCuentaNumber() + " - " + node.account.getBalance());
            inorderRec(node.right); // luego derecha
        }
    }

}