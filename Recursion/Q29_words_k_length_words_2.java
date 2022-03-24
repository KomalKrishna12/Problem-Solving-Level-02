import java.util.*;
import java.io.*;
// different approach
// at level we place smaller item which is spots means k
// hashset is used to check wheather the char is already used or not
public class Q29_words_k_length_words_2 {

    public static void generateStrings(int cs, String ustr, int ts, HashSet<Character> set, String asf){
        if(cs > ts){
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            if(set.contains(ch) == false){
                set.add(ch);
                generateStrings(cs + 1, ustr, ts, set, asf + ch);
                set.remove(ch);
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
    
        generateStrings(1, ustr, k, new HashSet<>(), "");
       
      }
}
