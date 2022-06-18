import java.util.*;
// articulation point is a point which can divide the graph into two or more parts if we remove the 
// vertex and their connected edges, then that point is a articulation point
// we have to count total articulation point
// here we use three arrays : parent, disc and low
// parent will store parent veretx of each vertex
// disc will store sequence
// low will store the disc point which we can traverse without using the current following path
public class Q22_Articulation_Point {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static int time; // to store in disc and low
    static boolean[] vis; 
    static boolean[] ap; // mark true if that is articulation point

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
      // parent of src will be -1 it is used to check for src 
      parent[0] = -1;
      dfs(0, graph);
      
      // count all articulation point
      int ans = 0;
      for(int i = 0; i < v; i++){
          if(ap[i] == true) ans += 1;
      }
      
      System.out.println(ans);
  }
  
  public static void dfs(int src, ArrayList<ArrayList<Integer>> graph){
    // mark src true
    // initially mark both disc and low as time and increase for next seq
      vis[src] = true;
      disc[src] = low[src] = time;
      time++;
      // create this count, it'll be used for only first src vertex
      int count = 0;
      
      ArrayList<Integer> nbrs = graph.get(src);
      
      for(int nbr : nbrs){
        // if nbr is parent then continue
          if(parent[src] == nbr){
              continue;
          }
          // if nbr uis visited then store current low as min of curent low and disc of nbr
          else if(vis[nbr] == true){
              low[src] = Math.min(low[src], disc[nbr]);
          }
          else{
            // now nbr is not visited so mark parent of nbr as src
            // increase count
            // call dfs for nbr
              parent[nbr] = src;
              count++;
              dfs(nbr, graph);
              if(parent[src] == -1){
                // for actual src this articulation condition will not work so using count we can
                // find out
                // if count is 1 and all vertex is visited that means it is not articulation point 
                // bcoz their is no any way to divide graph using this vertex
                // if count is greater than equal to 2 then it is articulation point
                  if(count >= 2) ap[src] = true;
              }
              else{
                // compare the current disc and low of nbr
                // if low of nbr is greater than equal to disc of src means if we break current 
                // vertex then their is not way to connect prev so graph will divided into two
                // parts
                  if(low[nbr] >= disc[src]){
                      ap[src] = true;
                  }
              }
          }
      }
  }
}
