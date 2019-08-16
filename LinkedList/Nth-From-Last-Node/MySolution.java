class nthFromLast {
    public static LinkedListNode find_nth_from_last(LinkedListNode head, int n) {
        LinkedListNode curr = head;
        LinkedListNode temp = head;
        while (temp != null && n-- > 0) {
            temp = temp.next;
        }
        while (temp != null) {
            curr = curr.next;
            temp = temp.next;
        }

        return curr;
    }
}