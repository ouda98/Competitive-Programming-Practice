package CP_9_18_LowestCommonAncestor;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        static boolean v1;
        static boolean v2;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            v1 = false;
            v2 = false;
            TreeNode s = lca(root, p, q);
            if (v1 && v2)
                return s;
            return null;

        }

        public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            TreeNode temp = null;
            if (root == p) {
                v1 = true;
                temp = root;
            }
            if (root == q) {
                v2 = true;
                temp = root;
            }

            TreeNode left = lca(root.left, p, q);
            TreeNode right = lca(root.right, p, q);

            if (temp != null)
                return temp;

            if (left != null && right != null)
                return root;

            return (left != null) ? left : right;

        }
    }
}
