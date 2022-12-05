import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {

    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(arr[mid] == x){
                left = mid+1;
            }
            if(arr[mid] < x)
                left = mid+1;
            else
                right = mid-1;
        }
        left = Math.min(left,right);
        right = left+1;
        while(k >0){
            if(left>=0 && right< arr.length){
                if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                    result.add(arr[left]);
                    left--;
                }else{
                    result.add(arr[right]);
                    right++;
                }
                k--;
            }else if(left>=0){
                result.add(arr[left]);
                left--;
                k--;
            }else if(right< arr.length){
                result.add(arr[right]);
                right++;
                k--;
            }
        }
        Collections.sort(result);
        return result;
    }
}
