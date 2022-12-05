public class NumberOfLaserBeamsInABank {
    public static void main(String[] args) {

    }
    public int numberOfBeams(String[] bank) {
        int c = 0;
        int oldC = 0;
        int sum = 0;
        for(String s : bank){
            c = countOnes(s);
            sum+= oldC*c;
            if(c!=0)
                oldC = c;
        }
        return sum;
    }
    public int countOnes(String s){
        int count = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) == '1')
                count++;
        return count;
    }
}
