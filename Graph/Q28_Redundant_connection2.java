import java.io.*;
import java.util.*;
// this is similar like Q27 in that ques we were solving for undirected graph
// in this we solve for direcetd graph
// we have total 3 cases
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
    
      static int[] par;
      static int[] rank;
    
      public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length; // 1 based indexing
        int[] ind = new int[edges.length + 1];
        Arrays.fill(ind, -1);
        int bl1 = -1, bl2 = -1;
    
        for (int i = 0; i < edges.length; i++) {
          // int u = edges[i][0];
          int v = edges[i][1];
    
          if (ind[v] == -1) {
            // menas this is first indegree so store i into indegree of v
            ind[v] = i;
          }
          else {
            // mean's already one indgree present and here we have another indegree so mark block list 1 as i and block list 2 as indegree of v
            bl1 = i;
            bl2 = ind[v];
            break;
            // break bcoz we have only one extra edge present and we found that edge
          }
        }
    
        // now we have to apply dsu
        // we have three cases
        // case 1 : 2 paren1, case 2 : cycle, case 3 : 2 parent and cycle
        // we can handle case 1 and 3 simultaneously
        // if bl1 is -1 that means no 2 parent only cycle means case 2 so in that case we only need to apply dsu if union return true then return current edge
        // if bl2 is not -1 and cycle is present then return bl2 bcoz after ignoring bl1 cycle is present
        // else at end return bl1 edge
    
        // intialize both parent and rank array
        par = new int[n + 1];
        rank = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
          par[i] = i;
          rank[i] = 1;
        }
    
        for (int i = 0; i < edges.length; i++) {
          if (i == bl1) continue; // skipping bl1 edge
          int u = edges[i][0];
          int v = edges[i][1];
    
          boolean flag = union(u, v);
          if (flag) {
            if (bl1 == -1) { // case 2 : cycle found so return ith edge
              return edges[i];
            }
            else {
              // case 3 : after blocking bl1 edge cycle presnet so return edge of bl2
              return edges[bl2];
            }
          }
        }
        return edges[bl1]; // case 1
      }
    
      public static int find(int x) {
        if (x == par[x]) return x;
    
        return par[x] = find(par[x]);
      }
    
      public static boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
    
        if (lx != ly) {
          if (rank[lx] > rank[ly]) par[ly] = lx;
          else if (rank[ly] > rank[lx]) par[lx] = ly;
          else {
            par[lx] = ly;
            rank[ly]++;
          }
          return false;
        }
        else {
          return true;
        }
      }
}