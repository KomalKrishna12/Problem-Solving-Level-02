import java.util.*;
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
    
      }
}
