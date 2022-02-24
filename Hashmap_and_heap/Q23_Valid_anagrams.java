import java.util.*;
// in this question we've given two strings s1 and s2
// we're required to validate them that they are anagram or not
// if two strings are anagram that means there size is same, occurence of each character is same in
// both the strings their order can be changed
public class Q23_Valid_anagrams {
    // first method
    // create a hashmap
    // put character of s1 with their freq
    // now start traversing s2
    // if char freq is 1 then remove that char from map
    // else if char is not available that means this is not anagram so return false
    // else decrese it's freq by 1
    // at end check the size of map
    // if size is 0 that means it is anagram 

    // second method
    // create two hasmap map1 and map2
    // in map1 store s1 character with their occurence and in map2 store for s2
    // compare both maps using map1.equals(map2)
    // if true return true 
    public static boolean solution(String s1, String s2){
		HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(map.containsKey(ch) == false) return false;
            else if(map.get(ch) == 1) map.remove(ch);
            else map.put(ch, map.get(ch) - 1);
        }

        if(map.size() == 0) return true;

		return false;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
        scn.close();
		System.out.println(solution(s1,s2));
	}
}
