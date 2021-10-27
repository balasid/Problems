package com.bala.hackerrank;

import com.bala.paypal.Tree;

public class BinarySearchTreeInsertion {

    public static void main(String[] args) {
        insertToBinarySearchTree(new Tree(5), 18);

    }

    private static Tree insertToBinarySearchTree(Tree tree, int i) {
        if (tree == null) {
            return new Tree(i);
        }
        if (i < tree.data) {
            tree.left = insertToBinarySearchTree(tree.left, i);
        } else {
            tree.right = insertToBinarySearchTree(tree.right, i);
        }
        return tree;
    }
}

