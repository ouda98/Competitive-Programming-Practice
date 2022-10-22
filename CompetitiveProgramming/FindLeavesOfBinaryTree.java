import java.util.*;

public class FindLeavesOfBinaryTree {
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
        /*
         * @param root: the root of binary tree
         * @return: collect and remove all leaves
         */
        int dfs(TreeNode cur) {
            if (cur == null) {
                return 0;
            }
            int d = Math.max(dfs(cur.left), dfs(cur.right)) + 1;

            depth.putIfAbsent(d, new ArrayList<>());
            depth.get(d).add(cur.val);
            return d;
        }

        Map<Integer, List<Integer>> depth;

        public List<List<Integer>> findLeaves(TreeNode root) {
            // Write your code here
            List<List<Integer>> ans = new ArrayList<>();

            depth = new HashMap<>();
            int max_depth = dfs(root);

            for (int i = 1; i <= max_depth; i++) {
                ans.add(depth.get(i));
            }
            return ans;
        }
    }
}
