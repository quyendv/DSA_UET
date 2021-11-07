// Bài giảng cô Châu

package Week9;

public class BinaryTree<Key> {
    private Key key;
    private BinaryTree<Key> left, right;

    public BinaryTree(Key key) {
        this.key = key;
        left = null;
        right = null;
    }

    public BinaryTree(Key key, BinaryTree<Key> left, BinaryTree<Key> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return key.toString() + " ";
    }

    public void traversePostOrder() {
        if (left != null) left.traversePreOrder();
        if (right != null) right.traversePreOrder();
        System.out.print(this);
    }

    public void traverseInOrder() {
        if (left != null) left.traversePreOrder();
        System.out.print(this);
        if (right != null) right.traversePreOrder();
    }

    public void traversePreOrder() {
        System.out.print(this);
        if (left != null) left.traversePreOrder();
        if (right != null) right.traversePreOrder();
    }

    public boolean contains(Key key) {
        return key.equals(this.key)
                || left != null && key.equals(left.key)
                || right != null && key.equals(right.key);
    }

    public int size() {
        int countLeft = left == null ? 0 : left.size();
        int countRight = right == null ? 0 : right.size();;
        return 1 + countLeft + countRight;
    }

    public int height() {
        int leftSize = left == null ? 0 : left.height();
        int rightSize = right == null ? 0 : right.height();
        return 1 + Math.max(leftSize, rightSize);
    }

    public static void main(String[] args) {
        BinaryTree<String> d = new BinaryTree<>("D");
        BinaryTree<String> e = new BinaryTree<>("E");
        BinaryTree<String> f = new BinaryTree<>("F");
        BinaryTree<String> g = new BinaryTree<>("G");
        BinaryTree<String> b = new BinaryTree<>("B", d, e);
        BinaryTree<String> c = new BinaryTree<>("C", f, g);
        BinaryTree<String> a = new BinaryTree<>("A", b, c);
        a.traversePreOrder();
        a.traverseInOrder();
        a.traversePostOrder();
        System.out.println(a.contains("Z"));
        System.out.println(a.size());
        System.out.println(a.height());
    }
}

/*
              A
          B       C
        D   E   F   G
*/