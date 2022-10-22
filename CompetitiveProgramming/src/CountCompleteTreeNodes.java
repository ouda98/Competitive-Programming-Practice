public class CountCompleteTreeNodes {
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
         * @param root: root of complete binary tree
         * @return: the number of nodes
         */
        public int countNodes(TreeNode root) {
            // write your code here
            return solve(root) + 1;
        }

        public int solve(TreeNode root) {
            // write your code here
            if (root.left == null && root.right == null)
                return 0;
            int a = 0;
            if (root.left != null)
                a += 1 + solve(root.left);
            if (root.right != null)
                a += 1 + solve(root.right);
            return a;
        }
    }
}
