import java.util.*;
// we have given a string str and we are required to print all it's partition which is pallindrome
// so find prefix of string and check it's pallindrome or not
// if yes then add it the asf and call solution for res substring
public class Q13_All_pallindromic_partitions {

    public static boolean isPallindrome(String str){
        int li = 0, ri = str.length() - 1;

        while(li < ri){

            char lc = str.charAt(li);
            char rc = str.charAt(ri);

            if(lc != rc) return false;

            li++;
            ri--;

        }

        return true;
    }

    public static void solution(String str, String asf) {
    
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if(isPallindrome(prefix)){
                solution(ros, asf + "(" + prefix + ") ");
            }
        }
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
        scn.close();
		solution(str, "");
	}
}
