import java.util.*;
// in this ques we have given a number n and we have to print all the numbers from 1 to n in a
// lexicographical no (like in dictionary we print from a to b, after a we print aa,ab,......az)
// 14
// in 14 it'll print 1 then it's family then 2 with family till 9
// 1 then 10,11,14, 2 then 20(but it is greater than 14 so it'll not print)
// 3 then 30(x)
// 4,5,6,7,8,.....9
// ans : 1, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9
public class Q5_Lexicographical_numbers {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        scn.close();
        // so first we have to print 1 then call it's family then 2 then 3.... till 9
        for(int i = 1; i <= 9; i++){
            dfs(i, n);
        }
	}

    public static void dfs(int i, int n){
        if(i > n) return; // base case if i greater than n then return
        System.out.println(i); // print i and call it's family
        // 10 * i + (0,1,......9) : 10,11,.....19
        for(int j = 0; j <= 9; j++){
            dfs(10 * i + j, n);
        }
    }
}
