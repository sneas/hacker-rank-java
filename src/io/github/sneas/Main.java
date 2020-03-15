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
    static Node insert(Node root,int val)
    {
        if (root == null) {
            Node newNode = new Node(val, 0);
            return newNode;
        }

        if (root.val - val < 0) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }

        update(root);

        return balance(root);
    }

    static void update(Node node)
    {
        int lh = -1;
        int rh = -1;

        if (node.left != null) {
            lh = node.left.ht;
        }

        if (node.right != null) {
            rh = node.right.ht;
        }

        node.ht = 1 + Math.max(lh, rh);
    }

    static Node balance(Node node) {
        int bf = getBf(node);

        if (bf == -2) {
            if (getBf(node.left) <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }
        } else if (bf == 2) {
            if (getBf(node.right) >= 0) {
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        }

        return node;
    }

    static Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    static Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    static Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    static Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    static Node rightRotation(Node a) {
        Node b = a.left;
        a.left = b.right;
        b.right = a;

        update(a);
        update(b);

        return b;
    }

    static Node leftRotation(Node a) {
        Node b = a.right;
        a.right = b.left;
        b.left = a;

        update(a);
        update(b);

        return b;
    }

    static int getBf(Node node) {
        int lh = -1;
        int rh = -1;

        if (node.left != null) {
            lh = node.left.ht;
        }

        if (node.right != null) {
            rh = node.right.ht;
        }

        return rh - lh;
    }

    public static void main(String[] args) {
        Node tree = new Node(3, 2);
        tree.left = new Node(2, 0);
        tree.right = new Node(4, 1);
        tree.right.right = new Node(5, 0);

        insert(tree, 6);

        System.out.print("It's working");
    }
}
