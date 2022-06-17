import java.io.*;
import java.util.*;
// mother vertex is a vertex by which we can go all other verteces
// we use same solution which we used in kosaraju algo
// create a stack and start traversing by the time of backtracking add the element into stack
// at end at the top of stack our mother vetex will be present
// if it is mother vertex then we can traverse all vertex through this
// so traverse and check using a count variable 
public class Q21_Mother_Vertex {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          graph.add(new ArrayList<>());
        }
    
        for (int i = 0; i < m; i++) {
          st = br.readLine().split(" ");
          int u = Integer.parseInt(st[0]) - 1;
          int v = Integer.parseInt(st[1]) - 1;
          graph.get(u).add(v);
        }
    
        System.out.println(findMotherVertex(n, graph));
      }
      static int count;
  public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj) {
      boolean[] vis = new boolean[N];
      Stack<Integer> st = new Stack<>();
      
      for(int i = 0; i < N; i++){
          if(vis[i] == false){
              dfs(i, adj, st, vis);
          }
      }
      
      int ans = st.pop();
      vis = new boolean[N];
      count = 0;
      dfs(ans, adj, vis);
      
      if(count == N) return ans + 1; // add 1 bcoz it is 1 based indexing
      else return -1;
  }
  public static void dfs(int src, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] vis){
      vis[src] = true;
      ArrayList<Integer> nbrs = adj.get(src);
      for(int nbr : nbrs){
          if(vis[nbr] == false){
              dfs(nbr, adj, st, vis);
          }
      }
      st.push(src);
  }
  public static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
      vis[src] = true;
      count++;
      ArrayList<Integer> nbrs = adj.get(src);
      for(int nbr : nbrs){
          if(vis[nbr] == false){
              dfs(nbr, adj, vis);
          }
      }
  }
}
