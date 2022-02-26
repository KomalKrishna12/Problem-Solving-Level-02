import java.util.*;
// in this ques we've given an array with elements 0's and 1's
// we're required to find out total no of subarrays with equal no of 0's and 1's
public class Q31_Counnt_of_subarray_with_equal_no_of_0s_1s {
    public static int solution(int[] arr) {
        int ans = 0;

        // create a hashmap for key as sum and value as freq
        // add first elements as sum 0 and freq 1
        // now traverse into array arr
        // if arr[i] is 0 then add -1 into sum var else add -1 for 1
        // if map contains sum then add it's value into ans and increase its freq by 1
        // else add sum with freq 1 
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) sum += -1;
            else sum += 1;
            if(map.containsKey(sum)){
                ans += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            }
            else{
                map.put(sum, 1);
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
