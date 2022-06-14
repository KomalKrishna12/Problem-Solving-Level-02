import java.io.*;
import java.util.*;
// we have given 2*3 board in which 0 to 5 numbers are their
// we can swao 0 in all four direction
// and we have to convert the array into
// 1 2 3
// 4 5 0
// all sorted and 0 in last
// so we use string to do this
public class Q9_Sliding_Puzzle {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[][] arr = new int[2][3];
    
        for (int i = 0; i < 2; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < 3; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(slidingPuzzle(arr));
      }
    
      public static int slidingPuzzle(int[][] board) {
          String target = "123450"; // our target
          
          // using string builder we can create our intial string 
          StringBuilder sb = new StringBuilder();
          for(int i = 0; i < board.length; i++){
              for(int j = 0; j < board[0].length; j++){
                  sb.append(board[i][j]);
              }
          }
          
          String initial = sb.toString();

          // this array will give an array of particular idx for swappig 0 
          // if 0 is at 0 index then swap it with 1 and 3 index
          int[][] swapArr = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
          
          // this will be use and visited string
          HashSet<String> visited = new HashSet<>();
          
          ArrayDeque<String> queue = new ArrayDeque<>();
          queue.add(initial);
          
          int level = 0;
          
          while(queue.size() > 0){
              int size = queue.size();
              while(size-- > 0){
                  String rem = queue.removeFirst();
                  
                  if(rem.equals(target)) return level;
                  
                  int idx = -1; // find index of '0' so we can perform swap with it's nearby
                  for(int i = 0; i < rem.length(); i++){
                      if(rem.charAt(i) == '0'){
                          idx = i;
                          break;
                      }
                  }
                  
                  // now we have index now get all swapping index frim swaparr
                  int[] swap = swapArr[idx];
                   for(int index : swap){
                       String swappedStr = swapChar(rem, idx, index);
                       if(visited.contains(swappedStr)) continue;
                       queue.add(swappedStr);
                       visited.add(swappedStr);
                   }
              }
              level++;
          }
          
          return -1;
      }
      public static String swapChar(String s, int i, int j){
          StringBuilder sb = new StringBuilder(s);
          sb.setCharAt(i, s.charAt(j));
          sb.setCharAt(j, s.charAt(i));
          return sb.toString();
      }
}
