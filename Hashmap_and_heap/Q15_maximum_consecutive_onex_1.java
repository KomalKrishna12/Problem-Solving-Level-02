import java.util.*;
// this question is same like Q16 but here we're allowed to flip on zero only
// so we're required to find out maximum consecutive ones which can ignore one zero
public class Q15_maximum_consecutive_onex_1 {
    public static int solution(int[] arr){
        int ans = 0;
        int j = -1, count = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) count++;
            while(count > 1){
                j++;
                if(arr[j] == 0) count--;
            }
            int len = i - j;
            if(len > ans){
                ans = len;
            }
        }

        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
	}
}
