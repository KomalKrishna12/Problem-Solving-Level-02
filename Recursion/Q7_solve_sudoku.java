import java.util.*;
// we have given a sudoku like 2d array we are required to fill it
// in sudoku we have to check in the row and column and the submatrix then we set value from
// 1 to 9 
public class Q7_solve_sudoku {
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
      }

      public static boolean isValid(int[][] board, int i, int j, int pos){

        // check in the row, so only col change
        for(int col = 0; col < board[0].length; col++){
            if(board[i][col] == pos) return false;
        }

        // check in the column, so only row change
        for(int row = 0; row < board.length; row++){
            if(board[row][j] == pos) return false;
        }

        // check in the submatrix of size 3 * 3
        // for that we need to find out the start index of that small submatrix
        // smi = i / 3 * 3, smj = j / 3 * 3
        // it'll give us the small matrix ith and jth index now using that we can
        // traverse into the submatrix

        int smi = i / 3 * 3;
        int smj = j / 3 * 3;
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                // using (smi + row) & (smj + col) we can traverse into each index of small matrix
                if(board[smi + row][smj + col] == pos) return false;
            }
        }
        
        return true;

      }
    
      public static void solveSudoku(int[][] board, int i, int j) {
        
        if(i == board.length){
            display(board);
            return;
        }

        int ni = 0; // next i
        int nj = 0; // next j

        if(j == board[0].length - 1){
            ni = i + 1;
            nj = 0;
        }
        else{
            ni = i;
            nj = j + 1;
        }

        if(board[i][j] != 0) solveSudoku(board, ni, nj);

        else{

            for(int pos = 1; pos <= 9; pos++){ // pos : possible values

                if(isValid(board, i, j, pos) == true){
                    board[i][j] = pos;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }

            }

        }

      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            arr[i][j] = scn.nextInt();
          }
        }
        scn.close();
    
        solveSudoku(arr, 0, 0);
      }
}
