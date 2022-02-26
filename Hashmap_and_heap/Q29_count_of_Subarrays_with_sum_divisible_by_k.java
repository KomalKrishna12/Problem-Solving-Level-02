import java.util.*;
// this is similar question like Q27 but here we're required to find out subarray whose sum divisble by k
// not equal to k
public class Q29_count_of_Subarrays_with_sum_divisible_by_k{
    public static int solution(int[] arr, int k) {
        int ans = 0;

        // we use same conecpt 
        // create a hasmap for remainder and it's freq
        // create a variable sum and rem
        // add first element as 0 remainder and its freq as 1
        // now traverse into the loop
        // add arr[i] into sum
        // now find out remainder and check it's existing into the map or not 
        // if yes then find its freq and add it to ans and increase its freq into map

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, rem = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;

            if(rem < 0) rem += k;

            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
            else{
                map.put(rem, 1);
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
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, k));
    }
}