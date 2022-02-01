import java.util.*;
// in this question we have given two strings s1 and s2
// s1 is large one
// s2 is small one (part of s1)
// we're required to find out smallest substring of s1 which contain all the characters of s2 in any order 
public class Q8_smallest_substring_of_s1_that_contains_all_the_characters_of_s2 {
    // for this we use two hashmap of character and integer
    // in map2 insert all char of s2 and their frequency
    // ans is the smallest substring
    // dmc (desired matching string length, length of string s2)
    // mc (matching length initially 0)
    // i and j are index, both are inially -1
    // i will tarverse into string s1 and j will be used to release the chracter 
    // now create a while loop
    // follow three steps 1> acquire 2> collect ans 3> release
    
    public static String solution(String s1, String s2){
		String ans = "";
		
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i = 0; i < s2.length(); i++){
		    char ch = s2.charAt(i);
		    map2.put(ch, map2.getOrDefault(ch,0)+1);
		}
		int dmc = s2.length();
		int mc = 0;
		int i = -1, j = -1;
		HashMap<Character, Integer> map1 = new HashMap<>();
		while(true){
		   
		    boolean f1 = false;
		    boolean f2 = false;
		    
		    // acquire
            // step 1 acquire charcters into map1 till mc not equals to dmc
            // increase i by 1
            // read char at i and put i with their frequency
            // mark f1 as true so it'll help to continue the loop
		    while(i < s1.length()-1 && mc < dmc){
		        i++;
		        char ch = s1.charAt(i);
		        map1.put(ch, map1.getOrDefault(ch,0)+1);
		        
		        if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)) mc++;
		        f1 = true;
		    }
		    
		    // collect answer and release
            // step 2 collect ans
            // collect ans till j < i && mc equals to dmc
            // now store substring(j+1,i+1) into temp
            // if ans length is 0 or ans length is greater than temp length then update and as temp
            // step 3 release
            // increae j by 1
            // read char at j
            // if ch freq is 1 in map2 then remove that ch 
            // else decrese the freq by 1
            // now check whaether the release ch freq is less than with ch freq in map1 then decrese mc by 1
            // at end mark f2 as true
            // if f1 and f2 both are false then break the loop and return ans
		    while(j < i && mc == dmc){
		        String temp = s1.substring(j+1,i+1);
		        if(ans.length() == 0 || ans.length() > temp.length()) ans = temp;
		        
		        j++;
		        char ch = s1.charAt(j);
		        if(map1.get(ch) == 1) map1.remove(ch);
		        else{
		            map1.put(ch, map1.getOrDefault(ch,0)-1);
		        }
		        
		        if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)) mc--;
		        f2 = true;
		    }
		    if(f1 == false && f2 == false) break;

		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
        scn.close();
		System.out.println(solution(s1,s2));
	}
}
