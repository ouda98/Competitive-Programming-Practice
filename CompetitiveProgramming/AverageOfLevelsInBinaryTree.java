import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
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
         * @param root: the binary tree of the  root
         * @return: return a list of double
         */
        public List<Double> averageOfLevels(TreeNode root) {
            // write your code here
            Queue<Pair> q = new LinkedList<>();
            List<Double> result = new ArrayList<>();
            result.add(root.val * 1.0);
            int depth = 0;
            int sum = 0;
            int count = 0;
            q.add(new Pair(root, depth));
            while (!q.isEmpty()) {
                Pair top = q.poll();
                if (top.level > depth) {
                    result.add(sum / (count * 1.0));
                    sum = 0;
                    count = 0;
                    depth++;
                }
                if (top.node.left != null) {
                    sum += top.node.left.val;
                    count++;
                    q.add(new Pair(top.node.left, top.level + 1));
                }

                if (top.node.right != null) {
                    sum += top.node.right.val;
                    count++;
                    q.add(new Pair(top.node.right, top.level + 1));
                }

            }
            return result;
        }

        public static class Pair {
            TreeNode node;
            int level;

            public Pair(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
    }
}
