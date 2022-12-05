public class GasStation {
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int totalSum = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            totalSum+= gas[i] - cost[i];
            sum+= gas[i] - cost[i];
            if(sum<0){
                sum = 0;
                start = i+1;
            }
        }
        return (totalSum<0)?-1:start;
    }
}
