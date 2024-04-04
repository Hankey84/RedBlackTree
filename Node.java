public class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    boolean isRed;

    public Node(int data) {
        this.data = data;
        isRed = true;
    }
}