import java.util.*;
// we have given a string we are required to find out all the permuation of it which is pallindrome
// anbnc divide it into an/2bn/2 + an/2bn/2
// add first permuation with the revrese of same
// if there is any odd char then add it in the middle
// if odd char is more than 1 that means no permutations available so print -1 
public class Q12_All_pallindromic_permutations {
    public static void generatepw(int cs, int len, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		if(cs > len){
			String rev = "";
			for(int i = asf.length() - 1; i >= 0; i--){
				rev += asf.charAt(i);
			}
			String ans = asf;
			if(oddc != null){
				ans += oddc;
			}
			ans += rev;
			System.out.println(ans);
			return;
		}

		for(char ch : fmap.keySet()){
			int freq = fmap.get(ch);
			if(freq > 0){
				fmap.put(ch, freq - 1);
				generatepw(cs + 1, len, fmap, oddc, asf + ch);
				fmap.put(ch, freq);
			}
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        scn.close();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		Character oddc = null;
		int oddCount = 0;
		int len = 0; // len of map after doing freq of all char as freq/2

		for(char ch : fmap.keySet()){
			int freq = fmap.get(ch);
			if(freq % 2 == 1){
				oddc = ch;
				oddCount++;
			}
			fmap.put(ch, freq/2);
			len += freq/2;
		}

		if(oddCount > 1){ // if odd count is more than 1 that means no palindromic permuation is there
			System.out.println(-1);
			return;
		}

	generatepw(1, len, fmap, oddc, "");
	}
}
