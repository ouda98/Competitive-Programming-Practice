public class LowestCommonAncestorII {
    public static void main(String[] args) {

    }

    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }


    public class Solution {
        public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
            // write your code here
            if (root == null)
                return null;

            if (root == A || root == B)
                return root;

            ParentTreeNode left = lowestCommonAncestorII(root.left, A, B);
            ParentTreeNode right = lowestCommonAncestorII(root.right, A, B);
            if (left != null && right != null)
                return root;

            return (left != null) ? left : right;
        }
    }
}
