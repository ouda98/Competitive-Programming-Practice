public class SearchA2DMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] > target)
                return false;
            if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >=target){
                return bs(matrix[i], target);
            }
        }
        return false;
    }
    public boolean bs(int [] matrix, int target){
        int left = 0;
        int right = matrix.length-1;
        int mid;
        while(left <= right){
            mid = (right-left)/2 + left;
            if(matrix[mid] == target)
                return true;
            if(matrix[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}
