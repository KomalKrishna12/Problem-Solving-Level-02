import java.io.*;
// we have given a graph edges
// in this edges[0] represent types 
// we have two ppl Alice and Bob 
// if type is 3 we then edges[1] and edges[2] can pair up for both ppl
// if type is 1 then it'll pair up for Alice only and if type is 2 then for Bob
// we have to remove max edges so that both ppl can traverse through all the edges and vertex
// we use DSU for this
// create two parent arrays and two rank arrays
// whenever any pair join increase their mergeEdge by 1
// if no pair then increase removeEge by 1
// at end check both mergeEdge if that is equal to n that means all paired up so return removeEdge
// else return -1
// vertex are 1 based so create array of n+1
public class Q24_Remove_max_no_of_edges_to_keep_graph_fully_traversable {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
          st = br.readLine().split(" ");
          edges[i][0] = Integer.parseInt(st[0]);
          edges[i][1] = Integer.parseInt(st[1]);
          edges[i][2] = Integer.parseInt(st[2]);
        }
        Q24_Remove_max_no_of_edges_to_keep_graph_fully_traversable obj = new Q24_Remove_max_no_of_edges_to_keep_graph_fully_traversable ();
        System.out.println(obj.maxNumEdgesToRemove(n, edges));
      }
    
      public int maxNumEdgesToRemove(int n, int[][] edges) {
        // veretx is 1 based so we created array of size n+1
        int[] parentA = new int[n+1];
        int[] parentB = new int[n+1];
        int[] rankA = new int[n+1];
        int[] rankB = new int[n+1];
        int mergeA = 1, mergeB = 1; // intialize with 1 bcoz first time we pair up two vertex 
        // if we start adding 2 then it'll add 2 for all
        int remove = 0;

        // intialize all parent array with their index and rank with 1
        for(int i = 0; i <= n; i++){
            parentA[i] = i;
            parentB[i] = i;
            rankA[i] = 1;
            rankB[i] = 1;
        }

        for(int[] edge : edges){
            int type = edge[0];
            if(type == 3){
                // means edge is for both Alice and Bob
                boolean mergeAflag = union(edge[1], edge[2], parentA, rankA);
                boolean mergeBflag = union(edge[1], edge[2], parentB, rankB);

                if(mergeAflag) mergeA++;

                if(mergeBflag) mergeB++;

                if(mergeAflag == false && mergeBflag == false) remove++;
            }
            else if(type == 1){
                // means edge is for Alice only
                boolean mergeAflag = union(edge[1], edge[2], parentA, rankA);

                if(mergeAflag) mergeA++;

                else remove++;
            }
            else{
                // means edge is for Bob only
                boolean mergeBflag = union(edge[1], edge[2], parentB, rankB);

                if(mergeBflag) mergeB++;

                else remove++;
            }
        }

        if(mergeA != n || mergeB != n) return -1;
        else return remove;

      }

      public static int find(int x, int[] parent){
        if(x == parent[x]) return x;

        int temp = find(parent[x], parent);
        parent[x] = temp;

        return temp;
      }

      public static boolean union(int x, int y, int[] parent, int[] rank){
        int lx = find(x, parent);
        int ly = find(y, parent);

        if(lx != ly){
            // leaders are not same so find rank for both
            // whose rank is greater make them parent so rank will be same
            // if rank of both are same then make anyone parent and increase the rank of parenr
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }
            else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }
            else{
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }

        // means both parent is same so union is not possible they are already in same set
        return false;
      }

    }
