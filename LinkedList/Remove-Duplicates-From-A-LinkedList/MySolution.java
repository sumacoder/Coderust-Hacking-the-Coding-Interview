/**
 * Runtime Complexity Linear, O(n) - where 'n' is length of the linked list.
 * 
 * Memory Complexity Linear, O(n) - to store visited nodes in hashset.
 */
class MySolution {
    public static LinkedListNode remove_duplicates(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode temp = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(temp.data);
        while (temp.next != null) {
            if (!set.contains(temp.next.data)) {
                set.add(temp.next.data);
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}