import java.util.*;
public class Q7_Largest_subarray_with_contigeous_elements {
    public static int solution(int[] arr) {
		// in this question we have given an array, we've to find out the length of largest subarray of
        // contegous elements
        // 7 8 9 6 22 24 25 23 21 8 9 2
        // in this array 22 24 25 23 21 is the largest subarray with contegous elements
        // so we use approach in which we use max and min and i & j i is starting index and j is ending index
        // if max - min == j - i
        // then len will be j - i + 1
        // now compare the len with prev len and replace it with largest length
        // this approach fails for duplicate elements so we use hashmap so if any element exists then break
        // it's time complexity is n*n, ans is the variavle which store largest length
        // start outer loop from i = 0 to arr.length - 1
        // set min and max with arr[i]
        // create a HashSet set and add arr[i] into it
        // now create inner loop for j = i + 1 to arr.length
        // compare max and min and update
        // now check wheather arr[j] exists into set or not if exists then break
        // now check if max - min == j - i then check the len (j - i + 1) and update if it is larger
		int ans = 0;

        for(int i = 0; i < arr.length - 1; i++){
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for(int j = i + 1; j < arr.length; j++){
                if(set.contains(arr[j])) break;
                set.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if(max - min == j - i){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

		return ans;
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
