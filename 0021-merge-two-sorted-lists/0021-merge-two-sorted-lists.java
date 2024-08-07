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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode answer = node;

        while(list1 != null || list2 != null) {
            int val1 = (list1 != null) ? list1.val : 101;
            int val2 = (list2 != null) ? list2.val : 101;

            ListNode tmp = new ListNode();

            if(val1 < val2) {
                tmp.val = val1;
                list1 = list1.next;
            }
            else {
                tmp.val = val2;
                list2 = list2.next;
            }

            node.next = tmp;
            node = node.next;
        }

        return answer.next;
    }
}