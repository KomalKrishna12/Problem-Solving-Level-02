import java.util.*;
// in this question we're given a string and k, we're required to find out the length of longest substring 
// which is having k unique characters
// ex : 
// str : "aabacbebebe", k = 3
// ans : 7 
// the longest substring is "cbebebe" in this total 3 unique characters and the length of this substring
// is 7
public class Q12_Longest_substring_with_exactly_k_unique_characters{
    public static int solution(String str, int k){
        int ans = 0;

		int i = -1, j = -1;
		HashMap<Character, Integer> map = new HashMap<>();

		// in this we run two while loop inside this one is for acquire and other one is for release
		while(true){
			boolean f1 = false, f2 = false;

			// acquire
			// mark f1 true
			// increament i by 1
			// now increase the freq of char ch by 1 and put it into hashmap
			// check the size of map
			// if less then k then continue
			// else if map size is equal to k then calculate the len
			// compare the length and swap
			// else break
			while(i < str.length() - 1){
				f1 = true;
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if(map.size() < k) {
					continue;
				}
				else if(map.size() == k){
					int len = i - j;
					if(len > ans){
						ans = len;
					}
				}
				else{
					break;
				}
			}

			// if j is less then i 
			// mark f2 as true
			// increase j by 1
			// now store char at jth index into ch variable
			// if freq of ch is 1, then remove ch
			// else decrease it's freq by 1
			// now check if map size is greater then k then continue release
			// else if size is equal to k then compare length and swap
			// then break
			while(j < i){
				f2 = true;
				j++;
				char ch = str.charAt(j);
				if(map.get(ch) == 1){
					map.remove(ch);
				}
				else{
					map.put(ch, map.get(ch) - 1);
				}
				if(map.size() > k){
					continue;
				}
				else if(map.size() == k){
					int len = i - j;
					if(ans < len){
						ans = len;
					}
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
