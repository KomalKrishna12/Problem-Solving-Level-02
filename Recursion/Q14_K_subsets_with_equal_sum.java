import java.util.*;
// this is similar ques like q11_k_subsets but in addition here we want to print all subsets
// with equal sum
// suppose k is 3 so all 3 subsets sum have to be equal
public class Q14_K_subsets_with_equal_sum {
    public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
		if(vidx == arr.length){
            if(ssssf == k){
                // check that k subsets are created or not, either any set is empty then return bcoz
                // it's not a valid ans
                boolean flag = true;
                for(int i = 0; i < subsetSum.length - 1; i++){
                    // now compare sum of all k subsets
                    // if they are equal then print the ans
                    if(subsetSum[i] != subsetSum[i + 1]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(ArrayList<Integer> list : ans){
                        System.out.print(list + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i).size() > 0){
                // here we are adding arr[vidx] element in the existing subsets so sssf will not increase
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx]; // add the ith element into subset of vidx element
                solution(arr, vidx + 1, n, k, subsetSum, ssssf, ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() - 1);
            }
            else{
                // here we are adding into new subset so sssf will increase
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx]; // add the ith element into subset of vidx element
                solution(arr, vidx + 1, n, k, subsetSum, ssssf + 1, ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() - 1);
                break;
            }
        }

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
        scn.close();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
}
