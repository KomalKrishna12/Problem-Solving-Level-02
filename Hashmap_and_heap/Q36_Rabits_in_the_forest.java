import java.util.*;
public class Q36_Rabits_in_the_forest {
    public static int solution(int[] arr) {
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for(int key : map.keySet()){
            int groupsize = key + 1;
            int reportess = map.get(key);
            int grouprequired = (int)Math.ceil(reportess*1.0/groupsize*1.0);
            ans += groupsize * grouprequired;
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
        scn.close();
		System.out.println(solution(arr));
	}
}
