/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity O(h).
 */
class n_ary_binary_conversion {
    public static BinaryTreeNode convert_n_ary_to_binary(TreeNode root) {

        return convert_n_ary_to_binary_rec(root, true);
    }

    public static BinaryTreeNode convert_n_ary_to_binary_rec(TreeNode node, boolean isLeft) {

        if (node == null) {
            return null;
        }

        BinaryTreeNode btnode = new BinaryTreeNode(node.data);
        BinaryTreeNode lastnode = btnode;
        for (int i = 0; i < node.Children.size(); i++) {
            if (isLeft) {
                lastnode.left = convert_n_ary_to_binary_rec(node.Children.get(i), !isLeft);
                lastnode = lastnode.left;
            } else {
                lastnode.right = convert_n_ary_to_binary_rec(node.Children.get(i), !isLeft);
                lastnode = lastnode.right;
            }
        }
        return btnode;
    }

    public static TreeNode convert_binary_to_n_ary_tree(BinaryTreeNode root) {

        return convert_binary_to_n_ary_tree_rec(root, true);
    }

    public static TreeNode convert_binary_to_n_ary_tree_rec(BinaryTreeNode node, boolean isLeft) {

        if (node == null) {
            return null;
        }

        TreeNode nnode = new TreeNode(node.data);
        BinaryTreeNode temp = node;

        if (isLeft) {
            while (temp.left != null) {
                TreeNode child = convert_binary_to_n_ary_tree_rec(temp.left, !isLeft);
                nnode.Children.add(child);
                temp = temp.left;
            }
        } else {
            while (temp.right != null) {
                TreeNode child = convert_binary_to_n_ary_tree_rec(temp.right, !isLeft);
                nnode.Children.add(child);
                temp = temp.right;
            }
        }
        return nnode;
    }

    public static void main(String[] argv) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.Children.add(node2);
        node1.Children.add(node3);
        node1.Children.add(node4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node3.Children.add(node5);
        node3.Children.add(node6);

        System.out.println("Level Order TreeNode Display:");
        TreeNode.display_level_order(node1);

        System.out.println("Converting N_ary Tree to BT\n");

        BinaryTreeNode bnode1 = convert_n_ary_to_binary(node1);
        System.out.println("Level Order BT Display:");
        BinaryTree.display_level_order(bnode1);
        // If the tree is converted into BT then the following statement must return "5"
        System.out.println("\nRoot.Left.Left.Right = " + bnode1.left.left.right.data);

        System.out.println("Converting BT to N_ary Tree\n");
        TreeNode tnode1 = convert_binary_to_n_ary_tree(bnode1);
        System.out.println("Level Order TreeNode Display:");
        TreeNode.display_level_order(tnode1);
    }
}