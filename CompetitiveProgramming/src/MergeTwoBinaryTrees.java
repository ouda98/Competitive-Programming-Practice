public class MergeTwoBinaryTrees {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Write your code here
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode result = t1;
        build(t1, t2);
        return result;
    }

    public void build(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return;
        t1.val += t2.val;
        if (t1.left != null && t2.left != null) {
            build(t1.left, t2.left);
        }
        if (t1.left == null && t2.left != null) {
            t1.left = new TreeNode(0);
            build(t1.left, t2.left);
        }
        if (t1.left != null && t2.left == null) {
            t2.left = new TreeNode(0);
            build(t1.left, t2.left);
        }

        if (t1.right != null && t2.right != null) {
            build(t1.right, t2.right);
        }
        if (t1.right == null && t2.right != null) {
            t1.right = new TreeNode(0);
            build(t1.right, t2.right);
        }
        if (t1.right != null && t2.right == null) {
            t2.right = new TreeNode(0);
            build(t1.right, t2.right);
        }
    }
}
