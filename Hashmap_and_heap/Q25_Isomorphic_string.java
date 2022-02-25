import java.util.*;
// in this question we've given two strings s and t
// we're required to check wheather strings are isomorphic or not 
// isomorphic means str1 : abacba, str2 : xyxzyx
// a - x, b - y, c - z
// so in str1 a pointing to x , b to y and c to z and their is no rule violation
// if a-x, b-y, c-x, d-z in this a is pointing to x and again c is pointing to x which is not 
// possible is isomorphic strings
public class Q25_Isomorphic_string {
    public static boolean isIsomorphic(String s, String t) {
		// for isomorphic strings the length have to be same
        // create two maps, map1 will store char of string s and pointing char of t
        // map2 will store char and boolean that means char is pointing to some char already
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();

        // start traversing to the string
        // ch1 store char at string s
        // ch2 store char at string t
        // now check map1 contains ch1 or not
        // if yes then check map2 that map2 key ch2 is true or not, true means it is already some char's pointer
        // else check map2 that map2 contains ch2 or not if yes then it is already some char's index
        // else put ch1 as key and ch2 as value in map1
        // put ch2 as key and true as value in map2
        // at end return true
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2) return false;
            }
            else{
                if(map2.containsKey(ch2)) return false;
                else{
                    map1.put(ch1, ch2);
                    map2.put(ch2, true);
                }
            }
        }

		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
        scn.close();
		System.out.print(isIsomorphic(A, B));
	}
}
