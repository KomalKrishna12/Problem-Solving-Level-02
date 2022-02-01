import java.util.*;
public class Q8_smallest_substring_of_s1_that_contains_all_the_characters_of_s2 {
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
		    while(i < s1.length()-1 && mc < dmc){
		        i++;
		        char ch = s1.charAt(i);
		        map1.put(ch, map1.getOrDefault(ch,0)+1);
		        
		        if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)) mc++;
		        f1 = true;
		    }
		    
		    // collect answer and release
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
