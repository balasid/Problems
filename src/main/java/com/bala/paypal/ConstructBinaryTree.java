package com.bala.paypal;

import java.util.Arrays;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int a[] = {1, 5, 2, 3, 7, 6, 8, 4, 9, 10};
        Arrays.sort(a);
        Tree nodeElm = constructBinaryTree(a, 0, a.length - 1);
        System.out.println(nodeElm);
        traverseNode(nodeElm);
    }

    private static Tree constructBinaryTree(int[] a, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            Tree nodeElm = new Tree(a[mid]);
            nodeElm.left = constructBinaryTree(a, start, mid - 1);
            nodeElm.right = constructBinaryTree(a, mid + 1, end);
            return nodeElm;
        }
        return null;
    }

    private static void traverseNode(Tree elm) {
        if (elm != null) {
            System.out.print(elm.data + " ");
            traverseNode(elm.left);
            traverseNode(elm.right);
        }
    }
}
