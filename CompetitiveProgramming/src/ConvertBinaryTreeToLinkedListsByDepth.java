import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertBinaryTreeToLinkedListsByDepth {
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
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
        //Assuming positive numbers
        public List<ListNode> binaryTreeToLists(TreeNode root) {
            // Write your code here
            List<ListNode> result = new ArrayList<>();
            ListNode subResult = null;
            ListNode current = subResult;
            Queue<TreeNode> q = new LinkedList<>();
            if(root == null)
                return result;
            q.add(root);
            q.add(new TreeNode(-1));
            while(!q.isEmpty()){
                if(q.peek().val == -1){
                    q.remove();
                    result.add(subResult);
                    subResult = current = null;
                    if(q.isEmpty())
                        break;
                    q.add(new TreeNode(-1));
                    continue;
                }
                if(subResult == null){
                    subResult = new ListNode(q.peek().val);
                    current = subResult;
                }else{
                    current.next = new ListNode(q.peek().val);
                    current = current.next;
                }
                TreeNode s = q.remove();
                if(s.left !=null)
                    q.add(s.left);
                if(s.right !=null)
                    q.add(s.right);
            }
            return result;
        }
}
