import java.util.*;
// in this question we've given an array
// each element of array is rabbits which are telling that like me arr[i] rabbits exists
// so we're required to find out total no of rabbits
// arr[i] = 5 that means their is 5 more rabbits like me so total size is 6
public class Q36_Rabits_in_the_forest {
    public static int solution(int[] arr) {
        // ans will store total no of rabbits
        int ans = 0;

        // first of all create a hashmap and store rabbits as key and total no of rabbits like key as 
        // value in the map
        // now traverse through map using keySet()
        // group size will be key + 1
        // reportess will be value of key 
        // group required will be the ceil value of reportees/group size
        // ceil takes variable of double type and give double value 
        // if 5 rabbits and 7 value that means 5 rabbit is saying like me 5 more rabbits are their
        // and total 7 rabbits are saying same like 5 rabbit
        // group size = 5 + 1
        // reportess = 7
        // group required = 7/6 = 2, 6 size group acquires all 6 rabbits and for 1 their has to be another
        // group
        // now multiply group size with group required so we get total count of rabbit with key 5
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
