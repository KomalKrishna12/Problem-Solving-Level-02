import java.io.*;
// this is similar ques like Q32 in that we use two for loops, one for rest col and another for next 
// row with col from 0 to end
// so here we use only one loop
// we'll make our 2d array as 1d using cell value
// cell value : 0 to n*n - 1
// row = cell / 4 (use divide bcoz we want complete row)
// col = cell % 4 (use modulas bcoz we want rest col)
// cell = row * 4 + col
// so in lcno we have our last cell no
// start loop from lcno + 1 to chess.length * chess.length
// find out row and col
// check that box is false , if yes then mark is at true and call for next and pass cell as last cell no

public class Q34_Queens_combinations_2d_as_1d_queen_chooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    if (chess[row][col])
                        System.out.print("q\t");
                    else
                        System.out.print("-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int cell = lcno + 1; cell < chess.length * chess.length; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;

            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, cell);
            chess[row][col] = false;

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
