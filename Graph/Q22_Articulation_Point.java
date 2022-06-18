import java.util.*;
public class Q22_Articulation_Point {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static int time;
    static boolean[] vis;
    static boolean[] ap;

  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      
      int v = scn.nextInt();
      int e = scn.nextInt();
      
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < v; i++){
          graph.add(new ArrayList<>());
      }
      
      for(int i = 0; i < e; i++){
          int u = scn.nextInt() - 1;
          int v1 = scn.nextInt() - 1;
          graph.get(u).add(v1);
          graph.get(v1).add(u);
      }

      scn.close();
      
      parent = new int[v];
      disc = new int[v];
      low = new int[v];
      vis = new boolean[v];
      ap = new boolean[v];
      time = 0;
      parent[0] = -1;
      dfs(0, graph);
      
      int ans = 0;
      for(int i = 0; i < v; i++){
          if(ap[i] == true) ans += 1;
      }
      
      System.out.println(ans);
  }
  
  public static void dfs(int src, ArrayList<ArrayList<Integer>> graph){
      vis[src] = true;
      disc[src] = low[src] = time;
      time++;
      int count = 0;
      
      ArrayList<Integer> nbrs = graph.get(src);
      
      for(int nbr : nbrs){
          if(parent[src] == nbr){
              continue;
          }
          else if(vis[nbr] == true){
              low[src] = Math.min(low[src], disc[nbr]);
          }
          else{
              parent[nbr] = src;
              count++;
              dfs(nbr, graph);
              if(parent[src] == -1){
                  if(count >= 2) ap[src] = true;
              }
              else{
                  if(low[nbr] >= disc[src]){
                      ap[src] = true;
                  }
              }
          }
      }
  }
}
