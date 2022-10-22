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
