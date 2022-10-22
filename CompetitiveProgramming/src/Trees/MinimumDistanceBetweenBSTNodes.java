package Trees;

import java.util.ArrayList;

public class MinimumDistanceBetweenBSTNodes {
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
         * @param root:  a Binary Search Tree (BST) with the root node
         * @return: the minimum difference
         */
        static ArrayList<Integer> s;

        public int minDiffInBST(TreeNode root) {
            // Write your code here.
            int min = (int) 1e9;
            s = new ArrayList<>();
            traverse(root);

            for (int i = 0; i < s.size() - 1; i++)
                if (min > Math.abs(s.get(i) - s.get(i + 1)))
                    min = Math.abs(s.get(i) - s.get(i + 1));

            return min;
        }

        public static void traverse(TreeNode root) {
            if (root.left != null) {
                traverse(root.left);
            }
            s.add(root.val);
            if (root.right != null) {
                traverse(root.right);
            }
        }
    }
}