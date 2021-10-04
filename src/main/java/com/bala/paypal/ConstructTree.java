package com.bala.paypal;

public class ConstructTree {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        Tree node = constructTree(a, null, 0);
        traverTree(node);
    }

    static void traverTree(Tree node) {
        if (node != null) {
            System.out.print(node.data + " ");
            traverTree(node.left);
            traverTree(node.right);
        }
    }


    static Tree constructTree(int[] a, Tree node, int i) {
        if (a.length > i) {
            node = new Tree(a[i]);
            Tree node1 = constructTree(a, node.left, 2 * i + 1);
            Tree node2 = constructTree(a, node.right, 2 * i + 2);
            node.left = node1;
            node.right = node2;
        }
        return node;
    }
}

