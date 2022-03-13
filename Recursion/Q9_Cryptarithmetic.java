import java.util.*;
// we have given three strings which can make a unique string by taking all characters from all three
// that cannot exxceed to 10 characters 
// assin them digits from 0 to 9 so that sum of s1 and s2 equal to s3
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
    
    
      // we have given a string str and we have to return a number which can be generated using map
      // create a string num
      // now get char ch from str using charAt()
      // now add that ch into num
      // at end return the num by changing it into integer
      public static int getNum(HashMap<Character, Integer> charIntMap, String str){
        String num = "";
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            num += charIntMap.get(ch);
        }
        
        return Integer.parseInt(num);
    }
  
  
    public static void solution(String unique, int idx,
                                HashMap<Character, Integer> charIntMap,
                                boolean[] usedNumbers, String s1, String s2, String s3) {

      // base case
      // get all numbers using getNum()
      // now add num1 and num2 if their sum is equal to num3 then 
      // print their respective digits in ascending order                              
      if(idx == unique.length()){
          int num1 = getNum(charIntMap, s1);
          int num2 = getNum(charIntMap, s2);
          int num3 = getNum(charIntMap, s3);
          if(num1 + num2 == num3){
              for(int i = 0; i < 26; i++){
                  char ch = (char)('a' + i); // 'a' = 97, 'a' + 0 = a, 'a' + 1 = b
                  if(charIntMap.containsKey(ch)){
                      System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                  }
              }
              System.out.println();
          }
          return;
      }                     
                           
      char chh = unique.charAt(idx);
      for(int num = 0; num <= 9; num++){
          // we can assign num between 0 to 9, before assign check if that num is already used or not
          if(usedNumbers[num] == false){
               charIntMap.put(chh, num);
               usedNumbers[num] = true;
               
               solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
               
               charIntMap.put(chh, -1);
               usedNumbers[num] = false;
          }
      }
                                   
    }
}
