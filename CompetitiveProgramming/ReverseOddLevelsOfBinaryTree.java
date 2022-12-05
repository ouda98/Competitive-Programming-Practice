public class ReverseOddLevelsOfBinaryTree {
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
    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode current = root;
        dfs(current.left, current.right,0);
        return root;
    }
    public void dfs(TreeNode left, TreeNode right, int level){
        if(left == null || right == null)
            return;
        if(level%2==0 && left !=null){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(left.left,right.right,level+1);
        dfs(left.right,right.left,level+1);
    }
}
