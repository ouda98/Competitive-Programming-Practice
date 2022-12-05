import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] r = new int[]{0,1,0,-1};
        int[] c = new int[]{1,0,-1,0};
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int column = 0;
        int i=0;
        while(result.size()< matrix.length*matrix[0].length){
            result.add(matrix[row][column]);
            matrix[row][column] = -101;
            if(isValid(row+r[i],column+c[i], matrix)){
                row = row+r[i];
                column = column+c[i];
            }else{
                i++;
                i = i%4;
                row = row+r[i];
                column = column+c[i];
            }
        }
        return result;
    }
    public boolean isValid(int x, int y, int[][] matrix){
        return x>=0 && x< matrix.length && y>=0 && y<matrix[x].length && matrix[x][y]!=-101;
    }
}
