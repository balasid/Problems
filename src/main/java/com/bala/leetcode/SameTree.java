package com.bala.leetcode;

public class SameTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        System.out.println(new SameTree().isSameTree(treeNode, treeNode1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
