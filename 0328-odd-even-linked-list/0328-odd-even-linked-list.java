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
    public ListNode oddEvenList(ListNode head) {
        // 예외처리
        if (head == null){
            return head;
        }

        ListNode odd = head;                    // 홀수 노드 (1, 3, 5, ...)
        ListNode even = head.next;              // 짝수 노드 (2, 4, 6, ...)
        ListNode firstEvenNode = head.next;     // 짝수 노드의 의 첫 번째 노드 (2)

        // 짝수 노드가 null이거나, 짝수 노드의 다음 노드가 null이면 while() 탈출
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        // 홀수 노드의 마지막과 짝수 노드의 첫 번째를 연결
        odd.next = firstEvenNode;

        return head;
    }
}