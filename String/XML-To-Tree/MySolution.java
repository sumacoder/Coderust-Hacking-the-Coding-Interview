/**
 * Runtime Complexity Linear, O(n)
 * 
 * Memory Complexity Linear, O(n)
 */
class xmlTree {
    public static TreeNode create_xml_tree(String xml) throws XMLStreamException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode last = null;
        while (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamConstants.START_DOCUMENT
                    || reader.getEventType() == XMLStreamConstants.SPACE
                    || reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
                reader.next();
                continue;
            } else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                if (!stack.empty()) {
                    last = stack.pop();
                }
                reader.next();
                continue;
            }

            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                TreeNode node = new TreeNode(reader.getLocalName());

                if (!stack.empty()) {
                    stack.peek().Children.add(node);
                }

                stack.push(node);
            } else if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                TreeNode node = new TreeNode(reader.getText());

                if (!stack.empty()) {
                    stack.peek().Children.add(node);
                }
            }

            reader.next();
        }
        return last;
    }

    public static void print_tree(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < depth; ++i)
            System.out.print("\t");
        System.out.print(root.text + "\n");
        for (TreeNode child : root.Children) {
            print_tree(child, depth + 1);
        }
    }

    public static void main(String[] args) {
        try {
            String xml = "<xml><data>hello world     </data>    <a><b></b><b><c></c></b></a></xml>";
            TreeNode result = create_xml_tree(xml);
            print_tree(result, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}