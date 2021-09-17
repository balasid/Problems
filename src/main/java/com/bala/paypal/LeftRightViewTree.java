package com.bala.paypal;

public class LeftRightViewTree {
    static int maxLevel = 0;

    public static void view(Node node, int level, boolean isleft) {
        if (node == null) {
            return;
        }
        while (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }

        if (isleft) {
            view(node.leftNode, level + 1, isleft);
            view(node.rightNode, level + 1, isleft);
        } else {
            view(node.rightNode, level + 1, isleft);
            view(node.leftNode, level + 1, isleft);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftNode = new Node(2);
        root.rightNode = new Node(3);
        root.leftNode.leftNode = new Node(4);
        root.leftNode.rightNode = new Node(5);
        root.rightNode.rightNode = new Node(6);
        root.rightNode.leftNode = new Node(7);
        root.rightNode.rightNode.leftNode = new Node(8);
        view(root, 1, true);
    }

    private static class Node {
        int data;
        Node leftNode, rightNode;

        public Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
}
