public class FindBottomLeftTreeValue {
    public static void main(String[] args) {

    }

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
         * @param root: a root of tree
         * @return: return a integer
         */
        static int result;
        static int max;

        public int findBottomLeftValue(TreeNode root) {
            // write your code here
            max = -1;
            result = 0;
            dfs(root, 0);
            return result;
        }

        public static void dfs(TreeNode node, int level) {
            if (node.left == null && node.right == null && level > max) {
                result = node.val;
                max = level;
            }
            if (node.left != null)
                dfs(node.left, level + 1);
            if (node.right != null)
                dfs(node.right, level + 1);
        }
    }
}
