public class CountGoodNodesInBinaryTree {
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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int max){
        if(root == null)
            return 0;
        return ((max<=root.val)? 1:0) + dfs(root.left, Math.max(max,root.val)) + dfs(root.right, Math.max(max,root.val));
    }
}
