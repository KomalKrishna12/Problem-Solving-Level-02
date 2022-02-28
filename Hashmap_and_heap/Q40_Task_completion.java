import java.util.*;
public class Q40_Task_completion {
    public static void completeTask(int n, int m, int[] arr) {
		// write your code here

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
        scn.close();
		completeTask(n, m, num);
	}
}
