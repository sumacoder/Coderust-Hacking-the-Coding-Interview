class mirrorBT {
    public static void mirror_binary_tree(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        // We will do a post-order traversal of the binary tree.

        if (root.left != null) {
            mirror_binary_tree(root.left);
        }

        if (root.right != null) {
            mirror_binary_tree(root.right);
        }

        // Let's swap the left and right nodes at current level.

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] argv) {
        BinaryTreeNode root = BinaryTree.create_random_BST(15, 100);
        BinaryTree.display_level_order(root);
        System.out.println();

        mirror_binary_tree(root);

        BinaryTree.display_level_order(root);
    }
}