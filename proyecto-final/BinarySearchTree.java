public class BinarySearchTree {

    private Node root;

    private class Node {
        Cuenta account;
        Node left, right;

        Node(Cuenta acc) {
            this.account = acc;
        }
    }


    public void insert(Cuenta acc) {
        root = insertRec(root, acc);
    }

    private Node insertRec(Node node, Cuenta acc) {
        if (node == null) return new Node(acc);

        if (acc.getCuentaNumber() < node.account.getCuentaNumber()) {
            node.left = insertRec(node.left, acc);
        } 
        else {
            node.right = insertRec(node.right, acc);
        }
        return node;
    }


    // Búsqueda REAL por árbol binario
    public Cuenta search(int number) {
        return searchRec(root, number);
    }

    private Cuenta searchRec(Node node, int number) {
        if (node == null) return null;

        if (number == node.account.getCuentaNumber())
            return node.account;

        if (number < node.account.getCuentaNumber())
            return searchRec(node.left, number);

        return searchRec(node.right, number);
    }


    // Recorrido InOrder
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.account.getCuentaNumber() + " - " + node.account.getBalance());
            inorderRec(node.right);
        }
    }

}