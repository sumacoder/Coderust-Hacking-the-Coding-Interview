class InsertionSort {
    public static LinkedListNode insertion_sort(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> l = new ArrayList<>();
        LinkedListNode temp = head;
        while (temp != null) {
            l.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(l);
        LinkedListNode res = new LinkedListNode(-1);
        LinkedListNode temp1 = res;
        for (int n : l) {
            temp1.next = new LinkedListNode(n);
            temp1 = temp1.next;
        }

        return res.next;
    }
}