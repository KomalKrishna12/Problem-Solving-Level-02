import java.io.*;
// same question like Q38 but in addition in this question we have infinite no of coins
// suppose coins are 2, 3, 5, 7 and amt is 12
// ans : 2, 2, 2, 2, 2, 2 so we can use multiple coins

// first call if for all same coins 
// second for not using
// for first we use a for loop which run reversely from tamt / coins[i] is this is greater than 1 that means
// we can use this
public class Q39_Coin_change_combination_2 {
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if(amtsf == tamt){
            System.out.println(asf + ".");
            return;
        }
        if(i == coins.length){
            if(amtsf == tamt) System.out.println(asf + ".");
            return;
        }

        // suppose coins[i] = 2 and target is 12 so j = 12/2 = 6 which is greater than 1 so we can 
        // use 6 coins max
        // now this second loop will use to print arangement so it'll print 2 with "-" 
        for(int j = tamt / coins[i]; j >= 1; j--){
            String part = "";
            for(int k = 0; k < j; k++){
                part += coins[i] + "-";
            }
            coinChange(i + 1, coins, amtsf + coins[i] * j, tamt, asf + part);
        }
        
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
