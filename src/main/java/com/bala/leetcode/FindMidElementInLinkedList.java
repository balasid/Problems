package com.bala.leetcode;

public class FindMidElementInLinkedList {
    public static void main(String[] args) {
        FMELinkedNode fmeLinkedNode = new FMELinkedNode(1);
        fmeLinkedNode.next = new FMELinkedNode(2);
        fmeLinkedNode.next.next = new FMELinkedNode(3);
        fmeLinkedNode.next.next.next = new FMELinkedNode(4);
        fmeLinkedNode.next.next.next.next = new FMELinkedNode(5);
        fmeLinkedNode.next.next.next.next.next = new FMELinkedNode(6);
        fmeLinkedNode.next.next.next.next.next.next = new FMELinkedNode(7);
        fmeLinkedNode.next.next.next.next.next.next.next = new FMELinkedNode(8);
        fmeLinkedNode.next.next.next.next.next.next.next.next = new FMELinkedNode(9);
        fmeLinkedNode.next.next.next.next.next.next.next.next.next = new FMELinkedNode(10);
        fmeLinkedNode.next.next.next.next.next.next.next.next.next.next = new FMELinkedNode(11);
        Integer middleElm = new FindMidElementInLinkedList().findMiddleElm(fmeLinkedNode);
        System.out.println(middleElm);
    }

    public Integer findMiddleElm(FMELinkedNode node) {
        FMELinkedNode firstPointer = node, secondPointer = node;
        while (secondPointer != null && secondPointer.next != null) {
            secondPointer = secondPointer.next.next;
            firstPointer = firstPointer.next;
            System.out.println("First Pointer " + firstPointer.val);
            System.out.println("Second Pointer " + secondPointer.val);
        }
        return firstPointer.val;
    }
}

class FMELinkedNode {
    int val;
    FMELinkedNode next;

    public FMELinkedNode(int val) {
        this.val = val;
    }
}
