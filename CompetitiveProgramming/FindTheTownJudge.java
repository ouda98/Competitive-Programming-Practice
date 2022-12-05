public class FindTheTownJudge {
    public static void main(String[] args) {

    }
    public int findJudge(int n, int[][] trust) {
        int[] trustt = new int[n+1];
        int[] trusted = new int[n+1];
        if(n==1)
            return 1;
        for(int i=0;i<trust.length;i++){
            trustt[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }
        for(int i=0;i<trustt.length;i++){
            if(trustt[i] == 0 && trusted[i] == n-1)
                return i;
        }
        return -1;
    }
}
