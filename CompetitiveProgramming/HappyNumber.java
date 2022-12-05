import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {

    }
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        while(n !=1){
            n = find(n);
            if(visited.contains(n))
                return false;
            visited.add(n);
        }
        return true;
    }
    public int find(int n){
        int sum = 0;
        while(n>0){
            sum+= (n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }
}
