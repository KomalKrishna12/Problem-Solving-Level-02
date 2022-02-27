import java.util.*;
// A.P in this sequence in each element their will be same differece
// 4, 8, 12, 16, 20
// here in each element differce d = 4
// a0 = 4, an = 20
// an = a0 + (n-1)d;
// d = (an - a0)/(n-1);
// ai = a0 + (i*d);
// a0 is the min and an is the max
public class Q38_Check_arithmetic_sequence {
    public static boolean solution(int[] arr) {
        // single element is always an AP
        // create a min and max 
        // create a HashSet
        // traverse into arr and udate min and max and add all element into hashset
        // find out d
        // trverse into arr and find each element using ai 
        if(arr.length == 1) return true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int val : arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
            set.add(val);
        }

        int d = (max - min) / (arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            int ai = min + (i * d);
            if(set.contains(ai) == false) return false;
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
