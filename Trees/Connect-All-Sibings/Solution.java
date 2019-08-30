/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Constant O(1).
 */
class connectSiblings {
    public static void populate_sibling_pointers(BinaryTreeNode root) {
        TreeNode current = root;
        TreeNode last = root;
        while (current != null) {
            if (current.left != null) {
                last.next = current.left;
                last = last.next;
            }
            if (current.right != null) {
                last.next = current.right;
                last = last.next;
            }
            last.next = null;
            current.next = current.left;
        }
    }
}