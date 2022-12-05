import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] longer;
        int[] shorter;
        ArrayList<Integer> result = new ArrayList<>();
        if(nums1.length > nums2.length){
            longer = nums1;
            shorter = nums2;
        }else{
            longer = nums2;
            shorter = nums1;
        }
        Arrays.sort(longer);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<shorter.length;i++){
            if(set.contains(shorter[i]))
                continue;
            set.add(shorter[i]);
            if(bs(longer, shorter[i]))
                result.add(shorter[i]);

        }
        int[] res = new int[result.size()];
        int i=0;
        for(int n : result)
            res[i++] = n;
        return res;

    }
    public boolean bs(int[] longer, int target){
        int left = 0;
        int right = longer.length-1;
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(longer[mid] == target)
                return true;
            else if(longer[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}
