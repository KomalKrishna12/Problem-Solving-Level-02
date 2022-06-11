// we have given a 2D grid and given a row, col and a color
// we have to color all connecetd elements of grid[row][col] with color given
// suppose grid is {{1,1}, {1, 0}}, row = 0, col = 0, color = 3
// so with (0,0) connecetd components are (0,1), (1,0), (1,1) so we color them with 3
// so ans will be {{3,3}, {3,0}}
// we have to color only borders
// so we can use a variable count to store count of connectd component if count become 4 that means
// it is not border so don't color it
public class Q1_Coloring_a_border{
    // this direction array will use to traverse in all four direction in order to get connecetd 
    // components
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    // now win dfs function we pass color as grid[row][col] 
    // so we mark conneccted vertex with -grid[row][col]
    // so we can easily identify and change with the actual color
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0) grid[i][j] = color;
            }
        }
        return grid;
    }

    // firstly make it negetive
    // create a count variavble to checl wheather it is corner or border
    // now check all four directions
    // if count become 4 that means it is not border so again convert it into previour means 
    // make it positive
    public static void dfs(int[][] grid, int row, int col, int clr){
        grid[row][col] = -clr;
        int count = 0;
        
        for(int i = 0; i < 4; i++){
            int nrow = row + dir[i][0];
            int ncol = col + dir[i][1];
            
            // check all it's corner points
            // also check absolute value if it is not color then  continue
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