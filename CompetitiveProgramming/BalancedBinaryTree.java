import java.util.HashSet;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isBalanced(TreeNode root) {
        return dfs(root, 0)==-1?false:true;
    }
    public int dfs(TreeNode root, int level){
        if(root == null){
            return level;
        }
        int left = dfs(root.left,level+1);
        int right = dfs(root.right, level+1);
        if(left < 0 || right < 0 || Math.abs(left-right) > 1) return -1;

        return Math.max(left, right);
    }
}
