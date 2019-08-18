class reverseK {
    static LinkedListNode reverse_k_nodes(LinkedListNode head, int k) {

        // if k is 0 or 1, then list is not changed
        if (k <= 1 || head == null) {
            return head;
        }

        /** need 4 pointers res prevtail currenthead currenttail */
        LinkedListNode reversed = null;
        LinkedListNode prev_tail = null;

        while (head != null && k > 0) {
            LinkedListNode current_head = null;
            LinkedListNode current_tail = head;

            int n = k;
            while (head != null && n > 0) {
                LinkedListNode temp = head.next;
                head.next = current_head;
                current_head = head;

                head = temp;
                n--;
            }

            if (reversed == null) {
                reversed = current_head;
            }

            if (prev_tail != null) {
                prev_tail.next = current_head;
            }
            prev_tail = current_tail;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int[] v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        LinkedListNode list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 3);
        ArrayList<Integer> result = LinkedList.to_list(list_head);
        int[] expected = new int[] { 3, 2, 1, 6, 5, 4, 7 };
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));
        LinkedList.display(list_head);

        v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 7);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 100);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 0);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 1);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 2);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 2, 1, 4, 3, 6, 5, 7 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 6);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 6, 5, 4, 3, 2, 1, 7 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] {};
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 3);
        result = LinkedList.to_list(list_head);
        expected = new int[] {};
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 1);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 1 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));

        v1 = new int[] { 1, 2 };
        list_head = LinkedList.create_linked_list(v1);
        list_head = reverse_k_nodes(list_head, 3);
        result = LinkedList.to_list(list_head);
        expected = new int[] { 2, 1 };
        LinkedList.display(list_head);
        System.out.println(LinkedList.is_equal(list_head, LinkedList.create_linked_list(expected)));
    }
}