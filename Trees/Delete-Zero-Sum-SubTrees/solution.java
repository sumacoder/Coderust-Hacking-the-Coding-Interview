class delZeroSum {
    public static int delete_zero_sum_subtree_rec(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum_left = delete_zero_sum_subtree_rec(root.left);
        int sum_right = delete_zero_sum_subtree_rec(root.right);

        if (sum_left == 0) {
            root.left = null;
        }
        if (sum_right == 0) {
            root.right = null;
        }

        return root.data + sum_left + sum_right;
    }

    public static void delete_zero_sum_subtree(BinaryTree tree) {

        if (tree == null || tree.root == null) {
            return;
        }

        if (0 == delete_zero_sum_subtree_rec(tree.root)) {
            tree.root = null;
        }
    }

    public static BinaryTreeNode create_test_tree1() {
        BinaryTreeNode head = new BinaryTreeNode(7);
        BinaryTreeNode curr_head = head;

        BinaryTreeNode left = new BinaryTreeNode(5);
        BinaryTreeNode right = new BinaryTreeNode(6);//
        curr_head.left = left;
        curr_head.right = right;

        curr_head = head.left;
        left = new BinaryTreeNode(-3);
        right = new BinaryTreeNode(-2);
        curr_head.left = left;
        curr_head.right = right;

        return head;
    }

    public static void main(String[] argv) {
        BinaryTreeNode root = create_test_tree1();
        BinaryTree tree = new BinaryTree(root);
        BinaryTree.display_level_order(tree.root);
        System.out.println();
        delete_zero_sum_subtree(tree);
        BinaryTree.display_level_order(tree.root);
    }
}