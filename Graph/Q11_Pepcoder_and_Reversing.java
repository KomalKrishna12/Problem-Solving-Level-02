import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
// we have given a directed graph
// we have to find out shortest path to reach destination
// assume if their diretion is given then assume weight as 0
// else weight will be considered as 1

public class Q11_Pepcoder_and_Reversing {
    static class Pair{
        int ver, wt;
        Pair(int ver, int wt){
            this.ver = ver;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = br.readLine().split(" ");
            int u =Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(new Pair(v, 0));
            graph.get(v).add(new Pair(u, 1));
        }

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0));
        boolean[] visited = new boolean[n];
        
        while(queue.size() > 0){
            Pair rem = queue.removeFirst();
            visited[rem.ver] = true;
            if(rem.ver == n-1){
                System.out.println(rem.wt);
                return;
            }
           
            for(Pair nbr : graph.get(rem.ver)){
                if(visited[nbr.ver] == true) continue;
                visited[nbr.ver] = true;
                if(nbr.wt == 0) queue.addFirst(new Pair(nbr.ver, rem.wt + 0));
                if(nbr.wt == 1) queue.addLast(new Pair(nbr.ver, rem.wt + 1));
            }
            
        }
        System.out.println("-1");
    }
}
