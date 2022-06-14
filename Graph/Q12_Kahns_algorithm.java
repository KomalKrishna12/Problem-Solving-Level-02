import java.io.*;
import java.util.*;
public class Q12_Kahns_algorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int[][] prerequisit = new int[m][2];
        for(int i = 0; i < m; i++){
            st = br.readLine().split(" ");
            prerequisit[i][0] = Integer.parseInt(st[0]);
            prerequisit[i][1] = Integer.parseInt(st[1]);
        }

        for(int i = 0; i < prerequisit.length; i++){
            int u = prerequisit[i][0];
            int v = prerequisit[i][1];

            graph.get(v).add(u);
        }

        int[] ans = findorder(n, graph);
        for(int val : ans) System.out.print(val + " ");
    }

    public static int[] findorder(int n, ArrayList<ArrayList<Integer>> graph){
        int[] indegree = new int[n];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            for(int nbr : graph.get(i)){
                indegree[nbr]++;

            }
        }

        int idx = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(queue.size() > 0){
            int rem = queue.removeFirst();
            ans[idx++] = rem;

            for(int nbr : graph.get(rem)){
                indegree[nbr]--;
                if(indegree[nbr] == 0) queue.add(nbr);
            }
        }
        if(n == idx) return ans;
        return new int[]{-1};
    }
}
