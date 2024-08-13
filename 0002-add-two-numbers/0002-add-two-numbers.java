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

        int sum;        // 자릿수의 합
        int carry = 0;  // 자리올림수
        int val;        // 나머지를 저장할 변수 

        // 모든 연결 리스트를 끝까지 순회 + 받아올림수가 0이어야 while() 탈출
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            // 첫 번째 연결 리스트
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 두 번째 연결 리스트
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // 노드의 값으로 사용할 나머지 계산
            val = (sum + carry) % 10;
            // 자리올림수 계산
            carry = (sum + carry) / 10;
            // 나머지는 다음 노드의 값으로 지정
            node.next = new ListNode(val);
            // 계산할 노드를 다음으로 이동
            node = node.next;
        }

        return answer.next;
    }
}