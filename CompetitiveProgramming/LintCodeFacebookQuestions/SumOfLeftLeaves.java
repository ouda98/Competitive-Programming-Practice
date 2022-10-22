package LintCodeFacebookQuestions;

public class SumOfLeftLeaves {

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
         * @param root: t
         * @return: the sum of all left leaves
         */
        public int sumOfLeftLeaves(TreeNode root) {
            // Write your code here
            if(root== null || (root.right == null && root.left==null))
                return 0;
            return solve(root);
        }

        public static int solve (TreeNode root){
            if(root.left== null && root.right==null)
                return root.val;

            int s = 0;
            if(root.left!=null)
                s+=solve(root.left);
            if(root.right !=null && (root.right.left!=null || root.right.right!=null))
                s+=solve(root.right);
            return s;
        }


    }
}
