package Algorithms;

import java.util.Arrays;

public class Permutaions {
    public static void main(String[] args) {
        int [] arr = {3,2,5,6,1};
        permute(arr, 0,4);


    }
    private static void permute(int [] str, int l, int r)
    {
        if (l == r)
            System.out.println(Arrays.toString(str));
        else
        {
            for (int i = l; i <= r; i++)
            {
                swapArray(str,l,i);
                permute(str, l+1, r);
                swapArray(str,l,i);
            }
        }
    }
    public static void swapArray(int []a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

//    static boolean findsNextPermutation(int[] p) {
//        for (int a = p.length - 2; a >= 0; --a)
//            if (p[a] < p[a + 1])
//                for (int b = p.length - 1; ; --b)
//                    if (p[b] > p[a]) {
//                        int t = p[a];
//                        p[a] = p[b];
//                        p[b] = t;
//                        for (++a, b = p.length - 1; a < b; ++a, --b) {
//                            t = p[a];
//                            p[a] = p[b];
//                            p[b] = t;
//                        }
//                        return true;
//                    }
//        return false;
//    }

}
