public class DeepestLeavesSum {
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

    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode current = root;
        return findSum(root, dfs(current));
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(dfs(root.left)+1,dfs(root.right)+1);
    }
    public int findSum(TreeNode root, int depth){
        if(root == null)
            return 0;
        if(depth == 1)
            return root.val;
        return findSum(root.left, depth-1) + findSum(root.right, depth-1);
    }
}
