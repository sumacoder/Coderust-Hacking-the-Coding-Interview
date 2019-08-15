/**
 * Runtime Complexity Polynomial, O(n2).
 * 
 * Memory complexity Linear, O(n)
 */
class InsertionSort {
    public static LinkedListNode sorted_insert(LinkedListNode head, LinkedListNode node) {

        if (node == null) {
            return head;
        }

        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        LinkedListNode curr = head;

        while (curr.next != null && (curr.next.data < node.data)) {

            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;

        return head;
    }

    public static LinkedListNode insertion_sort(LinkedListNode head) {

        LinkedListNode sorted = null;
        LinkedListNode curr = head;

        while (curr != null) {

            LinkedListNode temp = curr.next;

            sorted = sorted_insert(sorted, curr);

            curr = temp;
        }

        return sorted;
    }

    public static void main(String[] args) {

        // test 1
        {
            int[] list1 = { 3, 1, 5, 4, 9, 0 };
            int[] list1_expected = { 0, 1, 3, 4, 5, 9 };
            LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
            LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);

            System.out.print("Original: ");
            LinkedList.display(list_head1);

            list_head1 = insertion_sort(list_head1);
            System.out.print("After Reverse:");
            LinkedList.display(list_head1);

        }

        // test2
        {
            int[] list1 = { 9, 7, 5, 3, 1 };
            int[] list1_expected = { 1, 3, 5, 7, 9 };
            LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
            LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);

            System.out.print("Original: ");
            LinkedList.display(list_head1);

            list_head1 = insertion_sort(list_head1);
            System.out.print("After Reverse:");
            LinkedList.display(list_head1);

        }

        // test3
        {
            int[] list1 = { 1 };
            int[] list1_expected = { 1 };
            LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
            LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);

            System.out.print("Original: ");
            LinkedList.display(list_head1);

            list_head1 = insertion_sort(list_head1);
            System.out.print("After Reverse:");
            LinkedList.display(list_head1);

        }

        // test4
        {
            int[] list1 = { 1, 2 };
            int[] list1_expected = { 1, 2 };
            LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
            LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);

            System.out.print("Original: ");
            LinkedList.display(list_head1);

            list_head1 = insertion_sort(list_head1);
            System.out.print("After Reverse:");
            LinkedList.display(list_head1);

        }
    }
}