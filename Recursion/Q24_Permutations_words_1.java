import java.util.*;
import java.io.*;
// we have given a word we are required to print all the permutations 
public class Q24_Permutations_words_1 {
    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        if(cs > ts){
            System.out.println(asf);
            return;
        }

        // run an loop for fmap and check all char
        // if their freq is greater than 0 then decrease the freq and call for next char
        for(char ch : fmap.keySet()){
            if(fmap.get(ch) > 0){
                fmap.put(ch, fmap.get(ch) - 1);
                generateWords(cs + 1, ts, fmap, asf + ch);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
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
