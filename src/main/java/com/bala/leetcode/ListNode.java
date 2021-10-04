package com.bala.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode listNode = this;
        while (listNode != null) {
            builder.append(listNode.val).append(" ");
            listNode = listNode.next;
            if (listNode != null) {
                builder.append("-> ");
            }
        }
        return builder.toString();
    }
}
