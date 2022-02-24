import java.util.HashMap;
import java.util.Scanner;

// in this question we've given a string and k we're required to find out the length of longest 
// substring in which atmost k unique characters are there
// atmost k means : total k or less then k unique characters
public class Q18_Longest_substring_with_at_most_k_unique_characters {
    public static int solution(String str, int k) {
		int ans = 0;
		
        int i = -1, j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(true){
            boolean f1 = false, f2 = false;

            // acquire
            // put characters into map till map size becomes greater than k 
            // if less then or equal then calculate size of substring and update ans
            // else break the loop and start release
            while(i < str.length() - 1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.size() <= k){
                    int len = i - j;
                    ans = Math.max(ans, len);
                }
                else break;
            }

            // if ch frequenecy is 1 then remove that else decrese its frequenecy by 1
            // now check the size of map if size is greater than k then continue release
            // else calculate the length and update ans
            while(j < i){
                f2 = true;
                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1) map.remove(ch);
                else map.put(ch, map.get(ch) - 1);
                if(map.size() > k) continue;
                else{
                    int len = i - j;
                    ans = Math.max(ans, len);
                    break;
                }
            }

            if(f1 == false && f2 == false) break;
        }

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
		System.out.println(solution(str,k));
	}
}
