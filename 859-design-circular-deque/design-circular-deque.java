class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {

        capacity = k;
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert at front
    public boolean insertFront(int value) {

        if (isFull()) return false;

        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;

        // First element case
        if (size == 1) {
            rear = front;
        }

        return true;
    }

    // Insert at rear
    public boolean insertLast(int value) {

        if (isFull()) return false;

        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;

        // First element case
        if (size == 1) {
            front = rear;
        }

        return true;
    }

    // Delete front
    public boolean deleteFront() {

        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    // Delete last
    public boolean deleteLast() {

        if (isEmpty()) return false;

        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    // Get front
    public int getFront() {

        if (isEmpty()) return -1;

        return deque[front];
    }

    // Get rear
    public int getRear() {

        if (isEmpty()) return -1;

        return deque[rear];
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check full
    public boolean isFull() {
        return size == capacity;
    }
}
