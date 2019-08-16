/**
 * Runtime Complexity Linear, O(n)
 * 
 * Memory Complexity Constant, O(1)
 * 
 */
class nthFromLast {
    public static LinkedListNode find_nth_from_last(LinkedListNode head, int n) {

        if (head == null || n < 1) {
            return null;
        }

        // We will use two pointers head and tail
        // where head and tail are 'n' nodes apart.
        LinkedListNode tail = head;

        while (tail != null && n > 0) {
            tail = tail.next;
            --n;
        }

        // Check out-of-bounds n greater than list size
        if (n != 0) {
            return null;
        }

        // When tail pointer reaches the end of
        // list, head is pointing at nth node.
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode list_head = null;
        list_head = LinkedList.create_random_list(10);
        System.out.print("Original: ");
        LinkedList.display(list_head);
        LinkedListNode temp;

        temp = find_nth_from_last(list_head, 5);
        System.out.println(String.format("Result for n=5 is %d", temp.data));

        temp = find_nth_from_last(list_head, 6);
        System.out.println(String.format("Result for n=6 is %d", temp.data));

        temp = find_nth_from_last(list_head, 4);
        System.out.println(String.format("Result for n=4 is %d", temp.data));

        temp = find_nth_from_last(list_head, 10);
        System.out.println(String.format("Result for n=10 is %d", temp.data));

        temp = find_nth_from_last(list_head, 1);
        System.out.println(String.format("Result for n=1 is %d", temp.data));

        temp = find_nth_from_last(list_head, 0);
        System.out.println(String.format("Result for n=0 is null - %s", (temp == null) ? "Success" : "Failure"));

        temp = find_nth_from_last(list_head, 11);
        System.out.println(String.format("Result for n=11 is null - %s", (temp == null) ? "Success" : "Failure"));
    }
}