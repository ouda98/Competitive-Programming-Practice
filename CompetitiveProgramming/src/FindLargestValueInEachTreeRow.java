import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
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
         * @param root: a root of integer
         * @return: return a list of integer
         */
        public List<Integer> largestValues(TreeNode root) {
            // write your code here
            List<Integer> result = new ArrayList<>();
            if (root == null)
                return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode top = q.poll();
                    max = Math.max(max, top.val);
                    if (top.left != null)
                        q.add(top.left);
                    if (top.right != null)
                        q.add(top.right);
                }
                result.add(max);
            }
            return result;
        }
    }
}
