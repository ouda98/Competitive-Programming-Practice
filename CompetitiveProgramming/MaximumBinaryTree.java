public class MaximumBinaryTree {
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
         * @param nums: an array
         * @return: the maximum tree
         */
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            // Write your code here
            return solve(nums, 0, nums.length - 1);
        }

        public TreeNode solve(int[] nums, int start, int end) {
            if (start > end)
                return null;

            if (start == end)
                return new TreeNode(nums[start]);
            int i = start;
            int max = Integer.MIN_VALUE;
            int pos = 0;
            for (; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    pos = i;
                }
            }

            TreeNode node = new TreeNode(nums[pos]);
            node.left = solve(nums, start, pos - 1);
            node.right = solve(nums, pos + 1, end);
            return node;
        }
    }
}
