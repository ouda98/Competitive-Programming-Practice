package LeetCodeCommonProblems;

public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static boolean valid;
    static long previous;

    public boolean isValidBST(TreeNode root) {
        previous = Long.MIN_VALUE;
        valid = true;
        solve(root);
        return valid;
    }

    public void solve(TreeNode root) {
        if (root == null)
            return;
        solve(root.left);
        if (root.val <= previous)
            valid = false;
        previous = root.val;
        solve(root.right);
    }
}
