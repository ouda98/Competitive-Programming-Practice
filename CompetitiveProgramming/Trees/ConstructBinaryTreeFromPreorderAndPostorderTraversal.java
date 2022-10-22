package Trees;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Solution {
        static int preIndex;
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            // write your code here

            preIndex = 0;
            TreeNode r = build(pre, post,0,post.length-1);
            return r;

        }
        public static TreeNode build(int []pre, int []post, int start, int end){
            if(start > end)
                return null;

            TreeNode node = new TreeNode(pre[preIndex]);
            preIndex++;
            int idx = 0;
            for(int i=idx;i<=end;i++){
                if(post[i] == pre[preIndex])
                    break;
            }
            node.left = build(pre,post,start, idx);
            node.right = build(pre,post,idx+1, end-1);
            return node;
        }
    }
}
