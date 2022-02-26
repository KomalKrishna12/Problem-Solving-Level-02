import java.util.*;
public class Q30_Longest_subarray_with_equal_no_of_0s_and_1s {
    public static int solution(int[] arr) {
        // write your code here

        return 0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
