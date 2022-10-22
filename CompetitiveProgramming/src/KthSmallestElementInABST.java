public class KthSmallestElementInABST {

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
         * @param root: the given BST
         * @param k: the given k
         * @return: the kth smallest element in BST
         */
        static int r;
        static int counter;

        public int kthSmallest(TreeNode root, int k) {
            // write your code here
            counter = 0;
            r = -1;
            dfs(root, k);
            return r;
        }

        public static void dfs(TreeNode root, int k) {

            if (r != -1)
                return;
            if (root == null) {
                return;
            }
            dfs(root.left, k);
            counter++;
            if (counter == k)
                r = root.val;
            dfs(root.right, k);

        }
    }
}
