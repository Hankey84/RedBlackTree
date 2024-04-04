public class RedBlackTree {
    private Node root;

    public void insert(int data) {
        root = insert(root, data);
        if (root != null) {
            root.isRed = false;
        }
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
            if (root.left.isRed) {                
                if (isRed(root.right)) { // Балансировка
                    root.left.isRed = false;
                    root.right.isRed = false;
                    root.isRed = true;
                } else {
                    if (data < root.left.data) {
                        root = rotateRight(root);
                    } else {
                        root = rotateLeftRight(root);
                    }
                }
            }
        } else if (data > root.data) {
            root.right = insert(root.right, data);
            if (root.right.isRed) {                
                if (isRed(root.left)) {// Балансировка
                    root.left.isRed = false;
                    root.right.isRed = false;
                    root.isRed = true;
                } else {
                    if (data > root.right.data) {
                        root = rotateLeft(root);
                    } else {
                        root = rotateRightLeft(root);
                    }
                }
            }
        }

        return root;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node rotateLeft(Node node) {
        if (node == null || node.right == null) {
            return node;
        }
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.isRed = node.isRed;
        node.isRed = true;
        return temp;
    }

    private Node rotateRight(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.isRed = true;
        newRoot.isRed = false;
        return newRoot;
    }

    private Node rotateLeftRight(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node rotateRightLeft(Node node) {
        if (node == null || node.right == null) {
            return node;
        }
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }
}