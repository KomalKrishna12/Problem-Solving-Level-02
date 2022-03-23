import java.util.*;
public class Q27_Words_k_Selection_2 {
    public static void main(String[] args) {
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
        generateSelection(ustr, 1, k, -1, "");
    }

    public static void generateSelection(String ustr, int cs, int ts, int lb, String asf){
        if(cs > ts){
            System.out.println(asf);
            return;
        }

        for(int i = lb + 1; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            generateSelection(ustr, cs + 1, ts, i, asf + ch);
        }

    }
}
