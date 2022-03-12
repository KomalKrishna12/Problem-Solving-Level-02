import java.util.*;
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
        }

        // if we are taking the idx's character
        if(count > 0) solution(str, asf + count + str.charAt(idx), 0, idx + 1);
        else solution(str, asf + str.charAt(idx), 0, idx + 1);

        // if we are not taking the idx's character
        solution(str, asf, count + 1, idx + 1);
    }
}