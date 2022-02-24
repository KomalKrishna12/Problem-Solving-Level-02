import java.util.*;
public class Q21_K_Anagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
		// write your code here

		return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
        s.close();
		System.out.println(areKAnagrams(str1, str2, k));

	}
}
