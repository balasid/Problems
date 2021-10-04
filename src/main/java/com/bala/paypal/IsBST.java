package com.bala.paypal;

public class IsBST {
    public static void main(String[] args) {
        IsBST isBST = new IsBST();
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
//        root.left.left = new Node(1);
//        root.left.right = new Node(4);
        /*Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);*/
        if (isBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Is BST");
        } else {
            System.out.println("Is Not BST");
        }
    }

    public boolean isBST(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }
        if (node.data < minValue || node.data > maxValue)
            return false;

        return (isBST(node.left, minValue, node.data - 1) && isBST(node.right, node.data + 1, maxValue));
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
