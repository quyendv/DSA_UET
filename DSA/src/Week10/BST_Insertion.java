package Week10;

public class BST_Insertion {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        if (data > root.data) root.right = insert(root.right, data);
        return root;
    }
}
