import java.util.HashMap;
import java.util.Scanner;
// this is similar question like Q12
// in this ques we're required to calculate total no of substring havong exactly k unique characters
public class Q13_Count_of_substring_with_exactly_k_unique_characters {

    // for this we use two hashmap
    // large hashmap contains max k size and small hashmap contain max k-1 size 
    public static int solution(String str, int k){

        // if k == 1 then their is no need to create two hashmap
        // ans will store the total count of substring
        if(k == 1) return solutionforkone(str);
		int ans = 0;

        // is - small index, ib - big index and j is for release
        int is = -1, ib = -1, j = -1;

        // maps is for small map whose size will be k-1 and mapb is for big hashmap whose size will be k
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapb = new HashMap<>();

        // store elemenst into mapb till size is k
        // if size is k+1 then remove the ch and decrease ib by 1
        // do same with maps for size k-1
        while(true){
            boolean f1 = false, f2 = false, f3 = false;
            while(ib < str.length() - 1){
                f1 = true;
                ib++;
                char ch = str.charAt(ib);
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);

                if(mapb.size() == k + 1){
                    removeChar(mapb, ch);
                    ib--;
                    break;
                }
            }

            while(is < ib){
                f2 = true;
                is++;
                char ch = str.charAt(is);
                maps.put(ch, maps.getOrDefault(ch, 0) + 1);

                if(maps.size() == k){
                    removeChar(maps, ch);
                    is--;
                    break;
                }
            }

            // now this loop is for release
            // firstly check the size of both map if size is correct then add diff between ib and is that is
            // the total no of substring which can be formed of k unique characters 
            // now increase j by 1
            // remove jth char from both maps
            // if size of any one map is fails then break
            while(j < is){
                f3 = true;
                if(mapb.size() == k && maps.size() == k - 1){
                    ans += ib - is;
                }

                j++;
                char ch = str.charAt(j);
                removeChar(mapb, ch);
                removeChar(maps, ch);

                if(mapb.size() < k || maps.size() < k - 1) break;
            }
            if(f1 == false && f2 == false && f3 == false) break;
        }

		return ans;
	}
    public static void removeChar(HashMap<Character, Integer> map, char ch){
            if(map.get(ch) == 1){
                map.remove(ch);
            }
            else{
                map.put(ch, map.get(ch) - 1);
            }
    }

    public static int solutionforkone(String str){
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, j = -1;

        while(true){
            boolean f1 = false, f2 = false;
            while(i < str.length() - 1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.size() == 2){
                    removeChar(map, ch);
                    i--;
                    break;
                }
            }
            while(j < i){
                f2 = true;
                if(map.size() == 1){
                    ans += i - j;
                }
                j++;
                char ch = str.charAt(j);
                removeChar(map, ch);
                if(map.size() == 0) break;
                
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
