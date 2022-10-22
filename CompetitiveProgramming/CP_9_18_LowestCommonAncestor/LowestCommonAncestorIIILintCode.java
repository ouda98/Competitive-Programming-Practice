package CP_9_18_LowestCommonAncestor;

public class LowestCommonAncestorIIILintCode {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public class Solution {
        /*
         * @param root: The root of the binary tree.
         * @param A: A TreeNode
         * @param B: A TreeNode
         * @return: Return the LCA of the two nodes.
         */
        static boolean v1;
        static boolean v2;

        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
            // write your code here
            v1 = false;
            v2 = false;
            TreeNode lca = lca(root, A, B);
            if (v1 && v2)
                return lca;
            return null;

        }

        public static TreeNode lca(TreeNode node, TreeNode A, TreeNode B) {
            if (node == null)
                return null;

            TreeNode temp = null;
            if (node == A) {
                temp = node;
                v1 = true;
            }
            if (node == B) {
                temp = node;
                v2 = true;
            }
            TreeNode left = lca(node.left, A, B);
            TreeNode right = lca(node.right, A, B);

            if (temp != null)
                return temp;

            if (right != null && left != null)
                return node;
            return (left != null) ? left : right;
        }
    }
}
