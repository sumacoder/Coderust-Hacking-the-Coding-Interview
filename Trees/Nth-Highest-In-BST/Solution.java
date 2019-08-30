
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while (root != null) {
            s.push(root);
            root = root.right;
        }
        while (k != 0) {
            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            TreeNode left = root.left;
            while (left != null) {
                s.push(left);
                left = left.right;

            }

        }

        return -1;
    }

}
