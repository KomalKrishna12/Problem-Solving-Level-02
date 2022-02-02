import java.util.*;
public class Q9_Smallest_substring_of_string_that_contain_all_unique_elements {
    public static int solution(String str) {
        int ans = str.length();

        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            //acquire till map.size() == set.size()
            while(i < str.length()-1 && map.size() < set.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            //collect and release
            while(j < i && map.size() == set.size()){
                int templen = i - j;
                if(templen < ans) ans = templen;

                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1) map.remove(ch);
                else{
                    map.put(ch, map.get(ch) - 1);
                }
                f2 = true;
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
