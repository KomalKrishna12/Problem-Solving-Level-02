import java.io.*;
import java.util.*;
// this is similar ques like Q29 but we can use char repetitive
// so we use hashmap to contains it's freq
// in level we use spots(k)
// so run the loop from 0 to end(length of unique string)
// now check it's freq, if it is greater than 0 then decrease its freq and call for next spot and
// in asf add ch
// base case when cs(curr spot) == ts(total spot) print the asf and return
public class Q46_Words_k_length_words_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        HashMap<Character, Integer> fmap = new HashMap<>();
        String ustr = "";
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(fmap.containsKey(ch)){
                fmap.put(ch, fmap.get(ch) + 1);
            }
            else{
                fmap.put(ch, 1);
                ustr += ch;
            }
        }
        
        fun(ustr, fmap, 0, k, "");
    
      }
      
      public static void fun(String ustr, HashMap<Character, Integer> fmap, int cs, int ts, String asf){
          if(cs == ts){
              System.out.println(asf);
              return;
          }
          
          for(int i = 0; i < ustr.length(); i++){
              char ch = ustr.charAt(i);
              if(fmap.get(ch) > 0){
                  fmap.put(ch, fmap.get(ch) - 1);
                  fun(ustr, fmap, cs + 1, ts, asf + ch);
                  fmap.put(ch, fmap.get(ch) + 1);
              }
          }
          
      }
}
