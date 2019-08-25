/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Stack<Node> stack = new Stack<>();
        Node dummy = new Node(-1, null, null);
        Node prev = dummy;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null) {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            root = root.right;

        }
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;

    }
}