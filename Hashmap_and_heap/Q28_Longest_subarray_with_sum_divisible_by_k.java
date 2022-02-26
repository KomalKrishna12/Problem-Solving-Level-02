import java.util.*;
public class Q28_Longest_subarray_with_sum_divisible_by_k {
    public static int solution(int[] arr, int k) {
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
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, k));
    }
}
