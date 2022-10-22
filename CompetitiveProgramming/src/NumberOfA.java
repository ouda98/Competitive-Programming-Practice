public class NumberOfA {
    public int countA(String s) {
        // Write your code here
        int start = binarySearch1(s,0,s.length()-1);
        if(start == -1)
            return 0;
        int end = binarySearch2(s,start,s.length()-1);
        return end - start +1;
    }
    public int binarySearch1(String s, int start, int end){
        int result = -1;
        while(start<=end){
            int mid = start + (end -start)/2;
            if(s.charAt(mid)=='A'){
                result = mid;
                end = mid-1;
            }else if(s.charAt(mid) == 'B')
                start = mid+1;
            else
                end = mid-1;
        }
        return result;
    }
    public int binarySearch2(String s, int start, int end){
        int result = -1;
        while(start<=end){
            int mid = start + (end -start)/2;
            if(s.charAt(mid)=='A'){
                result = mid;
                start = mid+1;
            }else if(s.charAt(mid) == 'B')
                start = mid+1;
            else
                end = mid-1;
        }
        return result;
    }
}
