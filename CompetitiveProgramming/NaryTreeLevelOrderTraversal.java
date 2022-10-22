import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<UndirectedGraphNode>();
        }
 }
    public List<List<Integer>> levelOrder(UndirectedGraphNode root) {
        // write your code here
        List<List<Integer>> se = new ArrayList<>();
        UndirectedGraphNode r = root;

        if(root == null)
            return se;
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(root);
        q.add(new UndirectedGraphNode(-1));
        List<Integer> s = new ArrayList<>();
        while(!q.isEmpty()){
            if(q.peek().label == -1){
                q.remove();
                if(s.size()>=1){
                    se.add(new ArrayList<Integer>(s));
                    s = new ArrayList<>();
                    q.add(new UndirectedGraphNode(-1));
                }
                continue;
            }
            r = q.peek();
            s.add(q.remove().label);
            for(UndirectedGraphNode l : r.neighbors){
                if(l.label == -1)
                    continue;
                q.add(l);
            }
            r.label = -1;
        }
        return se;
    }
}
