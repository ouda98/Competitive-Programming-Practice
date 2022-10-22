package CP_9_18_LowestCommonAncestor;

public class LowestCommonAncestorOfABinarySearchTreeLintCode {

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
         * @param root: root of the tree
         * @param p: the node p
         * @param q: the node q
         * @return: find the LCA of p and q
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // write your code here
            if(root == null)
                return null;

            if(root == p || root == q){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right, p,q);

            if(left != null && right != null)
                return root;

            return (left!=null)? left: right;
        }
    }
}
