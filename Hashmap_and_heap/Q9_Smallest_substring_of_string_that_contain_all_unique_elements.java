import java.util.*;
// in this question we've given a string and we're required to find the length of smallest substring
// which contains all the unique characters of itself
// eq : str = "aabcbcdbca"
// in str unique string is "abcd"
// so we've to find out the length of smallest substring which contains "abcd"
public class Q9_Smallest_substring_of_string_that_contain_all_unique_elements {
    public static int solution(String str) {
        // we created a ans variable initially it stores the length of str because it is the largest possible
        // substring
        // now create a hashset and add for charcters into set so it'll contain all unique characters
        int ans = str.length();

        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }

        // create two index i and j and initialize both with -1
        int i = -1;
        int j = -1;
        // create a hashmap map which stores frequency of every characters into map
        // now create a while loop which will do 3 steps : acquire, collect and release
        // create two boolean variables to control loop flow
        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            // step 1
            //acquire till map.size() == set.size()
            // this loop will run till i < str.length() -1 and till map.size() is less then set.size()
            // increament i by 1
            // store char at i
            // now put char into map
            while(i < str.length()-1 && map.size() < set.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            // step 2 & 3
            // collect and release
            // this loop will run till j < i and map.size() == set.size()
            // templen will store the length of substring
            // now increament the j
            // store char at j
            // now check freq of j
            // if it's freq is 1 then remove that char
            // else reduce the freq by 1 
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
