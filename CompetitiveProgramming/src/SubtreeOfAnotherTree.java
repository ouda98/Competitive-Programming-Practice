import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {

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
         * @param s: the s' root
         * @param t: the t' root
         * @return: whether tree t has exactly the same structure and node values with a subtree of s
         */
        List<TreeNode> equal;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            // Write your code here

            equal = new ArrayList();
            getRoot(s, t.val);
            if (equal.size() == 0)
                return false;
            for (TreeNode l : equal) {
                if (trace(l, t))
                    return true;
            }
            return false;
        }

        public boolean trace(TreeNode one, TreeNode two) {
            if (one == null && two != null)
                return false;
            if (one != null && two == null)
                return false;
            if (one == null && two == null)
                return true;
            if (one.val != two.val)
                return false;
            return trace(one.left, two.left) && trace(one.right, two.right);


        }

        public void getRoot(TreeNode s, int target) {
            if (s != null && s.val == target) {
                equal.add(s);
            }
            if (s == null)
                return;

            getRoot(s.left, target);
            getRoot(s.right, target);
        }
    }
}
