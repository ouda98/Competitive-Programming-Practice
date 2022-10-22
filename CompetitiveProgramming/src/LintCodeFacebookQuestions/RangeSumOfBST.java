package LintCodeFacebookQuestions;

public class RangeSumOfBST {

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
         * @param root: the root node
         * @param L: an integer
         * @param R: an integer
         * @return: the sum
         */
        public int rangeSumBST(TreeNode root, int L, int R) {
            // write your code here.
            return findSum(root,L,R);
        }
        static int findSum(TreeNode root, int L, int R){
            if(root == null)
                return 0;
            int sum =0;
            if(root.val>=L && root.val<=R)
                sum+=root.val;
            if(root.val<L && root.right!=null)
                sum+=findSum(root.right, L,R);
            else if(root.val>R && root.left!=null)
                sum+= findSum(root.left,L,R);
            else{

                if(root.right!=null)
                    sum+=findSum(root.right, L,R);
                if(root.left!=null)
                    sum+= findSum(root.left,L,R);

            }

            return sum;


        }
    }
}
