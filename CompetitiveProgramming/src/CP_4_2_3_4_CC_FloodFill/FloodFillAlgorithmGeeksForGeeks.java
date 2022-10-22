package CP_4_2_3_4_CC_FloodFill;

import java.util.Arrays;

public class FloodFillAlgorithmGeeksForGeeks {
    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image,1,1,2);
        for(int i=0;i<image.length;i++)
            System.out.println(Arrays.toString(image[i]));
    }
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        dfs(image, sr,sc,newColor, image[sr][sc]);
        return image;
    }

    public static void dfs(int [][] image, int sr, int sc, int newColor, int oldColor){
        image[sr][sc] = newColor;
        int x;
        int y;
        for(int i=0;i<dr.length;i++){
            x = sr + dr[i];
            y = sc + dc[i];
            if(valid(image,x,y,oldColor))
                dfs(image,x,y,newColor,oldColor);
        }
    }
    public static boolean valid(int [][] image, int x, int y, int oldColor){
        return x>=0 && y>=0 && x<image.length && y<image[0].length && image[x][y] == oldColor;
    }
}
