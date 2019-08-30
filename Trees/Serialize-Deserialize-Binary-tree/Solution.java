/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Logarithmic, O(logn).
 */
class serializeBT {
    private static final int MARKER = Integer.MIN_VALUE;

    public static void serialize(BinaryTreeNode node, ObjectOutputStream stream) throws java.io.IOException {
        if (node == null) {
            stream.writeInt(MARKER);
            return;
        }

        stream.writeInt(node.data);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }

    public static BinaryTreeNode deserialize(ObjectInputStream stream) throws java.io.IOException {
        int val = stream.readInt();
        if (val == MARKER) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(val);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }

    public static void main(String[] args) {
        try {
            BinaryTreeNode root = BinaryTree.create_random_BST(15, 100);

            BinaryTree.display_inorder(root);

            ByteArrayOutputStream baostream = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(baostream);
            serialize(root, stream);
            stream.close();

            ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
            ObjectInputStream istream = new ObjectInputStream(baistream);
            BinaryTreeNode root_deserialized = deserialize(istream);

            System.out.println("\nResult");
            BinaryTree.display_inorder(root_deserialized);

            System.out.println(BinaryTree.is_identical_tree(root, root_deserialized));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}