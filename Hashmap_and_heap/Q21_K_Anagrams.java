import java.util.*;
// in this question we are given two string and k
// we've to check that in the if we're creating anagram and we can replace upto k characters then it
// is valid string or not
// given str1 and str2
// create anagram for them
// suppose we can create anagram but by replacing two character then that k should be k or greater than k
public class Q21_K_Anagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
        if(str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();

        // we are adding characters of str1 and check by traversing into str2
        for(int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int count = 0;

        // if freq of ch is greater than 0 then decrese it's occurence by 1
        for(int i = 0; i < str2.length(); i++){
            char ch = str2.charAt(i);
            if(map1.getOrDefault(ch, 0) > 0){
                map1.put(ch, map1.get(ch) - 1);
            }
        }

        // at end add all the occurece that is our extra characters which are needed to be replaced
        // if count is greater than k then that is not valid  
        for(char ch : map1.keySet()){
            count += map1.get(ch);
        }

        if(count > k) return false;
        else return true;
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
