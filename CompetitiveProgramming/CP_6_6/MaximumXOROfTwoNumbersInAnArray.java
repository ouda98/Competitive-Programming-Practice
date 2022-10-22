package CP_6_6;

public class MaximumXOROfTwoNumbersInAnArray {
    public class Solution {
        /**
         * @param nums:
         * @return: the maximum result of ai XOR aj, where 0 ≤ i, j < n
         */
        public int findMaximumXOR(int[] nums) {
            // Write your code here
            root = new TrieNode();
            String[] binary = new String[nums.length];
            for(int i=0;i<binary.length;i++){
                String s = Integer.toBinaryString(nums[i]);
                while(s.length()<32){
                    s = "0" + s;
                }
                binary[i] = s;
                insert(s);
            }

            int max =0;
            for(int i=0;i<binary.length;i++){
                int res = search(binary[i]);
                if(max<res)
                    max = res;
            }
            return max;
        }
        static TrieNode root;

        public static class TrieNode{
            TrieNode [] children;

            public TrieNode(){
                children = new TrieNode[2];
                for(int i=0;i<children.length;i++)
                    children[i] = null;
            }
        }
        public static void insert(String key){
            int length = key.length();
            int index;
            TrieNode traverse = root;

            for(int level=0; level<length;level++){
                index = key.charAt(level) - '0';
                if(traverse.children[index] == null)
                    traverse.children[index] = new TrieNode();
                traverse = traverse.children[index];
            }
        }

        public static int search(String key){
            int length = key.length();
            int index;
            TrieNode traverse = root;
            String result = "";

            for(int level=0; level<length;level++){
                index = key.charAt(level) - '0';
                if(index == 0 && traverse.children[1] != null){
                    result+="1";
                    traverse = traverse.children[1];
                }
                else if (index == 1 && traverse.children[0] != null){
                    result+="1";
                    traverse = traverse.children[0];
                }else{
                    result+="0";
                    traverse = traverse.children[index];
                }
            }
            return Integer.parseInt(result,2);
        }
    }

}
