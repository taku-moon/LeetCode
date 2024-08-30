class MyStack {
    Queue<Integer> queueStack;

    public MyStack() {
        // ArrayDeque와 LinkedList는 Deque를 구현한다.
        // Deque는 Queue를 상속받는다.
        // 구현체로 ArrayDeque, LinkedList 둘 다 사용 가능
        queueStack = new ArrayDeque<>();
        // queueStack = new LinkedList<>();
    }
    
    public void push(int x) {
        queueStack.add(x);

        // 큐를 스택으로 사용하기 위한 재정렬
        for (int i = 0; i < queueStack.size() - 1; i++) {
            queueStack.add(queueStack.remove());
        }
    }
    
    public int pop() {
        return queueStack.remove();
    }
    
    public int top() {
        return queueStack.peek();
    }
    
    public boolean empty() {
        return queueStack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */