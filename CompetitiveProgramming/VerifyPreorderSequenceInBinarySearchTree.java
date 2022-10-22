import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param preorder: List[int]
         * @return: return a boolean
         */
        public boolean verifyPreorder(int[] preorder) {
            // write your code here
            return dfs(preorder,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        public static boolean dfs(int []preorder,int idx, int min, int max){
            if(idx == preorder.length)
                return true;

            int val = preorder[idx];

            if(!(val>min && val<max)) return false;

            return dfs(preorder, idx+1, val, max) || dfs(preorder, idx+1, min, val);

        }
    }
}
