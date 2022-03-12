import java.util.*;
// this is the same problem which we did in level1 recursion backtracking
// in this we use Banch and bound algo to solve this
// we creaet theree array one for columns(cols[]), one for normal diagonals(ndia[]) and other for
// reverse diagona(rdia[])
// basically a queen can kill 8 positions, the whole col in which queen is present, the whole row 
// in which queen is present and all normal diagonal as well as reverse diagonals
// so whenever we put our queen in a particular row & col make their columns true
// suppose row is 1 col is 2 so make cols[2] true
// for diagonal fill array with row + col so marl 1 + 2 as true
// for reverse fill array with row - col + board length - 1 as true
public class Q2_N_Queens_branch_and_bound {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndia = new boolean[2 * n - 1];
        boolean[] rdia = new boolean[2 * n - 1];

        solve(board, 0, cols, ndia, rdia, "");

    }

    public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndia, boolean[] rdia, String asf) {
        // base case
        if (row == board.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (cols[col] == false && ndia[row + col] == false && rdia[row - col + board.length - 1] == false) {
                board[row][col] = true;
                cols[col] = true;
                ndia[row + col] = true;
                rdia[row - col + board.length - 1] = true;
                solve(board, row + 1, cols, ndia, rdia, asf + row + "-" + col + ", ");
                board[row][col] = false;
                cols[col] = false;
                ndia[row + col] = false;
                rdia[row - col + board.length - 1] = false;
            }
        }
    }
}
