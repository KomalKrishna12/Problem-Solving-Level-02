import java.util.*;
// applying Dijekstra Algorithm
// in priority queue store row, col and max so far
// while adding it's 4 adjacent in msf store max of current grid[i][j] and removed msf
public class Q16_Swim_in_rise_water {
    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};
        System.out.println(swimInWater(grid));
    }
    public static int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        boolean[][] vis = new boolean[grid.length][grid.length];
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            if(rem.row == grid.length - 1 && rem.col == grid.length - 1){
                return rem.msf;
            }
            
            if(vis[rem.row][rem.col] == true){
                continue;
            }
            
            vis[rem.row][rem.col] = true;
            
            for(int i = 0; i < 4; i++){
                int rdash = rem.row + dir[i][0];
                int cdash = rem.col + dir[i][1];
                
                if(rdash < 0 || cdash < 0 || rdash >= grid.length || cdash >= grid.length || vis[rdash][cdash] == true){
                    continue;
                }
                
                pq.add(new Pair(rdash, cdash, Math.max(rem.msf, grid[rdash][cdash])));
            }
        }
        return 0;
    }
    public static class Pair implements Comparable<Pair>{
        int row, col, msf;
        Pair(int row, int col, int msf){
            this.row = row;
            this.col = col;
            this.msf = msf;
        }
        public int compareTo(Pair o){
            return this.msf - o.msf;
        }
    }
}
