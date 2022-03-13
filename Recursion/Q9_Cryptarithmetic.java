import java.util.*;
public class Q9_Cryptarithmetic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
        scn.close();
    
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
          if (!charIntMap.containsKey(s1.charAt(i))) {
            charIntMap.put(s1.charAt(i), -1);
            unique += s1.charAt(i);
          }
        }
    
        for (int i = 0; i < s2.length(); i++) {
          if (!charIntMap.containsKey(s2.charAt(i))) {
            charIntMap.put(s2.charAt(i), -1);
            unique += s2.charAt(i);
          }
        }
    
        for (int i = 0; i < s3.length(); i++) {
          if (!charIntMap.containsKey(s3.charAt(i))) {
            charIntMap.put(s3.charAt(i), -1);
            unique += s3.charAt(i);
          }
        }
    
        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
      }
    
    
      public static void solution(String unique, int idx,
                                  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
                                  String s1, String s2, String s3) {
        // write your code here
      }
}
