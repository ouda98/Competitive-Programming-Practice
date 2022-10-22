import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

     public class TreeNode {
         public int val;
         public TreeNode left, right;
         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
     }

        static List<Integer> s;
        public List<Integer> inorderTraversal(TreeNode root) {
            // write your code here
            s = new ArrayList<>();
            find(root);
            return s;
        }
        public void find(TreeNode root){
            if(root == null)
                return;
            find(root.left);
            s.add(root.val);
            find(root.right);
        }


}
