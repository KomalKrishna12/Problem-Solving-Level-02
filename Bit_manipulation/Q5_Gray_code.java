import java.util.*;
// in this question we have given a no n and we are required to add all the n bit no in which their is
// one bit change
// n = 1 : 0, 1
// n = 2 : 00, 01, 11, 10
// n = 3 : 000, 001, 011, 010, 110, 111, 101, 100
// so we can find out using recursion
// base case is for n = 1
// call for (n-1)
// and add 0 in start and 1 from end

public class Q5_Gray_code {
    public static ArrayList<String> grayCode(int n) {
        if(n == 1){
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }

        ArrayList<String> recRes = grayCode(n - 1);
        ArrayList<String> myRes = new ArrayList<>();

        for(int i = 0; i < recRes.size() - 1; i++){
            String str = recRes.get(i);
            myRes.add("0" + str);
        }

        for(int i = recRes.size() - 1; i >= 0; i--){
            String str = recRes.get(i);
            myRes.add("1" + str);
        }
        return myRes;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> ans = grayCode(scn.nextInt());
        scn.close();
        for(String str : ans){
            for(int i = 0; i < str.length(); i++){
                System.out.print(str.charAt(i) + " ");
            }
            System.out.println();
        }
    }
}
