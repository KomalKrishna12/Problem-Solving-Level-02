import java.io.*;
public class Q34_Queens_combinations_2d_as_1d_queen_chooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
    
        queensCombinations(0, n, chess, -1);
      }
}
