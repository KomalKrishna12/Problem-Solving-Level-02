import java.util.*;
public class Q6_Count_all_subarrays_with_zero_sum {
    public static int solution(int[] arr) {
        // we want to count all subarray whose sum is zero
        // create a hashmap which store sum with the occurenece
        // create index i which is intially pointing to -1 
        // create a variable sum which stores the sum and count which store total no of count o subarray
        // put 0 with 1 now start while loop 
        // incrase i and add arr[i] into sum
        // check if sum is in the map or not
        // if it is then add map.get(sum) into count and increase occurence of sum by 1
        // else put sum with occurence 1
        // at end return count 
		int count = 0;
		int i = -1;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		while(i < arr.length - 1){
		    i++;
		    sum += arr[i];
		    if(map.containsKey(sum)){
		        count += map.get(sum);
		        map.put(sum, map.get(sum)+1);
		    }
		    else{
		        map.put(sum,1);
		    }
		}
		return count;
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
