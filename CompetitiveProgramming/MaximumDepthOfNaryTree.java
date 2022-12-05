import java.util.List;

public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        return dfs(root)+1;
    }
    public int dfs(Node root){
        int max = 0;
        for(Node n : root.children)
            max = Math.max(max,1+dfs(n));
        return max;
    }
}
