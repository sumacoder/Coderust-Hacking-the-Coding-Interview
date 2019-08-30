/**
 * Runtime Complexity push(): Constant, O(1).
 * 
 * pop(): Linear, O(n).
 * 
 * Memory Complexity Linear, O(n).
 */
class stack_using_queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int data) {
        q1.add(data);
    }

    boolean isEmpty() {
        return q1.size() + q2.size() == 0;
    }

    int pop() throws Exception {
        if (isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int res = q1.remove();
        swap_queues();
        return res;

    }

    void swap_queues() {
        Queue<Integer> q3 = q1;
        q1 = q2;
        q2 = q3;
    }

}