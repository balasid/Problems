package com.bala.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumberLinkedList {
    public static void main(String[] args) {
        int l1Arr[] = {9, 9, 9, 9, 9, 9, 9};
        int l2Arr[] = {9, 9, 9, 9};
        ListNode l1 = populateLinkedList(l1Arr);
        System.out.println(l1);
        ListNode l2 = populateLinkedList(l2Arr);
        System.out.println(l2);
        ListNode listNode = new AddTwoNumberLinkedList().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    private static ListNode populateLinkedList(int[] l1) {
        ListNode listNode1 = new ListNode();
        ListNode node = listNode1;
        ListNode previous = null;
        int i = 0;
        while (i < l1.length) {
            if (node == null) {
                node = new ListNode();
                previous.next = node;
            }
            node.val = l1[i];
            previous = node;
            node = node.next;
            i++;
        }
        return listNode1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode toReturn = new ListNode();
        ListNode previousNode = null;
        ListNode listNode = toReturn;
        int previousSum = 0;
        while (l1 != null || l2 != null) {
            int l1Data = l1 == null ? 0 : l1.val;
            int l2Data = l2 == null ? 0 : l2.val;
            int sum = l1Data + l2Data + (listNode == null ? 0 : listNode.val);
            if (sum != 0) {
                previousSum = sum / 10;
                sum = sum % 10;
            }
            if (listNode == null) {
                listNode = new ListNode();
                previousNode.next = listNode;
            }
            listNode.val = sum;
            previousNode = listNode;
            listNode = listNode.next;
            if (previousSum != 0) {
                listNode = new ListNode(previousSum);
                previousNode.next = listNode;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return toReturn;
    }
}

