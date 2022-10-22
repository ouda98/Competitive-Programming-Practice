package LeetCodeCommonProblems;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }

            }
        }
        for(Integer r: rows)
            Arrays.fill(matrix[r],0);

        for(Integer c: columns)
            for(int i=0;i<matrix.length;i++)
                matrix[i][c] = 0;

    }
    // no pruning added yet
}
