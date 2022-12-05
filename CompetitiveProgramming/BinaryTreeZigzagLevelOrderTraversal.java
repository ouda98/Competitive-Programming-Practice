import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> r = new ArrayList<>();
        TreeNode current;
        int zigzag = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=size;i>0;i--){
                r.add(q.peek().val);
                current = q.poll();
                zig(current, zigzag,q);
            }
            if(zigzag%2==0)
                Collections.reverse(r);
            result.add(r);
            r = new ArrayList<>();
            zigzag++;
        }
        return result;
    }
    public void zig(TreeNode current, int zigzag, Queue q){
        if(current.left!=null)
            q.add(current.left);
        if(current.right!=null)
            q.add(current.right);
    }
}
