import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
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

    static List<Integer> s;

    public List<Integer> preorder(UndirectedGraphNode root) {
        // write your code here
        s = new ArrayList<>();
        find(root);
        return s;
    }

    public void find(UndirectedGraphNode root) {
        if (root == null)
            return;
        s.add(root.label);
        for (UndirectedGraphNode n : root.neighbors) {
            find(n);
        }
    }
}
