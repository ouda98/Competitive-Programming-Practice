package LeetCodeCommonProblems;

public class MaximumDepthOfBinaryTree {
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


    static int max;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        max = 0;
        solve(root, 1);
        return max;
    }

    public void solve(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            max = Math.max(max, sum);
            return;
        }

        if (root.right != null)
            solve(root.right, sum + 1);
        if (root.left != null)
            solve(root.left, sum + 1);
    }
}
