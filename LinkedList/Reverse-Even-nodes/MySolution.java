/**
 * Runtime Complexity Linear, O(n). Memory Complexity Constant, O(1).
 */
class reverseEven {
    public static LinkedListNode reverse_even_nodes(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode list_even = null;
        LinkedListNode runner = head;

        while (runner != null && runner.next != null) {
            LinkedListNode even = runner.next;
            runner.next = even.next;

            even.next = list_even;
            list_even = even;

            runner = runner.next;
        }
        return mergeLists(head, list_even);
    }

    static LinkedListNode mergeLists(LinkedListNode odd, LinkedListNode even) {

        if (odd == null) {
            return even;
        }

        if (even == null) {
            return odd;
        }
        LinkedListNode mergedHead = new LinkedListNode(-1);
        LinkedListNode runner = mergedHead;
        int count = 1;
        while (odd != null && even != null) {
            if (count % 2 == 1) {
                runner.next = odd;
                odd = odd.next;
                runner = runner.next;
            } else {
                runner.next = even;
                even = even.next;
                runner = runner.next;
            }

            count++;
        }
        if (odd != null) {
            runner.next = odd;
        }
        if (even != null) {
            runner.next = even;
        }
        return mergedHead.next;
    }
}