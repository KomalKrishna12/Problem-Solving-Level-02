import java.io.*;
public class Q28_Redundant_connection2{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
    
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          pos[i][0] = Integer.parseInt(st[0]);
          pos[i][1] = Integer.parseInt(st[1]);
        }
    
        int[] ans = findRedundantDirectedConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
      }
    
    
    
      public static int[] findRedundantDirectedConnection(int[][] edges) {
    
      }
}