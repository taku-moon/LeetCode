class MyStack {
    Queue<Integer> queueStack;

    public MyStack() {
        queueStack = new LinkedList<>();
    }
    
    public void push(int x) {
        queueStack.add(x);
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