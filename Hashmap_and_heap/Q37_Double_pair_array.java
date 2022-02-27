import java.util.*;
public class Q37_Double_pair_array {
    public static boolean solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr) map.put(val, map.getOrDefault(val, 0) + 1);

        Integer[] ar = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) ar[i] = arr[i];

        Arrays.sort(ar, (a, b)->{
            return Math.abs(a) - Math.abs(b);
        });

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
