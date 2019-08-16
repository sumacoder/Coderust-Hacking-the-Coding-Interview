/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Constant, O(1).
 */
class swapNth {
    // Node indices starts from 1.
    static LinkedListNode swap_nth_node(LinkedListNode head, int n) {

        if (n == 1 || head == null) {
            return head;
        }

        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while (n-- > 1) {
            prev = curr;
            curr = curr.next;
        }
        // n is greater than the size();
        if (curr == null) {
            return head;
        }

        prev.next = head;
        LinkedListNode temp = head.next;
        head.next = curr.next;
        curr.next = temp;

        return curr;
    }
}