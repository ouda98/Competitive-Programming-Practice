package LeetCodeCommonProblems;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] result = new int [nums1.length];
        int c1 = 0;
        int c2 = 0;
        int counter = 0;
        while(c1<m && c2<n){
            if(nums1[c1]<=nums2[c2])
                result[counter++] = nums1[c1++];
            else
                result[counter++] = nums2[c2++];
        }
        while(c1<m)
            result[counter++] = nums1[c1++];
        while(c2<n)
            result[counter++] = nums2[c2++];

        for(int i=0;i<result.length;i++){
            nums1[i] = result[i];
        }
    }
}
