public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(10);
        tree.insert(35);
        tree.insert(20);
        tree.insert(30);
        tree.insert(0);
        tree.insert(15);
        tree.insert(5);
        tree.insert(25);

        System.out.println("Содержимое дерева(слева-направо):");
        printTree(tree.getRoot(), 0);
    }

    private static void printTree(Node node, int level) {
        if (node == null) {
            return;
        } 
        printTree(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        
        if (node.isRed) {
            System.out.println("Red--" + node.data);
        } else {
            System.out.println("Black-" + node.data);
        }
        printTree(node.left, level + 1);
    }
}
