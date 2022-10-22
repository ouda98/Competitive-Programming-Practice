package LintCodeFacebookQuestions;

public class LeafSimilarTrees {
     public class TreeNode {
         public int val;
         public TreeNode left, right;
         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
     }

    public class Solution {
        /**
         * @param root1: the first tree
         * @param root2: the second tree
         * @return: returns whether the leaf sequence is the same
         */
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            // write your code here.
            String s1 = solve(root1);
            String s2 = solve(root2);
            if(s1.equals(s2))
                return true;
            return false;
        }

        public static String solve(TreeNode root){
            if(root==null)
                return "";

            String res = "";

            if(root.left == null && root.right == null)
                res+= ""+root.val;
            res+= ""+solve(root.left);
            res+= ""+solve(root.right);

            return res;
        }
    }
}
