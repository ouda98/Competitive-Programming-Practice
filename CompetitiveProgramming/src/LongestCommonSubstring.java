public class LongestCommonSubstring {
    public static void main(String[] args) {
        int a = longestCommonSubstring("ABCD","CBCE");
        System.out.println(a);
    }
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A.length()==0 || B.length()==0)
            return 0;
        int max =0;

        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                if(A.charAt(i) == B.charAt(j)){
                    int counter = 0;
                    int ca = i;
                    int cb = j;
                    while(ca<A.length() && cb<B.length()){
                        if(A.charAt(ca) == B.charAt(cb)){
                            counter++;
                        }else
                            break;
                        ca++;
                        cb++;

                    }
                    j = cb;
                    if(max<counter)
                        max = counter;
                }
            }
        }
        return max;
    }
}
