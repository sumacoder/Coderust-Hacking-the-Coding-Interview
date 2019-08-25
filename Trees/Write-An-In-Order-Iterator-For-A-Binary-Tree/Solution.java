class inorder_iterator {
    class inorder_tree_iterator {
        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

        public inorder_tree_iterator(BinaryTreeNode root) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public BinaryTreeNode getNext() {
            if (stk.isEmpty())
                return null;

            BinaryTreeNode rVal = stk.pop();
            BinaryTreeNode temp = rVal.right;
            while (temp != null) {
                stk.push(temp);
                temp = temp.left;
            }

            return rVal;
        }
    }

    public void inorder_using_iterator(BinaryTreeNode root) {
        inorder_tree_iterator iter = new inorder_tree_iterator(root);
        while (iter.hasNext()) {
            System.out.print(iter.getNext().data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        inorder_iterator instance = new inorder_iterator();

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(125);
        input.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input);

        instance.inorder_using_iterator(root);
        System.out.println();
    }
}