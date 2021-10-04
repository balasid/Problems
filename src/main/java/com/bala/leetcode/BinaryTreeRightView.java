package com.bala.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightView {
    int maxLevel = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(6);
        treeNode.right.right.left = new TreeNode(7);
        treeNode.right.right.left.right = new TreeNode(9);
        System.out.println(new BinaryTreeRightView().rightSideView(treeNode));
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(root.val);
        traverseRight(root, 0, integers);
        return integers;
    }

    private void traverseRight(TreeNode root, int level, List<Integer> integers) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            maxLevel = level;
            System.out.println(root.val);
            integers.add(root.val);
        }
        traverseRight(root.right, level + 1, integers);
        traverseRight(root.left, level + 1, integers);
    }
}
