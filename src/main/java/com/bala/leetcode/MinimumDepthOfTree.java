package com.bala.leetcode;

public class MinimumDepthOfTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(5);/*
        treeNode.left.left = null;
        treeNode.left.right = null;
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);*/
//        treeNode = null;
        System.out.println(new MinimumDepthOfTree().minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        return traverseTree(root);
    }

    private int traverseTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.right == null && root.left == null) {
            return 1;
        } else if (root.left == null) {
            return traverseTree(root.right) + 1;
        } else if (root.right == null) {
            return traverseTree(root.left) + 1;
        }
        return Math.min(traverseTree(root.right), traverseTree(root.left)) + 1;
    }
}
