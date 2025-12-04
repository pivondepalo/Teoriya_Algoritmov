class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int key;
        Node left, right, parent;
        boolean color = RED;
        Node(int key) { this.key = key; }
    }

    private Node root;

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    public void insert(int key) {
        Node n = new Node(key);
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (n.key < x.key) x = x.left;
            else x = x.right;
        }

        n.parent = y;
        if (y == null) root = n;
        else if (n.key < y.key) y.left = n;
        else y.right = n;

        fixInsert(n);
    }

    private void fixInsert(Node n) {
        while (n.parent != null && n.parent.color == RED) {
            if (n.parent == n.parent.parent.left) {
                Node u = n.parent.parent.right;
                if (u != null && u.color == RED) {
                    n.parent.color = BLACK;
                    u.color = BLACK;
                    n.parent.parent.color = RED;
                    n = n.parent.parent;
                } else {
                    if (n == n.parent.right) {
                        n = n.parent;
                        rotateLeft(n);
                    }
                    n.parent.color = BLACK;
                    n.parent.parent.color = RED;
                    rotateRight(n.parent.parent);
                }
            } else {
                Node u = n.parent.parent.left;
                if (u != null && u.color == RED) {
                    n.parent.color = BLACK;
                    u.color = BLACK;
                    n.parent.parent.color = RED;
                    n = n.parent.parent;
                } else {
                    if (n == n.parent.left) {
                        n = n.parent;
                        rotateRight(n);
                    }
                    n.parent.color = BLACK;
                    n.parent.parent.color = RED;
                    rotateLeft(n.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }
}
