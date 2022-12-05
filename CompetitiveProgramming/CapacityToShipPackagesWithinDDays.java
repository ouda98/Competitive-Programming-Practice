public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {

    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 333333;
        int index = -1;
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(bin(weights,days, mid)){
                index = mid;
                right = mid-1;
            }else
                left = mid+1;
        }
        return index;
    }
    public boolean bin(int[] weights, int days, int value){
        int sum = 0;
        int d = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]> value)
                return false;
            if(sum + weights[i] > value){
                d++;
                sum = 0;
            }
            sum+= weights[i];
        }
        if(sum!=0)
            d++;
        if(d<=days)
            return true;
        return false;
    }
}
