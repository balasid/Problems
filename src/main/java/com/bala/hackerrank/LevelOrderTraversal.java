package com.bala.hackerrank;

import com.bala.paypal.Tree;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.right = new Tree(2);
        tree.right.right = new Tree(5);
        tree.right.right.left = new Tree(3);
        tree.right.right.right = new Tree(6);
        tree.right.right.left.right = new Tree(4);
        levelOrder(tree);
    }

    private static void levelOrder(Tree tree) {
        Queue<Tree> treeQueue = new LinkedList<>();
        treeQueue.add(tree);
        while (!treeQueue.isEmpty()) {
            Tree poll = treeQueue.poll();
            System.out.print(poll.data+" ");
            if(poll.left !=null) {
                treeQueue.add(poll.left);
            }
            if(poll.right !=null) {
                treeQueue.add(poll.right);
            }
        }
    }

    /*static TreeMap<Integer, List<Integer>> levelOrderMap = new TreeMap<>();

    public static void levelOrder(Tree root) {
        levelOrder(root, 0);
        Collection<List<Integer>> values = levelOrderMap.values();
        for (List<Integer> value : values) {
            for (Integer integer : value) {
                System.out.print(integer + " ");
            }
        }
    }

    private static void levelOrder(Tree root, int level) {
        if (root == null) {
            return;
        }
        List<Integer> integers = levelOrderMap.computeIfAbsent(level, k -> new ArrayList<>());
        integers.add(root.data);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }*/
}
