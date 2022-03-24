import java.io.*;
// we have given a n*n board we are required to arrange n queens in the board
// this is similar question like combination we have n boxes and r identical items
// here boxes are two dimensional so use row and col
// place two call of recursion one for not placing the queen
// other for pplacing
public class Q30_Queens_combinations_2d_as_2d_box_chooses {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        int nrow = 0;
        int ncol = 0;
        String yasf = ""; // yes call, means queen is placing
        String nasf = ""; // no call, so place - and add a new line tag

        if(col == tq - 1){ // tq is total queen which is equal to row and col so when row is
            // equal to tq - 1 that means we are at last col so set row + 1 and col as 0
            nrow = row + 1;
            ncol = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        }
        else{ // normal so increase col by 1 and row will be same
            nrow = row;
            ncol = col + 1;
            yasf = asf + "q";
            nasf = asf + "-";
        }

        // first call with placing queen, second for not placing
        queensCombinations(qpsf + 1, tq, nrow, ncol, yasf);

        // not placing so use nasf
        queensCombinations(qpsf + 0, tq, nrow, ncol, nasf);

      }
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        queensCombinations(0, n, 0, 0, "");
      }
}
