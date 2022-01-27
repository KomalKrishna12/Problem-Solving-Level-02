import java.util.Scanner;

public class Q5_Largest_sub_array_with_zero_sum {
    public static int solution(int[] arr) {
		// write your code here

		return 0;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
        scn.close();
		System.out.println(solution(arr));
	}
}
