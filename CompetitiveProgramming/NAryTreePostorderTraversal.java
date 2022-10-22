import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<UndirectedGraphNode>();
     }
 }
    public static void main(String[] args) {
    }
        static List<Integer> s;
        public List<Integer> postorder(UndirectedGraphNode root) {
            // write your code here
            s = new ArrayList<>();
            find(root);
            return s;
        }
        public void find(UndirectedGraphNode root) {
            if (root == null)
                return;
            for (UndirectedGraphNode n : root.neighbors) {
                find(n);
            }
            s.add(root.label);
        }

}
