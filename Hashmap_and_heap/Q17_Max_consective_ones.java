import java.util.*;
// we've given an array which have 0's and 1's
// we're required to calculate the len of max consecutive 1's
public class Q17_Max_consective_ones {
    public static int solution(int[] arr){
        // create a variable maxcount intialize it with arr[0]
        // create a for loop and traverse arr from 1st index
        // if i index element is 1 then chaneg it value as arr[i] + arr[i-1]
        // if it is 0, do nothing
        // everytime check maxcount
        // at end we've the len of max consecutive ones
        int maxcount = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 1){
                arr[i] += arr[i-1];
            }
            maxcount = Math.max(maxcount, arr[i]);
        }

        return maxcount;
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
