package Trees;

public class IncreasingOrderSearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public class Solution {
        /**
         * @param root: a binary search tree
         * @return: Root of a tree
         */
        static TreeNode r;

        public TreeNode increasingBST(TreeNode root) {
            // Write your code here.
            r = new TreeNode(0);
            TreeNode s = r;
            traverse(root);
            return s.right;
        }

        public static void traverse(TreeNode root) {
            if (root.left != null)
                traverse(root.left);
            r.right = new TreeNode(root.val);
            r = r.right;
            if (root.right != null)
                traverse(root.right);
        }
    }
}
