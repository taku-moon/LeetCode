/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode answer = head;

        // head와 head.next 둘 중 하나라도 존재하지 않으면 탈출
        while (head != null && head.next != null) {
            // 임시 변수를 사용하여 값 교환
            int tmp = head.val;
            head.val = head.next.val;
            head.next.val = tmp;

            // 두 칸 앞으로 이동
            head = head.next.next;
        }

        return answer;
    }
}