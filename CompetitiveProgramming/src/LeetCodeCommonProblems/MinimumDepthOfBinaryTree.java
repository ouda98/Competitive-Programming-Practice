package LeetCodeCommonProblems;

public class MinimumDepthOfBinaryTree {
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

    int min;

    public int minDepth(TreeNode root) {
        min = Integer.MAX_VALUE;
        if (root == null)
            return 0;

        solve(root, 1);
        return min;
    }

    public void solve(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            min = Math.min(min, level);
            return;
        }
        if (root.left != null)
            solve(root.left, level + 1);
        if (root.right != null)
            solve(root.right, level + 1);
    }
}
