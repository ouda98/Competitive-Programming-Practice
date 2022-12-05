public class SumOfRootToLeafBinaryNumbers {
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

    static int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, ""+root.val);
        return sum;
    }
    public void dfs(TreeNode root, String s){
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(s,2);
            return;
        }
        if(root.left != null)
            dfs(root.left,s+root.left.val);
        if(root.right != null)
            dfs(root.right,s+root.right.val);
    }
}
