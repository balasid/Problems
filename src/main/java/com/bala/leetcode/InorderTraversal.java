package com.bala.leetcode;

import com.bala.paypal.Tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        Tree treeNode = new Tree(1);
        treeNode.right = new Tree(2);
        treeNode.right.left = new Tree(3);
        List<Integer> integers = InorderTraversal.inorderTraversal(treeNode);
        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(Tree root) {
        List<Integer> toRet = new ArrayList<>();
        addToList(root, toRet);
        return toRet;
    }

    private static void addToList(Tree root, List<Integer> toRet) {
        if (root != null) {
            addToList(root.left, toRet);
            System.out.print(root.data + " ");
            toRet.add(root.data);
            addToList(root.right, toRet);
        }
    }
}

