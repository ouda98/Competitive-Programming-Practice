import Template.template;

import java.io.*;
import java.util.StringTokenizer;

public class MinimumMovesToEqualArrayElementsII1226QuickSelect {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] nums = {1, 2,3,4,5,15,16};
        int index = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        int pivot = nums[index];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(pivot - nums[i]);
        }
        System.out.println(moves);
//        System.out.println(index + " " + nums[index]);

        out.flush();
        out.close();
    }

    private static int quickSelect(int[] nums, int l, int r, int target) {
        int index = partition(nums, l, r, target);
        if (index == target)
            return index;
        if (index < target)
            return quickSelect(nums, index + 1, r, target);
        else
            return quickSelect(nums, l, index - 1, target);
    }

    private static int partition(int[] nums, int l, int r, int target) {
        int pivot = nums[r];
        int locPos = l;
        int temp;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                temp = nums[i];
                nums[i] = nums[locPos];
                nums[locPos++] = temp;
            }
        }
        temp = nums[r];
        nums[r] = nums[locPos];
        nums[locPos] = temp;

        return locPos;

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return next().charAt(0);
        }

        Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}
