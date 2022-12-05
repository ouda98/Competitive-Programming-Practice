import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode polled;
        ArrayList<Integer> subResult = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                polled = q.poll();
                subResult.add(polled.val);
                if (polled.left != null)
                    q.add(polled.left);
                if (polled.right != null)
                    q.add(polled.right);
            }
            result.add(subResult);
            subResult = new ArrayList<>();
        }
        Collections.reverse(result);
        return result;

    }
}
