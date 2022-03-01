import java.util.HashMap;
import java.util.Scanner;
// given a string s and required to find out the index of first non repeating character
public class Q45_First_non_repeating_character {
    // create a hashmap and add all the characters into map with it's frequency
    // now traverse into the string and check the char freq, if it is 1 then return the index
    // at end of loop return -1 that means there is no character which is non repeating 
    public static int solution(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.get(ch) == 1) return i;
        }
   
		return -1;
	 }
	 
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s= scn.next();
        scn.close();
		System.out.print(solution(s));
	}
}
