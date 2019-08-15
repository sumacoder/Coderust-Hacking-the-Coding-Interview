
/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Linear, O(n).
 */
class Reverse {
    public static LinkedListNode reverse_recursive(LinkedListNode head) {
        // no need to reverse if head is
        // null or there is only 1 node.
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode reversed_list = reverse_recursive(head.next);

        head.next.next = head;
        head.next = null;
        return reversed_list;
    }

    public static void main(String[] args) {
        LinkedListNode list_head = null;
        list_head = LinkedList.create_random_list(10);

        System.out.print("Original: ");
        LinkedList.display(list_head);

        list_head = reverse_recursive(list_head);
        System.out.print("After Reverse (Recursive):");
        LinkedList.display(list_head);
    }
}