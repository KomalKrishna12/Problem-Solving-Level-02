import java.io.*;
import java.util.ArrayDeque;
// we have given an array which consisit of 0 and 1
// 0 means water
// 1 means land
// we have to make bridge between islands
// so first we need to findout any 1's component
// so using dfs we'll 1's component and add them into queue and mark them visited
// now using bfs we'll start removing from queue and keep storing levels
// once we find any 1 then return level
public class Q7_Shortest_Bridge {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(shortestBridge(arr));

    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int shortestBridge(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        boolean flag = false;
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for(int i = 0; i < A.length && flag == false; i++){
            for(int j = 0; j < A[0].length && flag == false; j++){
                if(A[i][j] == 1){
                    dfs(i, j, queue, visited, A);
                    flag = true;
                }
            }
        }

        int level = 0; 
        while(queue.size() > 0){
            int size = queue.size();
            while(size-- > 0){
                Pair rem = queue.removeFirst();

                for(int i = 0; i < 4; i++){
                    int idash = rem.row + dir[i][0];
                    int jdash = rem.col + dir[i][1];

                    if(idash < 0 || jdash < 0 || idash >= A.length || jdash >= A[0].length || 
                    visited[idash][jdash] == true){
                        continue;
                    }

                    if(A[idash][jdash] == 1){
                        return level;
                    }

                    queue.add(new Pair(idash, jdash));
                }
            }
            level++;
        }

        return -1;
    }

    public static void dfs(int i, int j, ArrayDeque<Pair> queue, boolean[][] visited, int[][] A){
        visited[i][j] = true;
        queue.add(new Pair(i, j));

        for(int k = 0; k < 4; k++){
            int idash = i + dir[k][0];
            int jdash = j + dir[k][1];

            if(idash < 0 || jdash < 0 || idash >= A.length || jdash >= A[0].length || 
            visited[idash][jdash] == true || A[idash][jdash] == 0){
                continue;
            }

            dfs(idash, jdash, queue, visited, A);
        }
    }
}
