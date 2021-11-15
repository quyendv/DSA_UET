package Week10;

public class Tree_Height_of_a_Binary_Tree {
    static class Node {
        int data;
        Node left, right;
    }

    public static int height(Node root) {
        // Write your code here.
        if (root == null) return -1; // not 0
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
