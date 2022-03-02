import java.util.HashMap;
import java.util.Scanner;
// in this question we have given a longurl and tinyurl
// using tinyurl we can longurl and vice versa
// every longurl has unique tinyurl and vice versa
// we have to use encode and decode longurl and tinyurl
// so in tinyurl their a random string and we have to generate that string
public class Q50_Encode_ans_decode_tinyurl {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String url = scn.nextLine();
        scn.close();
        System.out.println(decode(encode(url)));
    }

    // cretae a hashmap to store shorturl as key and tinyurl as the key value
    static HashMap<String, String> map = new HashMap<>();

    // in encode we have given a longUrl we have to encode it into tinyurl
    // to create random string we can use random() but it'll given no between 0 to 1 so multiple it with 100 
    // so it'll give no between 1 to 100
    // now it will be in decimal so get its floor value and convert it into char
    // now check that the string is in the map or not
    // if yes then do the same process of generting random tinyurl till we generate a unique url
    // and put it into the map 
    // now return that url that will be out tinyurl for longurl
    public static String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)(Math.floor(Math.random()*100)));
        while(map.containsKey(sb.toString())){
            sb.append((char)(Math.floor(Math.random()*100)));
        }
        map.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // decode is easy, we have stores every tinyurl with longurl so check the map and return the value
    public static String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
