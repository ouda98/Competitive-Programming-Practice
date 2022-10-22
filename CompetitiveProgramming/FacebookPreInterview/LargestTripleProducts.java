package FacebookPreInterview;

import java.util.Arrays;

public class LargestTripleProducts {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1, 2};
        System.out.println(Arrays.toString(findMaxProduct(arr)));

    }

    static int[] findMaxProduct(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        if (arr.length < 3)
            return result;
        int one = arr[0];
        int two = arr[1];
        int three = arr[2];
        result[2] = one * two * three;
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] > Math.min(one, Math.min(two, three))) {
                if (one == Math.min(one, Math.min(two, three)))
                    one = arr[i];
                else if (two == Math.min(one, Math.min(two, three)))
                    two = arr[i];
                else
                    three = arr[i];
            }
            result[i] = one * two * three;
        }
        return result;
    }
}
