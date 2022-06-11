import java.io.*;
// this is similar ques like number of islands
// here we have to count no of 1 from which we will stay in water not go to border
// so we will start finding conncetd components of corner 1's and mark it as 0 so we will mark
// all corner connected 1's 0 so no one go at border

public class Q2_Number_of_Enclaves {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numEnclaves(arr));

    }

    public static int numEnclaves(int[][] arr) {
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                // check if it is border and it's value is 1 then call dfs
                if(i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1){
                    if(arr[i][j] == 1){
                        dfs(arr, i, j);
                    }
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1) count++;
            }
        }

        return count;
    }

    // in dfs mark ith and jth row col as 0 and call for all four directions
    // but in condition check for boundary conditions and 0's also 
    public static void  dfs(int[][] arr, int i, int j){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0) return;
        arr[i][j] = 0;
        dfs(arr, i, j+1);
        dfs(arr, i-1, j);
        dfs(arr, i, j-1);
        dfs(arr, i+1, j);
    }
}
