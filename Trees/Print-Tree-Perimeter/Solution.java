class printTree {
    public static void print_left_perimeter(BinaryTreeNode root) {
        while (root != null) {

            int curr_val = root.data;

            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                break; // leaf node.
            }
            System.out.print(curr_val + " ");
        }
    }

    public static void print_right_perimeter(BinaryTreeNode root) {
        // stack for right side values.
        Stack<Integer> r_values = new Stack<Integer>();

        while (root != null) {

            int curr_val = root.data;

            if (root.right != null) {
                root = root.right;
            } else if (root.left != null) {
                root = root.left;
            } else {
                break; // leaf node.
            }

            r_values.push(curr_val);
        }

        while (!r_values.isEmpty()) {
            System.out.print(r_values.pop() + " ");
        }
    }

    public static void print_leaf_nodes(BinaryTreeNode root) {
        if (root != null) {
            print_leaf_nodes(root.left);
            print_leaf_nodes(root.right);

            if (root.left == null && root.right == null) {
                System.out.print(root.data + " ");
            }
        }
    }

    public static void display_tree_perimeter(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");

            print_left_perimeter(root.left);

            if (root.left != null || root.right != null) {
                // We don't need to print if root is also the leaf node.
                print_leaf_nodes(root);
            }

            print_right_perimeter(root.right);
        }
    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(100);
        arr.add(25);
        arr.add(75);
        arr.add(15);
        arr.add(350);
        arr.add(300);
        arr.add(10);
        arr.add(50);
        arr.add(200);
        arr.add(400);
        arr.add(325);
        arr.add(375);

        BinaryTreeNode root = BinaryTree.create_BST(arr);
        BinaryTree.display_level_order(root);
        BinaryTree.another_display_tree(root);
        System.out.print("Perimeter:\n");
        display_tree_perimeter(root);
    }
}