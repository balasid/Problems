package com.bala.hackerrank;

import com.bala.paypal.Tree;

import java.util.Collection;
import java.util.TreeMap;

public class TopViewOfTree {
    static TreeMap<Integer, Container> map = new TreeMap<>();

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.right = new Tree(2);
        tree.right.right = new Tree(5);
        tree.right.right.left = new Tree(3);
        tree.right.right.right = new Tree(6);
        tree.right.right.left.right = new Tree(4);
        topView(tree, 0, 0);
        Collection<Container> values = map.values();
        for (Container value : values) {
            System.out.print(value.data + " ");
        }
    }

    private static void topView(Tree root, Integer depth, Integer level) {
        if (root == null) {
            return;
        }
        map.compute(depth, (k, v) -> {
            if (v == null) {
                return new Container(root.data, level);
            } else {
                if (v.level > level) return new Container(root.data, level);
                return v;
            }
        });
        topView(root.left, depth - 1, level + 1);
        topView(root.right, depth + 1, level + 1);
    }

    static class Container {
        int data, level;

        public Container(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }
}
