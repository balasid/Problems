package com.bala.leetcode;

public class MaximumDepthOfTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
//        treeNode = null;
        System.out.println(new MaximumDepthOfTree().maxDepth(treeNode));
    }

    int maxlevel;

    public int maxDepth(TreeNode root) {
        traverseTree(root, 1);
        return maxlevel;
    }

    private void traverseTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (maxlevel < level) {
            maxlevel = level;
        }
        traverseTree(root.left, level + 1);
        traverseTree(root.right, level + 1);
    }
}
