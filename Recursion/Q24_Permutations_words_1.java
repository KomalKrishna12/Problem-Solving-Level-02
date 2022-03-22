import java.util.*;
import java.io.*;

public class Q24_Permutations_words_1 {
    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        // write your code here
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: str.toCharArray()){
          if(fmap.containsKey(ch)){
            fmap.put(ch, fmap.get(ch) + 1);
          } else {
            fmap.put(ch, 1);
          }
        }
    
        generateWords(1, str.length(), fmap, "");
      }
}
