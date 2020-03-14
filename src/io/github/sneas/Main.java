package io.github.sneas;

class Node {
    public Node(int val, int ht) {
        this.val = val;
        this.ht = ht;
    }

    public Node left;
    public Node right;
    public int val;
    public int ht;
}

public class Main {
    public static void main(String[] args) {
        Node tree = new Node(3, 2);
        tree.left = new Node(2, 0);
        tree.right = new Node(4, 1);
        tree.right.right = new Node(5, 0);
    }
}
