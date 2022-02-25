import java.util.*;
public class Q27_Count_of_subarray_with_sum_equals_to_k {
    public static int solution(int[] arr, int target){
		// write your code here
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        System.out.println(solution(arr,target));
	}
}
