import java.util.*;
// we have given an array of size even
// we are required to check that array elements are in double pair or not
// algo
// step1 : create hashmap and add all element with it's freq
// step2 : sort the array using absolute value (in negetive value sort by ignoring -ve sign)
// step3 : traverse the array and check their pair
public class Q37_Double_pair_array {
    public static boolean solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr) map.put(val, map.getOrDefault(val, 0) + 1);

        // it is dificult to sort the int type array using absolute function so we create an array
        // of type Integer and using lamda function we can sort the array
        Integer[] ar = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) ar[i] = arr[i];

        Arrays.sort(ar, (a, b)->{
            return Math.abs(a) - Math.abs(b);
        });

        // now traverse through sorted array
        // if val's freq is 0 that means it's already used in pair so continue
        // check 2*val's if its freq is 0 that means it's already use so return false bcoz its not pairing 
        // if it is not avaialble in the array then also return false
        // for checking these two we can use getOrDefault()
        // now decrese val's freq and 2*val's freq by 1
        for(Integer val : ar){
            if(map.get(val) == 0) continue;
            if(map.getOrDefault(2*val, 0) == 0) return false;
            map.put(val, map.get(val) - 1);
            map.put(2*val, map.get(2*val) - 1);
        }
        
        return true;
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
