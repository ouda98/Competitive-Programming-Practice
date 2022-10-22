public class TravelPlan {
    public static void main(String[] args) {
        int[][] arr = {{0,10000,2},{5,0,10000},{10000,4,0}};
        System.out.println(travelPlan(arr));


    }

    static int min;
    static boolean[] visited;

    public static int travelPlan(int[][] arr) {
        // Write your code here.
            visited = new boolean[100005];
        min = Integer.MAX_VALUE;
        dfs(arr, 0, 0, 0);
        return min;
    }

    public static void dfs(int[][] arr, int sum, int idx, int count) {
        if (count + 1 == arr.length) {
            sum += arr[idx][0];
            if (sum < min)
                min = sum;
        }
        visited[idx] = true;
        for (int i = 0; i < arr[idx].length; i++) {
            if (i != idx && !visited[i]) {
                dfs(arr, sum + arr[idx][i], i, count + 1);
            }
        }
        visited[idx] = false;

    }
}
