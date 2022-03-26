import java.io.*;
import java.util.HashMap;
// we have given a str and a length k we are required to print all possible words
// in which any characters can be repited
// use hashmap and put -1 for every char
// firsty store ch then get its last index
// now call loop from li + 1 to end till spots available (k)
// if spot is null then put char and in hashmao put its index as last index
// if li is -1 then we can call for not using ch so only idx will increase
public class Q45_Words_k_length_words_3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch, -1);
        }

        fun(str, map, 0, k, new Character[k], 0);
    
      }

      public static void fun(String str, HashMap<Character, Integer> map, int cc, int ts, Character[] spots, int ssf){

        if(cc == str.length()){
            if(ssf == ts){
                for(char ch : spots) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(cc);
        int li = map.get(ch);

        for(int i = li + 1; i < spots.length; i++){
            if(spots[i] == null){
                spots[i] = ch;
                map.put(ch, i);
                fun(str, map, cc + 1, ts, spots, ssf + 1);
                spots[i] = null;
                map.put(ch, li);
            }
        }

        if(li == -1){
            fun(str, map, cc + 1, ts, spots, ssf);
        }


      }
    
}
