package com.bala.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> integers = new InorderTraversal().inorderTraversal(treeNode);
        System.out.println(integers);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> toRet = new ArrayList<>();
        addToList(root, toRet);
        return toRet;
    }

    private void addToList(TreeNode root, List<Integer> toRet) {
        if (root != null) {
            addToList(root.left, toRet);
            System.out.println(root.val);
            toRet.add(root.val);
            addToList(root.right, toRet);
        }
    }
}

