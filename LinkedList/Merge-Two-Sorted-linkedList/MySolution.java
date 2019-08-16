/**
 * Runtime Complexity Linear, O(m + n) where m and n are lengths of both linked
 * lists.
 * 
 * Memory complexity Constant, O(1)
 */
class mergeSortList {
    public static LinkedListNode merge_sorted(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode runner1 = head1;
        LinkedListNode runner2 = head2;
        LinkedListNode newHead = new LinkedListNode(-1);
        LinkedListNode newRunner = newHead;
        while (runner1 != null && runner2 != null) {
            if (runner1.data <= runner2.data) {
                newRunner.next = runner1;
                runner1 = runner1.next;
                newRunner = newRunner.next;
            } else {
                newRunner.next = runner2;
                runner2 = runner2.next;
                newRunner = newRunner.next;
            }
        }
        if (runner1 != null) {
            newRunner.next = runner1;
        }

        if (runner2 != null) {
            newRunner.next = runner2;

        }

        return newHead.next;
    }
}