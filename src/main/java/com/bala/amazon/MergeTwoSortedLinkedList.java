package com.bala.amazon;

import com.bala.paypal.Node;

public class MergeTwoSortedLinkedList {


    public static void main(String[] args) {
        int[] a = new int[]{5, 10, 15, 40};
        int[] b = new int[]{2, 3, 20};
        Node node1 = fillToLinkedList(a);
        Node node2 = fillToLinkedList(b);
        System.out.println(node1.toString());
        System.out.println(node2.toString());
        Node node3 = mergeNode(node1, node2);
        System.out.println(node3);
    }

    private static Node mergeNode(Node node1, Node node2) {
        Node node = new Node(0);
        Node toReturn = node;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 != null) {
                int data1 = node1.getData();
                int data2 = node2.getData();
                if (data1 < data2) {
                    Node next = new Node(data1);
                    node.setNext(next);
                    node = next;
                    node1 = node1.getNext();
                } else {
                    Node next = new Node(data2);
                    node.setNext(next);
                    node = next;
                    node2 = node2.getNext();
                }
            } else if (node1 == null) {
                int data2 = node2.getData();
                Node next = new Node(data2);
                node.setNext(next);
                node = next;
                node2 = node2.getNext();
            } else {
                int data2 = node1.getData();
                Node next = new Node(data2);
                node.setNext(next);
                node = next;
                node1 = node1.getNext();
            }
        }
        return toReturn.getNext();
    }

    private static Node fillToLinkedList(int[] a) {
        Node node = new Node(a[0]);
        Node toReturn = node;
        int i = 1;
        while (i < a.length) {
            Node next = new Node(a[i]);
            node.setNext(next);
            node = next;
            i++;
        }
        return toReturn;
    }
}
