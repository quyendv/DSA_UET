// https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/RedBlackBST.java.html
// Cài đặt lại

package Week10;

import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
            this.left = null;
            this.right = null;
        }
    }

    /***************************************************************************
     *  Node helper methods.
     ***************************************************************************/
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /***************************************************************************
     *  Standard BST search.
     ***************************************************************************/
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // if (x == null) return null;
        // int cmp = key.compareTo(x.key);
        // if (cmp < 0) return get(root.left, key);
        // if (cmp > 0) return get(root.right, key);
        // return x.value;

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK; // root is always black node.
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, RED, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.value = val;

        // fix-up any right-leaning links
        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);

        // set lại size của x (mới)
        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }

    // make a right-leaning link lean to the left.
    private Node rotateLeft(Node x) {
        Node rightNode = x.right;

        // set link.
        x.right = rightNode.left;
        rightNode.left = x;

        // set color.
        rightNode.color = x.color;
        x.color = RED;

        // set size. (ta chỉ set lại size của Node con (tức node x - đã chuyển thành leftChild của rightNode)
        rightNode.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);

        return rightNode;
    }

    // make a left-leaning link lean to the right. Tương tự rotateLeft
    private Node rotateRight(Node x) {
        Node leftNode = x.left;

        // setLink
        x.left = leftNode.right;
        leftNode.right = x;

        // setColor
        leftNode.color = x.color;
        x.color = RED;

        // setSize
        leftNode.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);

        return leftNode;
    }

    // flip the colors of a node and its two children. Xử lý Node 4
    private void flipColors(Node x) {
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("call min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        // if (x == null) return null; // không cần vì khi gọi hàm thì BST !empty
        while (x.left != null) x = x.left;
        return x;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("call max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        while (x.right != null) x = x.right;
        return x;
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        if (cmp == 0) return x;
        // else:
        Node t = floor(x.right, key);
        if (t == null) return x;
        return t;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceiling(x.right, key);
        if (cmp == 0) return x;
        // else:
        Node t = ceiling(x.left, key);
        if (t == null) return x;
        return t;
    }

    // số Key < key đã cho, không tính == (làm gần giống floor)
    public int rank(Key key) {
        return rank(key, root);
    }

    // Số Node.key < key (không có == )
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        if (cmp == 0) return size(x.left);
        // else: > 0
        return 1 + size(x.left) + rank(key, x.right);
    }

    // Lấy phần tử nhỏ thứ rank trong tree (đánh số từ 0). Có n Node và rank sẽ từ 0 -> n - 1.
    // Số nhỏ thứ rank tức có rank số nhỏ hơn nó (từ 0 đến rank - 1)
    public Key select(int rank) {
        if (rank < 0 || rank >= size()) throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        return select(root, rank);
    }

    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if (leftSize == rank) return x.key; // tức có rank node nhỏ hơn nó
        if (leftSize > rank)
            return select(x.left, rank); // tức đang là Node nhỏ thứ leftSize > rank -> cần tìm số nhỏ hơn
        // else:
        return select(x.right, rank - leftSize - 1);
    }
}
