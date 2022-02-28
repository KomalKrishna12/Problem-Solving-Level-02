import java.util.HashMap;
import java.util.Scanner;

public class Q41_Pairs_with_given_sum_two_sorted_matrices {
    // in this ques we have given two matrices num1 and num2 and k
    // we are reuired to count total pairs from num1 and num2 which can sum up and give sum k
    public static int solve(int[][] num1, int[][] num2, int k) {
        // create a hashmap and store num1 elements with it's freq
        // create a count variable and increase count whenever we got target sum k
        // now traverse into num2 and store num2[i][j] into val
        // now find out rest by dividing it into k
        // if rest is in map then add rest freq into count that means that many times we can get target
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num1[i].length; j++){
                map.put(num1[i][j], map.getOrDefault(num1[i][j], 0) + 1);
            }
        }
		int count = 0;

        for(int i = 0; i < num2.length; i++){
            for(int j = 0; j < num2[i].length; j++){
                int val = num2[i][j];
                int rest = k - val;
                if(map.containsKey(rest)) count += map.get(rest);
            }
        }

		return count;
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
