package com.bala.paypal;

import java.util.HashSet;

public class RemoveDuplicateInLinkedList {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(12);
        node.next.next = new Node(11);
        node.next.next.next = new Node(11);
        node.next.next.next.next = new Node(12);
        node.next.next.next.next.next = new Node(11);
        node.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List ");
        printList(node);
        removeDuplicatesUsingHash(node);
        System.out.println("\nLinked List after Remove");
        printList(node);
    }

    public static void removeDuplicatesUsingHash(Node node) {
        Node current = node, previous = null;
        HashSet<Integer> hashSet = new HashSet<>();
        while (current != null && current.next != null) {
            if (hashSet.contains(current.data)) {
                previous.next = current.next;
            } else {
                hashSet.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void removeDuplicates(Node node) {
        Node node2 = null, dup = null;
        while (node != null && node.next != null) {
            node2 = node.next;
            while (node2 != null && node2.next != null) {
                if (node.data == node2.data) {
                    node2.next = node2.next.next;
                } else {
                    node2 = node2.next;
                }
            }
            node = node.next;
        }
    }

    public static void printList(Node node) {
        while (node != null && node.next != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
    }
}

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
