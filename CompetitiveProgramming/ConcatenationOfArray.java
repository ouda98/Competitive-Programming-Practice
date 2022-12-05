public class ConcatenationOfArray {
    public static void main(String[] args) {

    }
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        int i=0;
        for(int n:nums){
            res[i+nums.length] = n;
            res[i++] = n;
        }
        return res;
    }
}
