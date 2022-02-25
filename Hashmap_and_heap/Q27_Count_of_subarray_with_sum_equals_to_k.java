import java.util.*;
// in this question we've given an array and target
// we're required to count total no of subarrays with sum equals to target
public class Q27_Count_of_subarray_with_sum_equals_to_k {
    // for this we create a hashmap and add 0 with freq 1
    // now start loop
    // create a sum variable
    // for every element add sum with arr[i] 
    // now check the map contains sum-target or not if yes that means their is a subarray with sum target
    // add the occurence into ans
    // put the sum by increasing its occurence by 1
    public static int solution(int[] arr, int target){
		int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum - target)){
                ans += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        System.out.println(solution(arr,target));
	}
}
