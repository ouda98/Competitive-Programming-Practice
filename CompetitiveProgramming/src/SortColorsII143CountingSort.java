public class SortColorsII143CountingSort {
    public static void main(String[] args) {
        int[] colors = {3,2,2,1,4};
        int k = 3;

        int [] result = new int [k+1];
        for(int i=0;i<colors.length;i++)
            result[colors[i]]++;

        int counter =0;
        for(int i=0;i<result.length;i++){
            while(result[i]>0){
                colors[counter++] = i;
                result[i]--;
            }
        }
    }
}
