import java.util.*;
// in this question we've given an array 
// we're required to find out the length of longest subarray with equal no of 0's and 1's
public class Q30_Longest_subarray_with_equal_no_of_0s_and_1s {
    public static int solution(int[] arr) {
        int ans = 0;

        // create a hashmap for sum and index
        // add first key as sum 0 and index -1
        // create a variable sum
        // now traverse into for loop
        // if arr[i] == 0 then add -1 into sum else add +1 so if we got sum as 0 that means their is
        // equal no of 0's and 1's
        // now check the map if it contains the sum then get it's index into idx and calculate the
        // len and compare if longer then update it into ans, there is no need to increase sum freq
        // into map becoz we want to find out longest so old index is required
        // else if sum is not in map then add it to map with index i
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sum += -1;
            }
            else{
                sum += +1;
            }
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                }
            }
            else{
                map.put(sum, i);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
