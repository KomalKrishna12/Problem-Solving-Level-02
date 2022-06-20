import java.util.*;
import java.io.*;
// we have given a m * n array which is initially filled with 0
// 0 denotes sea
// we have given an array directions which stores pairs
// in each pair we have row and col which denotes any particulare index which we convert to land
// so store sea
// now after all pairs their are chances that they are adjacent lands so then can convert into one
// land
// after every pair we have to add the land count into the list
// solution : we use DSU in this, it is 2d array so we use cell no 
// cell no = row * column length + col

public class Q25_Number_of_island2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
        int q = Integer.parseInt(st[2]);
    
        int[][] pos = new int[q][2];
        for (int i = 0; i < q; i++) {
          st = br.readLine().split(" ");
          pos[i][0] = Integer.parseInt(st[0]);
          pos[i][1] = Integer.parseInt(st[1]);
        }
    
        System.out.println(numIslands2(m, n, pos));
      }
    
      // create two arrays parent and rank
      // intially aprent is filled with -1
      // now start working on pairs
      // create cell no with the pair values
      // now check if the cell no of parent is not -1 that means it is already merged with land
      // so simply add count and continue
      // else add cellno into parent's cell
      // mark rank of that cellno as 1
      // start traversing into the nbrs
      // if any one prenset then merge and decrse the count
      public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        int[] parent = new int[m*n];
        int[] rank = new int[m*n];
        Arrays.fill(parent, -1);
        int count = 0;
        
        for(int[] pos : positions){
            int row = pos[0];
            int col = pos[1];
            int cellno = row * n + col;
            if(parent[cellno] != -1){
                // means already merged with some island so simply add count into list and continue;
                ans.add(count);
                continue;
            }
            
            parent[cellno] = cellno;
            count++;
            rank[cellno] = 1;
            
            for(int i = 0; i < 4; i++){
                int rowdash = row + dir[i][0];
                int coldash = col + dir[i][1];
                int cellnodash = rowdash * n + coldash;
                
                // parent[cellnodash] == -1 means (rowdash, coldash) is 0 so no land available
                if(rowdash < 0 || coldash < 0 || rowdash >= m || coldash >= n || parent[cellnodash] == -1){
                    continue;
                }
                
                // now we have x as cellno and y as cellnodash so find their leader and if their leader is not equal then merge them
                // according to their rank
                
                int lx = find(cellno, parent);
                int ly = find(cellnodash, parent);
                
                if(lx != ly){
                    if(rank[lx] > rank[ly]){
                        parent[ly] = lx;
                    }
                    else if(rank[ly] > rank[lx]){
                        parent[lx] = ly;
                    }
                    else{
                        parent[ly] = lx;
                        rank[lx]++;
                    }
                    count--; // now lx and ly is merged so decrese one count of sea
                }
            }
            
            // after every pair we have to add the count in ans list
            ans.add(count);
        }
        return ans;
    }
    
    public static int find(int x, int[] parent){
        if(x == parent[x]) return x;
        
        int temp = find(parent[x], parent);
        parent[x] = temp;
        
        return temp;
    }
}
