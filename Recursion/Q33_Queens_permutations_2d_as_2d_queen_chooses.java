import java.io.*;
// in this we are required to print all permutations so now restricted on arrangements 
// bcoz queens are diff
// so start row col from 0,0 and check if it is 0 then insert queen and call
public class Q33_Queens_permutations_2d_as_2d_queen_chooses {
    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf == tq){
            for(int i = 0; i < chess.length; i++){
                for(int j = 0; j < chess.length; j++){
                    if(chess[i][j] == 0) System.out.print("-\t");
                    else System.out.print("q" + chess[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess.length; j++){
                if(chess[i][j] == 0){
                    chess[i][j] = (qpsf + 1);
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}
