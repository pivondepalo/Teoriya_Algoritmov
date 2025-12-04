class BST {
    class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node n, int k) {
        if (n == null) return new Node(k);
        if (k < n.key) n.left = insertRec(n.left, k);
        else n.right = insertRec(n.right, k);
        return n;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node n, int k) {
        if (n == null) return false;
        if (n.key == k) return true;
        return k < n.key ? searchRec(n.left, k) : searchRec(n.right, k);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node n, int k) {
        if (n == null) return null;
        if (k < n.key) n.left = deleteRec(n.left, k);
        else if (k > n.key) n.right = deleteRec(n.right, k);
        else {
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;
            n.key = min(n.right);
            n.right = deleteRec(n.right, n.key);
        }
        return n;
    }

    private int min(Node n) {
        while (n.left != null) n = n.left;
        return n.key;
    }
}
