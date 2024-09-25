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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        ListNode root = new ListNode();
        ListNode tail = root;

        // 각 연결 리스트의 첫 번째 노드를 큐에 저장
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // 큐가 모두 빌 때까지 반복
        while (!pq.isEmpty()) {
            // 우선순위에 따라 추출, 다음 노드로 이동
            tail.next = pq.poll();
            tail = tail.next;

            // 추출한 연결 리스트의 다음 노드는 다시 큐에 저장
            if (tail.next != null) {
                pq.add(tail.next);
            }
        }

        return root.next;
    }
}