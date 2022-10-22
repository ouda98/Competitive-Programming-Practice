package LeetCodeCommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,3};
        int [] arr = intersect(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                list.add(nums2[i]);
                if(map.get(nums2[i])>1){
                    map.put(nums2[i], map.get(nums2[i])-1);
                }else{
                    map.remove(nums2[i]);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++)
            result[i] = list.get(i);
        return result;
    }
}
