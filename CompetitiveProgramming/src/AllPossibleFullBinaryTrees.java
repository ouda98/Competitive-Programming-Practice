import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        int n= 7;
        allPossibleFBT(n);
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        // write your code here.
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0)
            return ans;
        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for (TreeNode l : left)
                for (TreeNode r : right) {
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    ans.add(head);
                }

        }
        return ans;

    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
