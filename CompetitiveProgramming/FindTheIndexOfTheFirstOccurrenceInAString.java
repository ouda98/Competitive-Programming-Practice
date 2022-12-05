public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {

    }
    //Solution 1
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public int strStr1(String haystack, String needle) {
        for(int i=0;i<haystack.length()-needle.length()+1;i++)
            if(haystack.substring(i,needle.length()+i).equals(needle))
                return i;
        return -1;
    }


}
