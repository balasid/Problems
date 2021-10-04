package com.bala.leetcode;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode listNode1 = mergeTwoSortedList.mergeTwoLists(listNode, listNode2);
        mergeTwoSortedList.printList(listNode1);
    }

    void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if(listNode!=null){
                System.out.print("->");
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode dummyNode = node;
        while (true) {
            if (l1 == null) {
                dummyNode.next = l2;
                break;
            }
            if (l2 == null) {
                dummyNode.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
            } else {
                dummyNode.next = l2;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }
        return node.next;
    }
}