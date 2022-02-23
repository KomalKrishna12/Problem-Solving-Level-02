import java.util.*;
// in this question we've given an array which contains 0's and 1's
// we're required to find out maximum consecutive 1's who can flip k 0's
// means find out the maximum contegeous 1's who can contain k 0's 
public class Q16_maximum_consecutive_ones_II {
    public static int solution(int[] arr, int k){
        // create a variable j for release and count for counting the zeros
        // create a for loop which will traverse the array arr
        // if arr[i] == 0 then increase count by 1
        // while count is greater than k then increase j by 1
        // check jth element, if jth element is 0 then decrease count by 1
        // do this till count is greater than k
        // now calculate the lenth of consecutive ones and store max length into ans
        int ans = 0;
 
         int j = -1, count = 0;
 
         for(int i = 0; i < arr.length; i++){
             if(arr[i] == 0){
                 count++;
             }
 
             while(count > k){
                 j++;
                 if(arr[j] == 0){
                     count--;
                 }
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
         int k = scn.nextInt();
         scn.close();
         System.out.println(solution(arr,k));
     }
}
