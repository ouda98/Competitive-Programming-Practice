public class PathSum {
     public class TreeNode {
         public int val;
         public TreeNode left, right;
         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
     }

    public static void main(String[] args) {

    }
    //Solution 1
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if(targetSum == root.val && root.left == null && root.right==null)
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    //Solution 2
    static boolean result;
    public boolean pathSum(TreeNode root, int sum) {
        result = false;
        TreeNode n = root;
        if(n==null)
            return sum == 0;
        find(n,sum-n.val);
        return result;
    }
    public void find(TreeNode n, int sum){
        if(n.left == null && n.right == null)
            result |= (sum == 0);
        if(n.left!=null)
            find(n.left, sum - n.left.val);
        if(n.right !=null)
            find(n.right,sum-n.right.val);
    }
}
