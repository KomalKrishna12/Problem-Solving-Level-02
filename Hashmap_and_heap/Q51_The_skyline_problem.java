import java.util.*;
public class Q51_The_skyline_problem {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        // write your code here
        return null;
    
      }
    
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            arr[i][j] = sc.nextInt();
          }
        }
        sc.close();
        List<List<Integer>> ans = getSkyline(arr);
        for (int i = 0; i < ans.size(); i++) {
          for (int j = 0; j < ans.get(i).size(); j++) {
            System.out.print(ans.get(i).get(j) + " ");
          }
          System.out.println();
        }
      }
    
      public static class Pair implements Comparable<Pair> {
        int x = 0;
        int ht = 0;
    
        Pair(int x, int ht) {
          this.x = x;
          this.ht = ht;
        }
    
        @Override
        public int compareTo(Pair o) {
          if (this.x != o.x) {
            return this.x - o.x;
          } else {
            return this.ht - o.ht;
          }
        }
      }
}
