class inorderSuccessor {
    static BinaryTreeNode find_min(BinaryTreeNode root) {

        if (root == null)
            return null;

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    static BinaryTreeNode inorder_successor_bst(BinaryTreeNode root, int d) {

        if (root == null) {
            return null;
        }

        BinaryTreeNode successor = null;

        while (root != null) {

            if (root.data < d) {
                root = root.right;
            } else if (root.data > d) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = find_min(root.right);
                }
                break;
            }
        }
        return successor;
    }

    /// Test Program.
    public static void main(String[] args) {
        ArrayList<Integer> orig_data = new ArrayList<Integer>();
        orig_data.add(25);
        orig_data.add(125);
        orig_data.add(200);
        orig_data.add(350);
        orig_data.add(50);
        orig_data.add(75);
        orig_data.add(100);
        BinaryTreeNode root = BinaryTree.create_BST(orig_data);

        ArrayList<Integer> all_data = BinaryTree.bst_to_arraylist(root);

        for (Integer d : orig_data) {
            BinaryTreeNode successor = inorder_successor_bst(root, d);
            int i = all_data.indexOf(d);
            Integer expected_val = null;
            if (i < all_data.size() - 1) {
                expected_val = all_data.get(i + 1);
            }

            if (successor != null) {
                if (expected_val.intValue() != successor.data) {
                    System.out.println("*******" + d + " ==== " + expected_val + ", " + successor.data + "*****");
                    // System.out.println(expected_val.intValue() == successor.data);
                }
            } else {
                // System.out.println(successor == null);
            }
            if (successor != null) {
                System.out.print("(" + d + ", " + successor.data + ") ");
            } else {
                System.out.print("(" + d + ", null) ");
            }
        }
    }
}