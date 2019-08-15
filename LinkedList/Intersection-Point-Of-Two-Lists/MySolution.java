/**
 * Runtime Complexity Linear, O(m + n).
 * 
 * Where m is the length of the first linked list and n is the length of the
 * second linked list.
 * 
 * Memory Complexity Constant, O(1).
 */
class Intersect {

    public static int getLength(LinkedListNode node) {
        int count = 0;
        LinkedListNode temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode temp1 = head1;
        LinkedListNode temp2 = head2;

        int diff = Math.abs(getLength(head1) - getLength(head2));
        if (getLength(head1) < getLength(head2)) {
            temp1 = head2;
            temp2 = head1;
        }
        while (diff > 0) {
            temp1 = temp1.next;
            diff--;
        }

        while (temp1 != null) {
            if (temp1 == temp2) {
                return temp1;
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        return null;
    }

}