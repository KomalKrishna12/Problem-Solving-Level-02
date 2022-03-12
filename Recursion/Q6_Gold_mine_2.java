import java.util.*;
// in this question we have given a 2d array
// each row & col contains some amount
// we are required to collect gold from highest value
// if value is 0 we can collect
// if that row & col is already visited then we can not visit again
// we can move in top, left, righ and down
// at end print max amount
public class Q6_Gold_mine_2 {
    public static int getMaximumGold(int[][] grid) {
        int max = 0;
        
        // trarese in each row & col
        // check the amount in that particular box if it is not zero then call helper() with grid, row 
        // col and compaer val with max and update
        for(int i = 0; i < grid.length; i++){
            
            for(int j = 0; j < grid[i].length; j++){
                
                if(grid[i][j] != 0){
                    
                    int val = helper(grid, i, j);
                    max = Math.max(max, val);
                    
                }
                
            }
            
        }
        
        return max;
    }
    
    public static int helper(int[][] grid, int i, int j){

        // if row or col is less than zero means beyond lower limit or upper limit then return 0
        // if box value is 0 then also return 0 
        // if box value is negetive then also return 0  

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 ||
          grid[i][j] < 0) return 0;
        
        // create a variable val to store the particular amount
        // and mark that row as negetive so we cannot visit it again
        // now call top, right, left and down
        // and compare each values and store max into ans variable
        // now set the box with it's prev value
        // return ans with the val
          
        int val = grid[i][j];
        
        grid[i][j] = -val;
        
        int t = helper(grid, i-1, j);
        
        int r = helper(grid, i, j+1);
        
        int l = helper(grid, i, j-1);
        
        int d = helper(grid, i+1, j);
        
        int ans = Math.max(t, Math.max(r, Math.max(l, d)));
        
        grid[i][j] = val;
        
        return ans + val;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
        scn.close();
		System.out.println(getMaximumGold(arr));
	}
}
