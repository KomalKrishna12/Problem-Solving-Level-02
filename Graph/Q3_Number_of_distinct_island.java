import java.io.*;
// this is similar ques like we did in number of island in level 1
// here we have to count all the islands
// distinct islands
// similar islans will be counted as 1
import java.util.HashSet;

public class Q3_Number_of_distinct_island {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(numDistinctIslands(arr));
    
      }
    
      public static StringBuilder psf = new StringBuilder();

      public static void dfs(int[][] arr, int i, int j){
        arr[i][j] = 0;

        // up
        if(i-1 >= 0 && arr[i-1][j] == 1){
          psf.append("u");
          dfs(arr, i-1, j);
        }
        
        // right
        if(j+1 < arr[0].length && arr[i][j+1] == 1){
          psf.append("r");
          dfs(arr, i, j+1);
        }

        // down
        if(i+1 < arr.length && arr[i+1][j] == 1){
          psf.append("d");
          dfs(arr, i+1, j);
        }

        // left
        if(j-1 >= 0 && arr[i][j-1] == 1){
          psf.append("l");
          dfs(arr, i, j-1);
        }

        // for bacltracking append "z" so we'll get exactly distinct islands
        // otherwise it'll look same for different islands
        psf.append("z");

      }
      
      public static int numDistinctIslands(int[][] arr) {
        HashSet<String> islands = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
          for(int j = 0; j < arr[0].length; j++){
            if(arr[i][j] == 1){
              psf = new StringBuilder();
              psf.append("x");
              dfs(arr, i, j);
              islands.add(psf.toString());
            }
          }
        }

        return islands.size(); // total distinct islands store in hashset so return it's size
      }
}
