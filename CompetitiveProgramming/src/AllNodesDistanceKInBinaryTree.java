import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTree {
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
         * @param root:   the root of the tree
         * @param target: the target
         * @param K:      the given K
         * @return: All Nodes Distance K in Binary Tree
         */
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            // Write your code here
            if (root == null)
                return new ArrayList<Integer>();
            List<Pair> nodes = new ArrayList<>();
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, ""));
            Pair wanted = null;
            while (!q.isEmpty()) {
                Pair top = q.poll();
                nodes.add(top);
                if (top.node == target)
                    wanted = top;
                if (top.node.left != null) {
                    q.add(new Pair(top.node.left, top.route + 'l'));
                }
                if (top.node.right != null) {
                    q.add(new Pair(top.node.right, top.route + 'r'));
                }
            }
            if (wanted == null)
                return new ArrayList<Integer>();
            int count = 0;
            List<Integer> result = new ArrayList<>();
            for (Pair p : nodes) {
                count = 0;
                count += Math.abs(wanted.route.length() - p.route.length());
                if (count > K)
                    continue;
                for (int j = 0; j < Math.min(wanted.route.length(), p.route.length()); j++) {
                    if (wanted.route.charAt(j) != p.route.charAt(j)) {
                        count += (2 * Math.min(wanted.route.length(), p.route.length())) - (j * 2);
                        break;
                    }
                }
                if (K == count)
                    result.add(p.node.val);

            }
            return result;

        }

        public static class Pair {
            TreeNode node;
            String route;

            public Pair(TreeNode node, String route) {
                this.route = route;
                this.node = node;
            }

            public String toString() {
                return node.val + " " + route;
            }
        }
    }
}
