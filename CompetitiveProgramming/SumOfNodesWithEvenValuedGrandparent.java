public class SumOfNodesWithEvenValuedGrandparent {
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
    static int sum;
    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        dfs(root, false, false);
        return sum;
    }
    public void dfs(TreeNode root,boolean grandParent, boolean parent){
        if(root == null)
            return;
        if(grandParent)
            sum+=root.val;
        dfs(root.left,parent,root.val%2==0);
        dfs(root.right,parent,root.val%2==0);
    }
}
