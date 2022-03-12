import java.util.*;
// in this question we have given a string and we are required to print it's abbreviations
// str : pep
// so this is a string of length 3 and for 3 we have total 2^3 subsequences = 8, like 000,001.....111.
// so if in the string there is 0 that means don't change that character
// if 1 then replace that character by 1 
// if prev char is also 1 then increase it's count by 1 so it'll be 2
// solutuion : 
// str : pep
// 000 - pep
// 001 - pe1
// 010 - p1p
// 011 - p2 (p11)
// 100 - 1ep
// 101 - 1e1
// 110 - 2p (11p)
// 111 - 3 (111)
// so in the solution() we pass str, asf(ans so far, which is ""), count(0) and idx(0, position)
// call soltion() when we are taking that character (means not changing)
// but check the count, asf = asf + count + str.charAt(idx)
// if count is 0, don't print the count so asf += str.charAt(idx)
// now second call is for not taking that idx charcter
// so simply pass same asf and increase the prev count by 1
// base case
// when idx equals to str.length() then print the asf but with count at end so check is 0 don't add
public class Q1_Abbreviations_I{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        solution(str, "", 0, 0);
    }
    public static void solution(String str, String asf, int count, int idx){
        if(idx == str.length()){
            if(count == 0){
                System.out.println(asf);
            }
            else{
                System.out.println(asf + count);
            }
            return;
        }

        // if we are taking the idx's character
        if(count > 0) solution(str, asf + count + str.charAt(idx), 0, idx + 1);
        else solution(str, asf + str.charAt(idx), 0, idx + 1);

        // if we are not taking the idx's character
        solution(str, asf, count + 1, idx + 1);
    }
}