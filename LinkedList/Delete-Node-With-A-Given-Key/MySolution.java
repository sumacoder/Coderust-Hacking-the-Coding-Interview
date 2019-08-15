/**
 * Runtime Complexity Linear, O(n)
 * 
 * Memory Complexity Constant, O(1)
 */
class MySolution {
    public static LinkedListNode delete_node(LinkedListNode head, int key) {
        if (head.data == key) {
            head = head.next;
            return head;
        }
        LinkedListNode curr = head.next;
        LinkedListNode prev = head;
        while (curr != null) {
            if (curr.data == key) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}