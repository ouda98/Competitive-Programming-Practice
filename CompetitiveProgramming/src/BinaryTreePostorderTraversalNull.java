import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversalNull {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    static List<Integer> s;
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        s = new ArrayList<>();
        find(root);
        return s;
    }
    public void find(TreeNode root){
        if(root == null)
            return;
        find(root.left);
        find(root.right);
        s.add(root.val);
    }
}
