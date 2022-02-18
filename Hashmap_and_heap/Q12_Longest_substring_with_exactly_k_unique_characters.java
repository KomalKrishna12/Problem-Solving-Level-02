import java.util.*;
public class Q12_Longest_substring_with_exactly_k_unique_characters{
    public static int solution(String str, int k){
        int ans = 0;

		int i = -1, j = -1;
		HashMap<Character, Integer> map = new HashMap<>();

		while(true){
			boolean f1 = false, f2 = false;

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
