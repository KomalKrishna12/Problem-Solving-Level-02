import java.util.*;
public class Q18_Largest_number_possible_after_at_most_k_Swaps {
    static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		max = str;
        scn.close();
		findMaximum(str, k);
		System.out.println(max);
	}
}
