import java.util.LinkedList;
import java.util.Queue;

public class SearchInABinarySearchTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Solution {
        /**
         * @param root: the tree
         * @param val:  the val which should be find
         * @return: the node
         */
        public TreeNode searchBST(TreeNode root, int val) {
            // Write your code here.
            if (root == null)
                return null;
            if (root.val == val)
                return root;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode top = q.poll();
                if (top.val == val)
                    return top;
                if (top.left != null) {
                    if (top.left.val == val)
                        return top.left;
                    q.add(top.left);
                }
                if (top.right != null) {
                    if (top.right.val == val)
                        return top.right;
                    q.add(top.right);
                }
            }
            return null;

        }
    }
}
