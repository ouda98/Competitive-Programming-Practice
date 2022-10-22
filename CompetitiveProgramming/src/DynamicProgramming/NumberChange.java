package DynamicProgramming;

import java.util.HashMap;

public class NumberChange {
    public static void main(String[] args) {
        int answer = numberChange(18016);
        System.out.println(answer);

    }
    static HashMap<String, Integer> map;
    static int i;
    public static int numberChange(int k) {
        // write your code here
        map = new HashMap<>();
        return solve(k,0);
    }
    public static int solve(int k,int counter){
        if(k == 0){
            return counter;
        }
        if(k<0)
            return 0;

        if(map.containsKey(k+" "+counter))
            return map.get(k+" "+counter);

        int left =-1;
        int right = -1;
        if(k%2==0)
            left = solve(k/2,counter+1);
        if(k%2==1)
            right = solve(k-1, counter+1);
        if(left!=-1 && right!=-1)
            map.put(k+" "+counter,Math.min(left, right));
        if(left==-1)
            map.put(k+" "+counter,right);
        else
            map.put(k+" "+counter,left);
        return map.get(k+" "+counter);

    }
}
