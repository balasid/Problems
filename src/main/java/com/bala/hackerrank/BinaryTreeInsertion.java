package com.bala.hackerrank;

import com.bala.leetcode.InorderTraversal;
import com.bala.paypal.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeInsertion {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.right = new Tree(2);
        tree.right.right = new Tree(5);
        tree.right.right.left = new Tree(3);
        tree.right.right.right = new Tree(6);
        tree.right.right.left.right = new Tree(4);
        InorderTraversal.inorderTraversal(tree);
        insertInTree(tree, 7);
        System.out.println();
        InorderTraversal.inorderTraversal(tree);
    }

    private static void insertInTree(Tree tree, int data) {
        if (tree == null) {
            return;
        }
        Queue<Tree> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(tree);
        while (!levelOrderQueue.isEmpty()) {
            Tree poll = levelOrderQueue.poll();
            if(poll.left == null) {
                poll.left = new Tree(data);
                break;
            } else {
                levelOrderQueue.add(poll.left);
            }
            if(poll.right == null) {
                poll.right = new Tree(data);
                break;
            } else {
                levelOrderQueue.add(poll.right);
            }
        }
    }
}
