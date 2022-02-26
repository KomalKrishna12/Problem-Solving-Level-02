import java.util.*;
// in this qustion an array and a variable k is given
// we're required to find out the len of longest subarray whose sum can be divisble by k
public class Q28_Longest_subarray_with_sum_divisible_by_k {
    public static int solution(int[] arr, int k) {
        // create a hashmap and in that map store rem and index
        // for the first time store rem as -1 and index as -1
        // create two variable sum and rem, in sum add arr[i] with prev value and in rem calculate rem
        // by dividing sum by k and if rem becomes negetive add k to make it positive
        // now check the map contains rem or not, if yes then find out its index and calculate len and
        // update if len is gretaer than prev
        // else add rem into the map with index i 
        int ans = 0;

        int sum = 0, rem = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // remainder(key), index(value)
        map.put(0, -1);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;

            if(rem < 0) rem += k;
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                }
            }
            else{
                map.put(rem, i);
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
