import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {
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

    //Solution 1 SC O(1)

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //Solution 2 SC O(n)

    ArrayList<Integer> result;
    public void flatten1(TreeNode root) {
        if(root == null)
            return;
        result = new ArrayList<>();
        dfs(root);
        TreeNode current = root;
        for(int i=1;i<result.size();i++){
            current.right = new TreeNode(result.get(i));
            current.left = null;
            current = current.right;
        }
        root = new TreeNode(5);

    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        result.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
