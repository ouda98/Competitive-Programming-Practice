import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

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
         * @param root: the root
         * @return: the minimum absolute difference between values of any two nodes
         */
        //Solution 1 no extra space only one pass
        static int min;
        static int prev;
        public int getMinimumDifference(TreeNode root) {
            min = Integer.MAX_VALUE;
            prev = Integer.MAX_VALUE;
            dfs(root);
            return min;
        }
        public void dfs(TreeNode root){
            if(root == null)
                return;
            dfs(root.left);
            min = Math.min(min, Math.abs(prev-root.val));
            prev = root.val;
            dfs(root.right);
        }


        static List<Integer> nums;

        public int getMinimumDifference1(TreeNode root) {
            // Write your code here
            nums = new ArrayList<>();
            dfs1(root);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.size() - 1; i++)
                if (min > nums.get(i + 1) - nums.get(i))
                    min = nums.get(i + 1) - nums.get(i);
            return min;
        }

        public static void dfs1(TreeNode root) {
            if (root.left == null && root.right == null) {
                nums.add(root.val);
                return;
            }
            if (root.left != null)
                dfs1(root.left);
            nums.add(root.val);
            if (root.right != null)
                dfs1(root.right);
        }

    }
}
