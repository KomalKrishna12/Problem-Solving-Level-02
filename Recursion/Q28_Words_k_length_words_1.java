import java.io.*;
import java.util.*;
// we have given a word in which one character can be repeated, we have given k
// required to print all k size strings in which all char are uniuqe
// suppose str : abcabc, k : 2
// unique str : abc (using hashset we got)
// firstly store charAt(cc) now check if chars[i] == null, then add ch into ith index and call for
// next by increasing index by 1 and increase ssf
public class Q28_Words_k_length_words_1 {

    public static void generateUniqueString(int cc, String ustr, int tc, int ssf, Character[] chars){
        if(cc == ustr.length()){
            if(ssf == tc){
                for(char ch : chars){
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }              
        char ch = ustr.charAt(cc);
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == null){
            chars[i] = ch;
            generateUniqueString(cc + 1, ustr, tc, ssf + 1, chars);
            chars[i] = null;
            }
        }
        generateUniqueString(cc + 1, ustr, tc, ssf + 0, chars);
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

        Character[] chars = new Character[k];
        generateUniqueString(0, ustr, k, 0, chars);
    
    
      }
    
}
