package LeetCodeCommonProblems;

import java.util.ArrayList;

public class LowestCommonAncestorOfDeepestLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int max;
    static ArrayList<TreeNode> levelArr;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return root;
        levelArr = new ArrayList<>();
        max = -1;
        TreeNode traverse = root;
        lastLevel(traverse, 0);
        if (levelArr.size() == 1)
            return levelArr.get(0);

        for (TreeNode t : levelArr)
            System.out.println(t.val);

        return lowestCA(root);
    }

    public TreeNode lowestCA(TreeNode root) {
        if (root == null)
            return null;

        for (TreeNode t : levelArr)
            if (t == root)
                return root;

        TreeNode left = lowestCA(root.left);
        TreeNode right = lowestCA(root.right);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    public void lastLevel(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            if (level > max) {
                max = level;
                levelArr.clear();
                levelArr.add(node);
            } else if (max == level)
                levelArr.add(node);
            return;
        }
        if (node.left != null)
            lastLevel(node.left, level + 1);

        if (node.right != null)
            lastLevel(node.right, level + 1);
    }
}
