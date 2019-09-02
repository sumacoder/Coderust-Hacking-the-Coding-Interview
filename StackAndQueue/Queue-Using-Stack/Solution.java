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
        if (s2.size() == 0) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();

    }

}