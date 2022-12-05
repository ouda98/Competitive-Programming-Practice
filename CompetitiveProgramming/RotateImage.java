public class RotateImage {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while(left <right){
            for(int i=left;i<right;i++){
                int hup = matrix[left][i];
                int hdown = matrix[right][right+left-i];
                int vright = matrix[i][right];
                int vleft = matrix[right-i+left][left];
                matrix[left][i] = vleft; //H up Done
                matrix[right][right+left-i] = vright; //H down Done
                matrix[i][right] = hup; //V right Done
                matrix[right-i+left][left] = hdown; //V left
            }
            left++;
            right--;
        }
    }
}
