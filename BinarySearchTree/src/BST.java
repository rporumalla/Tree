/**
 * Created by rajporu on 3/3/17.
 */

import java.util.Queue;
import java.util.LinkedList;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + 1 + size(x.right);
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else
                return x.val;
        }
        return null;
    }

    private int height(Node x) {
        int height = 0;
        if (x != null){
            int lheight = height(x.left);
            int rheight = height(x.right);
            height = 1 + Math.max(lheight, rheight);
        }
        return height;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);

        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);

        if (cmp == 0)
            return x;
        if (cmp > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null)
            return 0;

        int cmp = key.compareTo(x.key);

        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node x) {
        if (x != null) {
            System.out.print(x.key + "  ");
            preorder(x.left);
            preorder(x.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (x != null) {
            inorder(x.left);
            System.out.print(x.key + "  ");
            inorder(x.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node x) {
        if (x != null) {
            postorder(x.left);
            postorder(x.right);
            System.out.print(x.key + "  ");
        }
    }

    public void levelorder() {
        levelorder(root);
    }

    private void levelorder(Node x) {
        Queue<Node> q = new LinkedList<Node>();
        if (x!= null)
            q.add(x);
        while (!q.isEmpty()) {
            Node tempNode = q.poll();
            System.out.print(tempNode.key + "  ");
            if (tempNode.left != null)
                q.add(tempNode.left);
            if (tempNode.right != null)
                q.add(tempNode.right);
        }
    }

    public void delete(Key key) {

    }
}
