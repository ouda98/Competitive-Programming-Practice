public class CountNodesEqualToAverageOfSubtree {
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
    static int result;
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }
    public Pair dfs(TreeNode root){
        if(root == null)
            return new Pair(0,0);
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if((root.val+left.x+right.x)/(1+left.y+right.y) == root.val)
            result++;
        return new Pair(root.val+left.x+right.x,1+left.y+right.y);
    }

    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
