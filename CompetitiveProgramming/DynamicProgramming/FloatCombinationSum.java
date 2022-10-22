package DynamicProgramming;

import java.util.HashMap;

public class FloatCombinationSum {
    public static void main(String[] args) {
//        double[] arr = {5.1,25.1,33.2,60.6,7.8,59.9,54.3,34.1,60.3,66.9,85.8,96.3,78.5,6.9,4.8,48.7,26.8,22.3,95.2,24.0,41.1,37.8,15.6,33.6,81.8,49.3,87.6,32.9,47.3,58.7,98.5,72.2,52.8,69.8,97.9,8.0,80.3,65.8,26.5,65.1,26.9,98.1,30.9,27.2,22.4,55.7,63.6,31.6,11.4,43.9,13.0,47.9,41.5,37.0,93.5,55.9,33.2,96.4,26.4,24.8,38.1,5.9,16.1,79.1,25.7,83.4,34.1,61.1,0.4,75.1,64.9,72.1,48.8,14.0,9.7,54.2,67.0,10.6,49.9,49.4,34.5,64.0,30.2,94.5,83.5,83.5,21.6,69.1,78.8,80.0,55.7,77.4,14.7,66.1,89.9,4.2,27.9,83.8,15.8,62.8};
        double[] arr = {1.2,1.3,2.3,4.2};
        int target = 9;
        getArray(arr, target);
    }
    static HashMap<String, Integer> dp;
    static int[] result;
    static int counter;
    public static int[] getArray(double[] A, int target) {
        // write your code here
        counter = 0;
        result = new int[A.length];
        dp = new HashMap<>();
        int r = solve(A, target, 0, 0);
        trace(A,target,0,0);
        return result;
    }
    public static int solve(double []arr, int target, int idx, int adj){
        if(idx == arr.length && target ==0){
            return adj;
        }
        if(idx == arr.length || target<0)
            return 0;
        if(dp.containsKey(target+" "+idx+" "+adj))
            return dp.get(target+" "+idx+" "+adj);

        String s = ""+arr[idx];
        int floor = solve(arr,target- ((int)Math.floor(arr[idx])),idx+1,adj+(s.charAt(s.length()-1)-'0'));

        s = ""+arr[idx];
        int ceil = solve(arr,target- ((int)Math.ceil(arr[idx])),idx+1,adj+('9'-s.charAt(s.length()-1)+1));
        int min = 0;
        if(floor!=0 && ceil!=0)
            min = Math.min(floor,ceil);
        else if(floor!=0)
            min = floor;
        else
            min = ceil;
        dp.put(target+" "+idx+" "+adj, min);
        return min;
    }
    public static void trace(double []arr, int target, int idx, int adj){
        if(idx == arr.length && target ==0){
            return;
        }
        if(idx == arr.length || target<0)
            return;


        String s = ""+arr[idx];
        int floor = solve(arr,target- ((int)Math.floor(arr[idx])),idx+1,adj+(s.charAt(s.length()-1)-'0'));

        s = ""+arr[idx];
        int ceil = solve(arr,target- ((int)Math.ceil(arr[idx])),idx+1,adj+('9'-s.charAt(s.length()-1)+1));
        int r = dp.get(target+" "+idx+" "+adj);
        if(floor == r) {
            result[counter++] = (int)Math.floor(arr[idx]);
            trace(arr, target - ((int) Math.floor(arr[idx])), idx + 1, adj + (s.charAt(s.length() - 1) - '0'));
        }
        else {
            result[counter++] = (int)Math.ceil(arr[idx]);
            trace(arr,target- ((int)Math.ceil(arr[idx])),idx+1,adj+('9'-s.charAt(s.length()-1)+1));
        }

    }
}
