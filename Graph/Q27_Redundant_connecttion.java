import java.io.*;
// we have given a tree, after adding one edge it becomes a graph
// so we have to find out the edge which is responsible for converting the tree into graph
// solution : we use DSU start merging all edges 
// if we got any edge whose both vertex are already in the graph that means that is the edge
// who is making it as graph
public class Q27_Redundant_connecttion {
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
    
        int[] ans = findRedundantConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
      }
    
      // create parent and rank class
      // size will be edges.length + 1 bcoz vertex are from 1
      // initialize parent with index and rank with 1
      public static int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        
        for(int i = 0; i < edges.length; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        // now start merging edges
        // find out both vertex of edge
        // find their leader or parents
        // if they are equal means this is the edge we are searching for
        // else merge the verteces
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            int lu = find(par, u);
            int lv = find(par, v);
            
            if(lu != lv){
                if(rank[lu] > rank[lv]) par[lv] = lu;
                else if(rank[lv] > rank[lu]) par[lu] = lv;
                else{
                    par[lu] = lv;
                    rank[lv]++;
                }
            }
            else return edge;
        }
        
        return new int[2];
    }
  
    private static int find(int[] parent, int f) {
        if(f == parent[f]) return f;
        return parent[f] = find(parent, parent[f]);
    }
}
