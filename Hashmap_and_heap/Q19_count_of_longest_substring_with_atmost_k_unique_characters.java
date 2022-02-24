import java.util.*;
// this is same question like Q18 but here we want to find out tottal count of longest sustring 
// with atmost k unique characters
public class Q19_count_of_longest_substring_with_atmost_k_unique_characters {
    
    public static int solution(String str, int k) {
		int ans = 0;
		
        int i = -1, j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while(true){

            while(i < str.length() - 1){
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.size() <= k){
                    ans += i - j;
                }
                else{
                    break;
                }
            }

            // this is the condition where we are at last character of string and map size is less
            // than equal to k so we can break from loop
            if(i == str.length() - 1 && map.size() <= k) break;

            while(j < i){
                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1) map.remove(ch);
                else map.put(ch, map.get(ch) - 1);
                if(map.size() > k) continue;
                else{
                    ans += i - j;
                    break;
                }
            }

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
