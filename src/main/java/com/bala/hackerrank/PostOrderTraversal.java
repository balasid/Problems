package com.bala.hackerrank;

import com.bala.paypal.Tree;

public class PostOrderTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.right = new Tree(2);
        tree.right.right = new Tree(5);
        tree.right.right.left = new Tree(3);
        tree.right.right.right = new Tree(6);
        tree.right.right.left.right = new Tree(4);
        postOrder(tree);
    }

    public static void postOrder(Tree tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.print(tree.data + " ");
    }
}
