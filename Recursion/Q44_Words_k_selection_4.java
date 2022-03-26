import java.io.*;
import java.util.*;
public class Q44_Words_k_selection_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.containsKey(ch) == false) {
            unique.put(ch, 1);
            ustr += ch;
          } else {
            unique.put(ch, unique.get(ch) + 1);
          }
        }
        
        helper(ustr, unique, 0, k, "", 0);
        
      }
      
      // in this approach we put spots on level and we use li (last used index)
      // we have to fill li to end char
      // if their freq is more than 0 then decrease its freq and call for next
      public static void helper(String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf, int li){
          
          if(cs == ts){
              System.out.println(asf);
              return;
          }
          
          for(int i = li; i < str.length(); i++){
              char ch = str.charAt(i);
              if(fmap.get(ch) > 0){
                  fmap.put(ch, fmap.get(ch) - 1);
                  helper(str, fmap, cs + 1, ts, asf + ch, i);
                  fmap.put(ch, fmap.get(ch) + 1);
              }
          }
          
      }
}
