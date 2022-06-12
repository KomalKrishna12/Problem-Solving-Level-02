import java.io.*;
import java.util.*;
public class Q4_Zero_One_Matrix {
    private static class Pair {
        int x;
        int y;
    
        Pair(int x, int y) {
          this.x = x;
          this.y = y;
        }
      }
    
      private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
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
    
        int[][] ans = updateMatrix(arr);
    
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            System.out.print(ans[i][j] + " ");
          }
          System.out.println();
        }
    
      }
    
      public static int[][] updateMatrix(int[][] matrix) {
          ArrayDeque<Pair> queue = new ArrayDeque<>();

          // firstly add all pairs in which element is 0
          // and mark 1 as -1
          for(int i = 0; i < matrix.length; i++){
              for(int j = 0; j < matrix[0].length; j++){
                  if(matrix[i][j] == 0){
                      queue.add(new Pair(i, j));
                  }
                  else{
                      matrix[i][j] = -matrix[i][j];
                  }
              }
          }

          while(queue.size() > 0){

              Pair rPair = queue.removeFirst();

              for(int i = 0; i < 4; i++){
                  int idash = rPair.x + dirs[i][0];
                  int jdash = rPair.y + dirs[i][1];

                  if(idash >= 0 && jdash >= 0 && idash < matrix.length && jdash < matrix[0].length && 
                  matrix[idash][jdash] < 0){
                      queue.add(new Pair(idash, jdash));
                      matrix[idash][jdash] = matrix[rPair.x][rPair.y] + 1;
                  }
              }

          }
          return matrix;
      }
}
