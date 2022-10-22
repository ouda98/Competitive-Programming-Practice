import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThrowGarbage {
    public static void main(String[] args) {
        float[] arr = {2.82f,1.08f,2.07f,2.9f,1.95f,1.04f,2.5f,2.54f,1.28f,1.91f};
        int r = Count_ThrowTimes(arr);
        System.out.println(r);

    }
    public static int Count_ThrowTimes(float[] BagList) {
        List<Float> list = new ArrayList<>();
        for(float f : BagList)
            list.add(f);
        Collections.sort(list);
        int counter = 0;
        while(!list.isEmpty()){
            int result = binarySearch(list,3.0-list.get(0),1,list.size()-1);
            if(result != -1)
                list.remove(result);
            list.remove(0);
            counter++;
        }
        return counter;
    }
    public static int binarySearch(List<Float> list, double target, int start, int end){
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(list.get(mid)<=target){
                result = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }
}
