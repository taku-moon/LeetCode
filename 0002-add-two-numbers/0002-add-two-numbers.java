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

        // l1.val과 l2.val을 더하면서 생긴 받아올림을 저장할 변수
        int tmp = 0;

        // l1과 l2가 모두 끝에 도달했을 때 즉, 둘 다 null 일 때 while() 탈출
        while (!(l1 == null && l2 == null)) {
            ListNode next = new ListNode();
            node.next = next;

            // l1이 null일 때 l1.val 값이 존재하지 않으므로 0으로 할당
            int val1 = (l1 == null) ? 0 : l1.val;
            // l2가 null일 때 l2.val 값이 존재하지 않으므로 0으로 할당
            int val2 = (l2 == null) ? 0 : l2.val;

            // l1.val과 l2.val을 더하면서 이전에 생긴 받아올림까지 계산
            int val = val1 + val2 + tmp;
            // val을 10으로 나눈 나머지를 val 값으로 할당
            next.val = val % 10;
            // val을 10으로 나눈 몫은 받아올림으로 저장
            tmp = val / 10;

            // 노드들의 위치 이동
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

        // l1과 l2 모두 끝에 도달하여 while() 탈출
        // 만약 남아있는 받아올림이 있다면 마지막 새로운 노드를 만들어 추가
        if (tmp != 0) {
            ListNode next = new ListNode(tmp);
            node.next = next;
        }

        return answer.next; 
    }
}