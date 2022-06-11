public class Q1_Coloring_a_border{
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0) grid[i][j] = color;
            }
        }
        return grid;
    }
    public static void dfs(int[][] grid, int row, int col, int clr){
        grid[row][col] = -clr;
        int count = 0;
        
        for(int i = 0; i < 4; i++){
            int nrow = row + dir[i][0];
            int ncol = col + dir[i][1];
            
            if(nrow < 0 || ncol < 0 || nrow >= grid.length || ncol >= grid[0].length || Math.abs(grid[nrow][ncol]) != clr) 
                continue;
            
            count++;
            
            if(grid[nrow][ncol] == clr) 
                dfs(grid, nrow, ncol, clr);
        }
        
        if(count == 4) grid[row][col] = clr;
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 2}};
        int row = 0;
        int col = 0;
        int color = 3;

        int[][] arr = colorBorder(grid, row, col, color);
        printArray(arr);

    }
    public static void printArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}