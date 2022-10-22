public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {

    }
    public char nextGreatestLetter(String letters, char target) {
        // Write your code here
        int left = 0;
        int right = letters.length()-1;
        int subResult = -1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(letters.charAt(mid) == target){
                subResult = mid;
                left = mid+1;
            }
            else if(letters.charAt(mid)> target)
                right = mid -1;
            else
                left = mid +1;
        }
        if(subResult != -1){
            return letters.charAt((subResult+1) % letters.length());
        }
        return letters.charAt(left % letters.length());
    }
}
