import java.util.*;
// in this question we've given two strings s1 and s2
// we're required to validate them that they are anagram or not
// if two strings are anagram that means there size is same, occurence of each character is same in
// both the strings their order can be changed
public class Q23_Valid_anagrams {
    // create a hashmap
    // put character of s1 with their freq
    // now start traversing s2
    // if char freq is 1 then remove that char from map
    // else if char is not available that means this is not anagram so return false
    // else decrese it's freq by 1
    // at end check the size of map
    // if size is 0 that means it is anagram 
    public static boolean solution(String s1, String s2){
		// write your code here

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
