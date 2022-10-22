import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return isSymmetricHelper(root.left, root.right);
//    }
//
//    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
//        if (left == null && right != null) return false;
//        if (right == null && left != null) return false;
//        if (left == null && right == null) return true;
//        if (left.val != right.val) return false;
//
//        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
//    }

    public class Solution {
        /**
         * @param root: root of the given tree
         * @return: whether it is a mirror of itself
         */
        static List<Pair> p;

        public boolean isSymmetric(TreeNode root) {
            // Write your code here
            p = new ArrayList<>();
            if (root == null)
                return true;
            dfs(root, 0);
            int left = 0;
            int right = p.size() - 1;
            while (left <= right) {
                if (p.get(left).val != p.get(right).val || p.get(left).level != p.get(right).level)
                    return false;
                left++;
                right--;
            }
            return true;
        }
        public static void dfs(TreeNode root, int level) {
            if (root.left == null && root.right == null) {
                p.add(new Pair(root.val, level));
                return;
            }
            if (root.left != null)
                dfs(root.left, level + 1);
            p.add(new Pair(root.val, level));
            if (root.right != null)
                dfs(root.right, level + 1);
        }
        public static class Pair {
            int val;
            int level;
            public Pair(int val, int level) {
                this.val = val;
                this.level = level;
            }
        }
    }
}
