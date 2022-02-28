import java.util.*;
// in this question we have given an array num and target
// we are required to find out four sum means 4 pairs whose sum is equal to target
public class Q42_Quadruple_sum {
	// to solve four sum first of all sort the array
	// first of all do codeing for twosum using start index and end index
	// now do code for third sum using two sum
	// now do for four sum using three sum 

	// this function will add val with each array list of res
	public static void createRes(ArrayList<ArrayList<Integer>> res, ArrayList<ArrayList<Integer>> smallist, int val){
		for(ArrayList<Integer> sl : smallist){
			// this will add val at 0th index
			sl.add(0, val);
			res.add(sl);
		}
	}

	// for two sum use si and ei
	// place si at start and ei at end
	// add no at si and ei index
	// if sum is greater than target then decrese ei by 1
	// if sum is less than targete then increse si by 1
	// if equal then add pairs into res as list and increse si by 1 and decrese ei by 1
	// now check that the curret elment is same like before or not, if same then increase again 
	public static ArrayList<ArrayList<Integer>> TwoSum(int[] nums, int target, int si, int ei){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		while(si < ei){
			int sum = nums[si] + nums[ei];
			if(sum > target) ei--;
			else if(sum < target) si++;
			else{
				res.add(new ArrayList(Arrays.asList(nums[si], nums[ei])));
				// this code do this work of 4 line
				// ArrayList<Integer> al = new ArrayList<>();
				// al.add(nums[si]);
				// al.add(nums[ei]);
				// res.add(al);
				si++;
				ei--;
				while(si < ei && nums[si] == nums[si - 1]) si++;
				while(si < ei && nums[ei] == nums[ei + 1]) ei--;
			}
		}

		return res;
	}

	// for threesum we can use twosum
	// call twosum for si as i + 1 and ei as same and add nums[i] with list which we get from twosum
	public static ArrayList<ArrayList<Integer>> ThreeSum(int[] nums, int target, int si, int ei){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		for(int i = si; i <= ei; i++){
			// this will check if the elmenet is same like prev or not 
			if(i != si && nums[i] == nums[i-1]) continue;
			ArrayList<ArrayList<Integer>> list = TwoSum(nums, target - nums[i], i + 1, ei);
			createRes(res, list, nums[i]);
		}

		return res;
	}

	// this is the actual code given by question
	// so first of all sort the array
	// create si and ei as 0 and n-1 so that we can findout threesum and add nums[i] with the result
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int si = 0, ei = n - 1;

		for(int i = si; i <= ei; i++){
			if(i != si && nums[i] == nums[i-1]) continue;
			ArrayList<ArrayList<Integer>> list = TwoSum(nums, target - nums[i], i + 1, ei);
			createRes(res, list, nums[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
        sc.close();
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
		Collections.sort(ans,(a,b)->{ 
            int i = 0;
            int j = 0;
            
            while(i < a.size()){
                if(a.get(i) == b.get(j)){
                    i++;
                    j++;
                }else{
                    return a.get(i) - b.get(j);
                }
            }
            
            return 0;
        }); 
		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
}
