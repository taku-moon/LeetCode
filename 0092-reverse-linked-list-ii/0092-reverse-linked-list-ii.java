/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0, head);
        ListNode start = node;
        
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        ListNode leftNode = start.next;
        ListNode rightNode = leftNode.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = rightNode;
            leftNode.next = rightNode.next;
            rightNode.next = tmp;

            rightNode = leftNode.next;
        }

        return node.next;
    }

}