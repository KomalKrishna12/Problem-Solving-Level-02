import java.util.HashMap;
import java.util.Scanner;
// in this ques we have given four arrays 
// we are required to find out the total count of elements which can make A[a] + B[b] + C[c] + D[d] = 0;
public class Q43_Quadruple_sum2 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// create a hashmap and store e1(elemet of array A) + e2(element of array B) into the map
		// check target - [e1(element of array C) + e2(element of array D)] into the map
		// if it is available then increase the count
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int e1 : A){
			for(int e2 : B){
				map.put(e1 + e2, map.getOrDefault(e1 + e2, 0) + 1);
			}
		}

		int count = 0;
		int target = 0; // given in question 

		for(int e1 : C){
			for(int e2 : D){
				count += map.getOrDefault(target - (e1 + e2), 0);
			}
		}


		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];
		int[] arr4 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr3[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr4[i] = sc.nextInt();
		}
        sc.close();
		System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
	}
}
