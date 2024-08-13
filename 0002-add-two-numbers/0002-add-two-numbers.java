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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode answer = node;
        int tmp = 0;

        while (!(l1 == null && l2 == null)) {
            ListNode next = new ListNode();
            node.next = next;

            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;

            int val = val1 + val2 + tmp;
            next.val = val % 10;
            tmp = val / 10;

            node = node.next;
            if (l1 == null) {
                l2 = l2.next;
            } else if (l2 == null) {
                l1 = l1.next;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }            
        }

        if (tmp != 0) {
            ListNode next = new ListNode(tmp);
            node.next = next;
        }

        return answer.next; 
    }
}