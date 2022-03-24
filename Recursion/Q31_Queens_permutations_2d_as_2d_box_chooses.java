import java.io.*;
public class Q31_Queens_permutations_2d_as_2d_box_chooses {
    public static void queensPermutations(int qpsf, int tq, int[][] queens) {
        if (qpsf == tq) {
            for (int i = 0; i < queens.length; i++) {
              for (int j = 0; j < queens[0].length; j++) {
                if (queens[i][j] == 0)
                  System.out.print("-\t");
                else
                  System.out.print("q" + queens[i][j] + "\t");
              }
              System.out.println();
            }
            System.out.println();
            return;
          }
      
          for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens[0].length; j++) {
              if (queens[i][j] == 0) {
                queens[i][j] = qpsf + 1;
                queensPermutations(qpsf + 1, tq, queens);
                queens[i][j] = 0;
              }
            }
          }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] queens = new int[n][n];
    
        queensPermutations(0, n, queens);
      }
}
