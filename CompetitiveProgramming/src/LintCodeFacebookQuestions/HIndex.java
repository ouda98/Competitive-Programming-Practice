package LintCodeFacebookQuestions;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int [] arr = {94,40,49,65,21,21,106,80,92,81,679,4,61,6,237,12,72,74,29,95,265,35,47,1,61,397,52,72,37,51,1,81,45,435,7,36,57,86,81,72};
        System.out.println(hIndex(arr));

    }
    public static int hIndex(int[] citations) {
        // write your code here
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int max = citations[citations.length-1];
        int counter =0;
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]!=max){
                max = citations[i];
            }


            if(counter >= max)
                break;
            counter++;
        }
        return counter;
    }
}
