public class ConstructStringFromBinaryTree {
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
    static StringBuilder s;
    public String tree2str(TreeNode t) {
        s = new StringBuilder();
        find(t);
        return s.toString();

    }
    public void find(TreeNode root){
        if(root == null){
            return;
        }
        s.append(root.val);
        if(!(root.left == null && root.right == null)){
            s.append("(");
            find(root.left);
            s.append(")");
        }
        if(root.right == null)
            return;
        s.append("(");
        find(root.right);
        s.append(")");
    }
}
