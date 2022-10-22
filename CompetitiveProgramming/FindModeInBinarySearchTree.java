import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindModeInBinarySearchTree {

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
         * @param root: a root of integer
         * @return: return a integer list
         */
        static HashMap<Integer, Integer> map;

        public int[] findMode(TreeNode root) {
            // write your code here
            map = new HashMap<>();
            int max = 0;
            dfs(root);
            List<Integer> result = new ArrayList<>();
            for (Integer i : map.keySet()) {
                if (map.get(i) > max) {
                    result.clear();
                    max = map.get(i);
                    result.add(i);
                } else if (map.get(i) == max)
                    result.add(i);

            }
            return result.stream().mapToInt(i -> i).toArray();

        }

        public static void dfs(TreeNode root) {
            if (root == null)
                return;

            dfs(root.left);
            if (map.containsKey(root.val))
                map.put(root.val, map.get(root.val) + 1);
            else
                map.put(root.val, 1);

            dfs(root.right);
        }
    }
}
