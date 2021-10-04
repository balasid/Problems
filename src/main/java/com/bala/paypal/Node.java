package com.bala.paypal;

public class Node {
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

    @Override
    public String toString() {
        Node node = this;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.data);
            node = node.next;
            if (node != null) {
                builder.append(" , ");
            }
        }
        return builder.toString();
    }
}
