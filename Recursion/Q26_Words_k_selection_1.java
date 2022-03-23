import java.util.*;
// in this ques we have given a word which may contain characters repeatadly
// we have given k
// we're reuired to print all the strings with k uniuqe characters

// this is similar ques like we have n boxes k distinct elements
// for make our ques like this create a hashset and add all char
// now pass that char into function
// first call will be for adding str.CharAt(i)
// second call for adding nothing
public class Q26_Words_k_selection_1 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();
        scn.close();
    
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
    
        combination(0, ustr, 0, k, "");
      }
    
    
      public static void combination(int i, String ustr, int ssf, int ts, String asf ) {
          if(i == ustr.length()){
              if(ssf == ts) System.out.println(asf);
              return;
          }

          char ch = ustr.charAt(i);
          combination(i + 1, ustr, ssf + 1, ts, asf + ch);
          combination(i + 1, ustr, ssf, ts, asf + "");
          
      }
}
