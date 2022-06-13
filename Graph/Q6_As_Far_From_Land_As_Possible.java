import java.io.*;
import java.util.ArrayDeque;
// we have to find out farest land from water
public class Q6_As_Far_From_Land_As_Possible {
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

        System.out.println(maxDistance(arr));

    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int maxDistance(int[][] grid) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    queue.add(new Pair(i, j));
            }
        }

        int level = -1;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (queue.size() > 0) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                Pair rPair = queue.removeFirst();
                for (int i = 0; i < 4; i++) {
                    int idash = rPair.row + dir[i][0];
                    int jdash = rPair.col + dir[i][1];

                    if (idash < 0 || jdash < 0 || idash >= grid.length || jdash >= grid[0].length ||
                            grid[idash][jdash] == 1)
                        continue;

                    queue.add(new Pair(idash, jdash));
                    grid[idash][jdash] = 1;    
                }
            }
        }

        return level;
    }
}
