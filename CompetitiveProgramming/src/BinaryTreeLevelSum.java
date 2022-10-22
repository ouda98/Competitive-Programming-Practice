import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelSum {
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
         * @param root:  the root of the binary tree
         * @param level: the depth of the target level
         * @return: An integer
         */
        public int levelSum(TreeNode root, int level) {
            // write your code here
            if (root == null)
                return 0;
            if (level == 1)
                return root.val;
            Queue<TreeNode> q = new LinkedList<>();
            int c = 0;
            q.add(root);
            int sum = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                c++;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
                if (c == level)
                    return sum;
                sum = 0;
            }
            return sum;
        }
    }
}
