import java.util.*;

public class Q10_Friends_pairing2 {
    static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        // base case when i is greater than n then print asf with counter bcoz we want to print
        // in an order, after print increament the counter value by 1
        if(n > i){
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }
        if (used[i] == true) // that means this i is already used so just call solution for next level
            solution(i + 1, n, used, asf);
        else {
            // that mean this i value is not used so firstly mark is as true in used[] then call
            // solution by adding for single and then multiple pair options which is possible

            // for single
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ") "); 

            // for pairs we have multiple options which start from i+1 till n, including n
            // i+1 bcoz we want unique pairs, so start loop 
            for(int j = i + 1; j <= n; j++){
                used[j] = true;
                solution(i + 1, n, used, asf + "(" + i + j + ") ");
                used[j] = false;
            }
            used[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");
    }
}
