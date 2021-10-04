package com.bala.leetcode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
       /* treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);*/
        System.out.println(new ValidateBinarySearchTree().isValidBST(treeNode));
    }

    private static boolean validateBST(TreeNode treeNode, Integer minValue, Integer maxValue) {
        if (treeNode == null) {
            return true;
        } else if (maxValue != null && treeNode.val >= maxValue || minValue != null && treeNode.val <= minValue) {
            return false;
        } else
            return validateBST(treeNode.left, minValue, treeNode.val) && validateBST(treeNode.right, treeNode.val, maxValue);
    }

    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);

    }

}


