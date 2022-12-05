import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MatrixCellsInDistanceOrder {
    public static void main(String[] args) {

    }
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                result.add(new int[]{i,j});
        Collections.sort(result, new Comparator<int[]>(){
            public int compare(int[]a, int[] b){
                return (Math.abs(a[0]-rCenter)+Math.abs(a[1]- cCenter)) - (Math.abs(b[0]-rCenter)+Math.abs(b[1]- cCenter));
            }
        });
        int[][] arr = result.toArray(new int[result.size()][2]);

        return arr;
    }
}
