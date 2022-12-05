import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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
    static List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root,root.val+ "->");
        return result;
    }
    public void dfs(TreeNode root, String s){
        if(root.left == null && root.right == null){
            result.add(s.substring(0,s.length()-2));
            return;
        }
        if(root.left!=null)
            dfs(root.left, s+root.left.val+"->");
        if(root.right!=null)
            dfs(root.right, s+root.right.val+"->");
    }
}
