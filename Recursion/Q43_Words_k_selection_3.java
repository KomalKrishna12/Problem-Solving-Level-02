import java.io.*;
import java.util.*;
// this is similar ques like Q26 but here we can take reptitive characters
// so we use hashmap to store freq of each character
public class Q43_Words_k_selection_3 {
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
    
       fun(ustr, unique, 0, "", k, 0);

      }

      public static void fun(String str, HashMap<Character, Integer> fmap, int idx, String asf, int k, int ssf){

        // when ssf(string so far) greater than k return 
        if(ssf > k) return;

        // when idx is at size of str then compare ssf and k if same then print and return
        if(idx == str.length()){
          if(ssf == k) System.out.println(asf);
          return;
        }

        // store char at idx now check its freq
        // if it is greater than 0 then reduce its freq by 1 and call for same idx bcoz
        // ch is available in fmap and add ch into asf and add 1 to ssf
        // one more call which will for not adding the char so we simpley increae idx by 1
        char ch = str.charAt(idx);

        if(fmap.get(ch) > 0){
          fmap.put(ch, fmap.get(ch) - 1);
          fun(str, fmap, idx, asf + ch, k, ssf + 1);
          fmap.put(ch, fmap.get(ch) + 1);
        }

        fun(str, fmap, idx + 1, asf, k, ssf);
 
      }

}
