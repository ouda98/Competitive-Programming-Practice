package LintCodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
         * @param root: a binary tree
         * @param sum: the sum
         * @return: the scheme
         */
        static List<List<Integer>> result;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            if (root == null)
                return new ArrayList<>();
            List<Integer> s = new ArrayList<>();
            s.add(root.val);
            solve(root, targetSum - root.val, s);
            return result;
        }

        public static void solve(TreeNode root, int targetSum, List<Integer> list) {
            if (root.left == null && root.right == null && targetSum == 0) {
                List<Integer> r = new ArrayList<>();
                for (Integer w : list)
                    r.add(w);
                result.add(r);
                return;
            }

            if (root.left != null) {
                list.add(root.left.val);
                solve(root.left, targetSum - root.left.val, list);
                list.remove(list.size() - 1);
            }

            if (root.right != null) {
                list.add(root.right.val);
                solve(root.right, targetSum - root.right.val, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
