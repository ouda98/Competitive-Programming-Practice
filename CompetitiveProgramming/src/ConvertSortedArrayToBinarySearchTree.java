public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
    }

    public class Solution {
        /**
         * @param nums: the sorted array
         * @return: the root of the tree
         */
        public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
            // Write your code here.
            if (nums.length == 0)
                return null;
            TreeNode root = solve(nums, 0, nums.length - 1);
            return root;
        }

        public static TreeNode solve(int[] nums, int start, int end) {
            if (start > end)
                return null;
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = solve(nums, start, mid - 1);
            root.right = solve(nums, mid + 1, end);
            return root;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
