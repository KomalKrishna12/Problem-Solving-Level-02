import java.util.*;

// this algo is similar like get connected componenet which we use for undirecetd graph
// this algo is used to count all the strongly connected component of directed graph 
// a strongly directed graph can be a cyclic graph but a cycle may or may not
// this algo is in 3 steps
// step 1 : apply dfs and traverse through all the edges and while backtracking add them in stack
// step 2 : reverse all the edges
// step 3 : start removing stack and count strongly connected components
public class Q20_Kosaraju_Algorithm {
    public static void main(String args[]) throws Exception {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int e = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = scn.nextInt() - 1;
            int v1 = scn.nextInt() - 1;
            graph.get(u).add(v1);
        }

        scn.close();

        // step 1
        // traverse through all the vertex and mark them visited
        // while backtracking add that vertex into stack
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                dfs1(i, graph, st, vis);
            }
        }

        // step 2
        // reverse all the edges
        // create new graph
        // get all the nbrs and reverse them
        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            ngraph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            ArrayList<Integer> nbrs = graph.get(i);
            for (int nbr : nbrs) {
                ngraph.get(nbr).add(i);
            }
        }

        // step 3
        // now start removing element from stack
        // mark it true and check for dfs
        // add 1 after dfs ended becoz we got one strongly connected components
        vis = new boolean[v];
        int ans = 0;
        while (st.size() > 0) {
            int rem = st.pop();
            if (vis[rem] == false) {
                dfs2(rem, ngraph, vis);
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void dfs1(int src, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st, boolean[] vis) {
        vis[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (vis[nbr] == false) {
                dfs1(nbr, graph, st, vis);
            }
        }
        st.push(src);
    }

    public static void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (vis[nbr] == false) {
                dfs2(nbr, graph, vis);
            }
        }
    }
}
