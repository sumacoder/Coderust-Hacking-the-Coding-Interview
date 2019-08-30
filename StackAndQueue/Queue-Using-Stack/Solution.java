class queue_using_stack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int data) {
        s1.push(data);
    }

    boolean isEmpty() {
        return s1.size() + s2.size() == 0;
    }

    int dequeue() throws Exception {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        swap_stack();
        return s1.pop();
    }

    void swap_stack() {
        Stack<Integer> s3 = s1;
        s1 = s2;
        s2 = s3;
    }
}