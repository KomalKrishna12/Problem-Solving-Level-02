import java.util.Scanner;

public class Q41_Pairs_with_given_sum_two_sorted_matrices {
    public static int solve(int[][] num1, int[][] num2, int k) {
		// write your code here

		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
        sc.close();
		System.out.println(solve(mat1, mat2, K));

	}
}
