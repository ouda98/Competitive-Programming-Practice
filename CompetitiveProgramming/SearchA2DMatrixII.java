public class SearchA2DMatrixII {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = bs1(matrix[0],target);
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] <= target && matrix[i][left] >=target){
                if(bs(matrix[i],left, target))
                    return true;
            }
        }
        return false;
    }
    public int bs1(int [] matrix, int target){
        int left = 0;
        int right = matrix.length-1;
        int mid;
        while(left <= right){
            mid = (right-left)/2 + left;
            if(matrix[mid]<=target)
                left = mid+1;
            else
                right = mid-1;
        }
        return Math.min(left, matrix.length-1);
    }
    public boolean bs(int [] matrix,int end, int target){
        int left = 0;
        int right = end;
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
