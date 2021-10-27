package com.bala.leetcode;

import com.bala.paypal.Tree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiameterOfBinaryTree {

    static int maxheight = -1;

    public static void main(String[] args) {
        Set<List<Integer>> pathList = new HashSet<>();
        Tree treeNode = new Tree(1);
        treeNode.left = new Tree(2);
        treeNode.right = new Tree(3);
        treeNode.left.left = new Tree(4);
        treeNode.left.right = new Tree(5);
        int dia = computeDiameter(treeNode);
        System.out.println(dia);
    }

    private static int computeDiameter(Tree treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int rightDiameter = computeDiameter(treeNode.right);
        int leftDiameter = computeDiameter(treeNode.left);

        int leftHeight = height(treeNode.left);
        int rightHeight = height(treeNode.right);

        return Math.max(1 + leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    public static int height(Tree node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
