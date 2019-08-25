/**
 * Runtime Complexity Linear, O(n).
 * 
 * 
 * Memory Complexity O(h).
 * 
 * The iterative solution has O(h) memory complexity as it instantiates a stack
 * that has to store information up to the height of binary tree h. It will be
 * O(log n) for a balanced tree and can be O(n) in the worst case.
 */
class inorderIterative {
    static String inorder_iterative(BinaryTreeNode root) {
        String result = "";
        if (root == null)
            return result;

        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

        while (!stk.empty() || root != null) {
            if (root != null) {
                stk.push(root);
                root = root.left;
                continue;
            }
            result += stk.peek().data + ",";
            System.out.print(stk.peek().data + " ");
            root = stk.pop().right;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(125);
        input.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input);
        inorder_iterative(root);
        System.out.println();
    }
}