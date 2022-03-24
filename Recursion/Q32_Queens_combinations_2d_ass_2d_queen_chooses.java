import java.io.*;
// this is the same question but here we will choose queens on levels and spots as boxes
// so in row and col prev queen position is given
// so firstly call for all rest col for the given row
// now call for row+1 and col(0)
public class Q32_Queens_combinations_2d_ass_2d_queen_chooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int row, int col) {
        if(qpsf == tq){
            for(int i = 0; i < chess.length; i++){
                for(int j = 0; j < chess.length; j++){
                    if(chess[i][j]) System.out.print("q\t");
                    else System.out.print("-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int j = col + 1; j < chess.length; j++){
            chess[row][j] = true; // fill all left col for row
            queensCombinations(qpsf + 1, tq, chess, row, j);
            chess[row][j] = false;
        }

        // now start filling from next row and col from 0 to chess.length
        for(int i = row + 1; i < chess.length; i++){
            for(int j = 0; j < chess.length; j++){
                chess[i][j] = true;
                queensCombinations(qpsf + 1, tq, chess, i, j);
                chess[i][j] = false;
            }
        }

      }
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
    
        queensCombinations(0, n, chess, 0, -1);
        // row 0 col -1 is not any valid possitions so we pass this
        // from function firstly we fill all col then from next row and 0th col
      }
}
