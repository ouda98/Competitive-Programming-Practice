package LeetCodeCommonProblems;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int [] arr = {9,8,9};
        int[] a = plusOne(arr);
        System.out.println(Arrays.toString(a));
    }
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=carry;
            if(digits[i] >= 10){
                digits[i]= digits[i]-10;
                carry = 1;
            }else
                carry =0;
        }
        if(carry ==1){
            int[] result = new int[digits.length+1];
            result[0] =1;
            for(int i=0;i<digits.length;i++){
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}
