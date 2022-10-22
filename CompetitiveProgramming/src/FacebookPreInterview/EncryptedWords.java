package FacebookPreInterview;

public class EncryptedWords {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(findEncryptedWord(s));

    }
    static String findEncryptedWord(String s) {
        // Write your code here
        return solve(s,0,s.length()-1);

    }

    static String solve(String s, int  start, int end){
        if(start == end)
            return s.charAt(start)+"";
        if(start+1==end)
            return s.charAt(start)+""+s.charAt(end);

        int  mid = start + (int) Math.floor((end - start) / 2.0);
        String res = s.charAt(mid)+""+ solve(s,start,mid-1) +""+ solve(s,mid+1,end);

        return res;

    }

}
