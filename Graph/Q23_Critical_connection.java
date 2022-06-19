import java.io.*;
import java.util.*;
// this is similar ques like articular point
// in articulation point we remove vertex and their connected edges
// here we remove edge only
// so whole concept is same
// no need for count or no concept needed like actual src
// we simple use low[nbr] > disc[src]) if this is true then it is critical connection or bridge
public class Q23_Critical_connection {
    static int[] parent, disc, low;
  static boolean[] vis;
  static int time;

  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

    for (int i = 0; i < Edges.size(); i++) {
      int u = Edges.get(i).get(0);
      int v = Edges.get(i).get(1);
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    parent = new int[n];
    disc = new int[n];
    low = new int[n];
    vis = new boolean[n];
    time = 0;

    List<List<Integer>> ans = new ArrayList<>();
    bridges(0, graph, ans);
    return ans;
  }
  
  public static void bridges(int u, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans){
      vis[u] = true;
      disc[u] = low[u] = time;
      time++;
      
      ArrayList<Integer> nbrs = graph.get(u);
      for(int v : nbrs){
          if(parent[u] == v){
              continue;
          }
          else if(vis[v] == true){
              low[u] = Math.min(low[u], disc[v]);
          }
          else{
              parent[v] = u;
              bridges(v, graph, ans);
              low[u] = Math.min(low[u], low[v]);
              if(low[v] > disc[u]){
                  List<Integer> list = new ArrayList<>();
                  list.add(u);
                  list.add(v);
                  ans.add(list);
              }
          } 
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }
}
