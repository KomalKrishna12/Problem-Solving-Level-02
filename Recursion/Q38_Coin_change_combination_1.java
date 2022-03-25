import java.io.*;
// we have given n denotes total no of coins
// then we have n coins
// amt is the target amount
// we are required to print all possible combination so that amt will be created
// so we have two options for every leve(in level we place n coins)
// one : we can take that coin
// two : we cannot take that coin
// so call for these two and in base check when i equal to coins.length, check amt equal to tamt the print
public class Q38_Coin_change_combination_1 {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        if(i == coins.length){
            if(tamt == amtsf){
                System.out.println(asf + ".");
            }
            return;
        }

        // adding the coins[i], so add it into amtsf(amount so far) and also add in asf
        coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");

        // not adding the coins[i] so simply call for next index
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        
        coinChange(0, coins, 0, amt, "");
    }
}
