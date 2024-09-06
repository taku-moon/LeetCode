class MyCircularQueue {
    int[] myCircularQueue;
    int k, size, front, rear;

    public MyCircularQueue(int k) {
        myCircularQueue = new int[k];
        this.k = k;
        size = 0;
        front = 0;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % k;
        myCircularQueue[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % k;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : myCircularQueue[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : myCircularQueue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */