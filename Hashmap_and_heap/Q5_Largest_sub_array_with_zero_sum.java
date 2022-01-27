import java.util.HashMap;
import java.util.Scanner;

public class Q5_Largest_sub_array_with_zero_sum {
    public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        // in starting assume that sum is 0 for index -1 
        int i = -1;
        int sum = 0;
        int maxlen = 0;
        map.put(sum, i);
        while(i < arr.length - 1){
            // increment i by 1 and add arr[i] into sum
            i++;
            sum += arr[i];
            // now check that the sum is in the map or not
            // if not then put sum into i
            // if sum is already in map then in length variable get the index value and compare length with
            // max length and store max index
            if(map.containsKey(sum) == false){
                map.put(sum, i);
            }
            else{
                int len = i - map.get(sum);
                if(maxlen < len){
                    maxlen = len;
                }
            }
        }
		return maxlen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
        scn.close();
		System.out.println(solution(arr));
	}
}
