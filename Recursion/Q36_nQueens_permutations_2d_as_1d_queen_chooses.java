import java.io.*;
// in this question we have to print all permuattions of queens(not identical)
// so their is no need of last index
// we traverse from cell 0 to n*n
// in IsQueenSafe we have to check all directions : vertically up and down, horizontally up and down
// all four diagonals
public class Q36_nQueens_permutations_2d_as_1d_queen_chooses {
    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // vertically up
        for(int i = row, j = col; i >= 0; i--){
            if(chess[i][j] != 0) 
            return false;
        }
        
        // vertically down
        for(int i = row, j = col; i < chess.length; i++){
            if(chess[i][j] != 0) 
            return false;
        }

        // horizontally up
        for(int i = row, j = col; j >= 0; j--){
            if(chess[i][j] != 0) 
            return false;
        }
        
        // horizontally down
        for(int i = row, j = col; j < chess.length; j++){
            if(chess[i][j] != 0) 
            return false;
        }

        // diagonally up
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] != 0) 
            return false;
        }
        
        // diagonally down
        for(int i = row, j = col; i < chess.length && j < chess.length; i++, j++){
            if(chess[i][j] != 0) 
            return false;
        }

        // reverse diagonally up
        for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] != 0) 
            return false;
        }
        
        // reverse diagonally down
        for(int i = row, j = col; i < chess.length && j >= 0; i++, j--){
            if(chess[i][j] != 0) 
            return false;
        }

        return true;

    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] != 0 ? "q" + chess[row][col] + "\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int cell = 0; cell < chess.length * chess.length; cell++){
            int row = cell / chess.length;
            int col = cell % chess.length;
            if(chess[row][col] == 0 && IsQueenSafe(chess, row, col)){
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
