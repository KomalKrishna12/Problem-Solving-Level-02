import java.util.*;
// in this qquestion we've given a sring we're reuired to find out the length of largest non repeating substring
// eg : aabcbcdbca
// in this string "dbca" is the largest non repeating subtring so ans will be 4
public class Q10_longest_substring_of_the_given_string_that_contains_all_non_repeating_characters {
    public static int solution(String str) {
		//  in this question we perform two steps
		// step 1 : acquire till map become invalid(map become invalid if the freq of ch is more than 1)
		// step 2 : release till map become valid
		// create a freq hashmap map
		int ans = 0;
		
		int i = -1, j = -1;
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
		    boolean f1 = false, f2 = false;
			// step : 1 acquire
			// increament i by 1 
			// store char at i
			// put char with freq if it's freq is 2 then break this loop else calculate the len
			// if len is greater than ans then update ans
		    while(i < str.length()-1){
		        f1 = true;
		        i++;
		        char ch = str.charAt(i);
		        map.put(ch, map.getOrDefault(ch,0) + 1);
		        
		        if(map.get(ch) == 2) break;
		        else{
		            if(ans < (i-j)) ans = i - j;
		        }
		    }
			// step : release
			// increament j by 1
			// store char at j
			// put char into map by reducing it's freq by 1
			// if char freq is 1 then break this loop 
		    while(j < i){
		        f2 = false;
		        j++;
		        char ch = str.charAt(j);
		        map.put(ch, map.get(ch) - 1);
		        if(map.get(ch) == 1) break;
		    }
		    if(f1 == false && f2 == false) break;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        scn.close();
		System.out.println(solution(str));
	}
}
