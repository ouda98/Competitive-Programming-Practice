import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class ClosestNodesQueriesInABinarySearchTree {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
    }

    static TreeSet<Integer> set;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        set = new TreeSet<>();
        dfs(root);
        List<List<Integer>> result = new ArrayList<>();
        for(int q: queries){
            if(set.contains(q))
                result.add(new ArrayList<>(Arrays.asList(q,q)));
            else
                result.add(new ArrayList<>(Arrays.asList(set.lower(q)==null?-1:set.lower(q),set.higher(q)==null?-1:set.higher(q))));
        }
        return result;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        set.add(root.val);
        dfs(root.right);
    }
}
