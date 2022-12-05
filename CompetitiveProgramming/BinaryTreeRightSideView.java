import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode polled;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                polled = q.poll();
                if(i==0)
                    result.add(polled.val);
                if(polled.right!=null)
                    q.add(polled.right);
                if(polled.left!=null)
                    q.add(polled.left);
            }
        }
        return result;
    }
}
