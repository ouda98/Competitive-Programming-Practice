public class SumRootToLeafNumbers {
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
         * @param root: the root of the tree
         * @return: the total sum of all root-to-leaf numbers
         */
        static int s;

        public int sumNumbers(TreeNode root) {
            // write your code here
            s = 0;
            dfs(root, "" + root.val);
            return s;
        }

        public static void dfs(TreeNode node, String sum) {
            if (node.left == null && node.right == null) {
                s += Integer.parseInt(sum);
                return;
            }
            if (node.left != null)
                dfs(node.left, sum + node.left.val);
            if (node.right != null)
                dfs(node.right, sum + node.right.val);

        }
    }
}
