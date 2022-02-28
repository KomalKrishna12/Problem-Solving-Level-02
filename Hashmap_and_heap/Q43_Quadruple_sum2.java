import java.util.Scanner;

public class Q43_Quadruple_sum2 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// write your code here

		return 0;
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
