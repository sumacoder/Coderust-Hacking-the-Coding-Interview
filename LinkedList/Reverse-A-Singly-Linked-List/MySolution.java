
/**
 * Runtime Complexity
Linear, O(n).

As we can reverse the linked list in a single pass.

Memory Complexity
Constant, O(1).
 */
import java.util.*;

class MySolution {
    class Reverse {
        public static LinkedListNode reverse_list(LinkedListNode head) {
            LinkedListNode prev = null;
            LinkedListNode curr = head;
            LinkedListNode next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }

    public static void main(String[] args) {
        LinkedListNode list_head = null;
        list_head = LinkedList.create_random_list(10);

        System.out.print("Original: ");
        LinkedList.display(list_head);

        list_head = reverse_iterative(list_head);
        System.out.print("After Reverse (Iterative):");
        LinkedList.display(list_head);
    }
}