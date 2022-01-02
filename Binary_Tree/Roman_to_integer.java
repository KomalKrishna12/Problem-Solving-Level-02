import java.util.HashMap;

public class Roman_to_integer {
    static HashMap<Character, Integer> map;
    public static int romanToInt(String s) {
        map = new HashMap<>() ;
        map.put('I',1);   
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num = 0;
        for(int i = 0; i < s.length() - 1; i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(map.get(ch1) < map.get(ch2)){
                num += map.get(ch2) - map.get(ch1);
                i++;
            }
            else{
                num += map.get(ch1);
            }
        }
        
        return num;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
