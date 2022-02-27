import java.util.*;
// in this question we've given a number and a denominator 
// we're required to convert it into decimal form 
// 14/6 = 2.333333.. so it'll denote like 2.(3)
public class Q35_Fraction_to_recuring_decimal {
    public static String solution(int num, int den) {
        StringBuilder ans = new StringBuilder();

        int q = num / den; // quotient
        int r = num % den; // remainder
        ans.append(q);     // add it into ans
        
        // check remainder, if it is 0 then returna ans
        // else append a "." and create a hashmap for checking that the rem is in map or not
        // if it is in map then get it's value and store it into len and insert a "(" into that len
        // and append ")" and break
        // else put it into map with value as string length
        // multiply rem by 10 and calculate quotient and remainder again
        // append quo and traverse the while loop till we get out decimal no in string
        if(r == 0){
            return ans.toString();
        }
        else{
            ans.append(".");
            HashMap<Integer, Integer> map = new HashMap<>();
            while(r != 0){
                if(map.containsKey(r)){
                    int len = map.get(r);
                    ans.insert(len, "(");
                    ans.append(")");
                    break;
                }
                else{
                    map.put(r, ans.length());
                    r *= 10;
                    q = r / den;
                    r = r % den;
                    ans.append(q);
                }
            }
        }

        return ans.toString();
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int den = scn.nextInt();
        scn.close();
		System.out.println(solution(num , den));
	}
}
