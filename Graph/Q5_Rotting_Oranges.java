import java.io.*;
import java.util.ArrayDeque;
// we have given a m*n grid in which three elements are there 0, 1, 2
// 0 : empty cell, 1 : fresh orange, 2 : rotten orange
// in one hour rotten orange start converting fresh orange into rotten orange
// we have to rotten all four direction fresh orange and after all check if any rotten orange is 
// present then return -1 else return level which is total hours taken
public class Q5_Rotting_Oranges {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));

    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    // all four directions in one array : up, right, down, left
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // create a variable fresh and count all fresh oranges (element 1)
    // craete a Pair class in which row and col are their
    // create a queue of Pair class, now add all rotten orange row and col
    // now run a while loop till queue is empty
    // store size in size variable, inside create another while loop and remove and check pair till size 
    // become 0, using size we check level wise rotten oranges
    // now check all four directions
    // if any fresh orange(1) is their reduce fresh count add it's index into queue and mark it visited
    public static int orangesRotting(int[][] grid) {
        int fresh = 0;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.add(new Pair(i, j));
                else if(grid[i][j] == 1) fresh++;
            }
        }

        int level = -1;
        while(queue.size() > 0){
            int size = queue.size();
            level++;
            while(size-- > 0){
                Pair remPair = queue.removeFirst();

                for(int i = 0; i < 4; i++){
                    int rowdash = remPair.row + dir[i][0];
                    int coldash = remPair.col + dir[i][1];

                    if(rowdash >= 0 && coldash >= 0 && rowdash < grid.length && coldash < grid[0].length 
                    && grid[rowdash][coldash] == 1){
                        grid[rowdash][coldash] = 0;
                        queue.add(new Pair(rowdash, coldash));
                        fresh--;
                    }
                }
            }
        }

        if(fresh == 0) return level;
        else return -1;
    }
}
