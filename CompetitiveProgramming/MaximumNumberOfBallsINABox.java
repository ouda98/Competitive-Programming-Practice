import java.util.HashMap;

public class MaximumNumberOfBallsINABox {
    public static void main(String[] args) {

    }
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=lowLimit;i<=highLimit;i++){
            int box = getBox(i);
            map.put(box, map.getOrDefault(box,0)+1);
            if(map.get(box)>max)
                max = map.get(box);
        }
        return max;
    }
    public int getBox(int n){
        int sum = 0;
        while(n>0){
            sum+= (n%10);
            n/=10;
        }
        return sum;
    }
}
