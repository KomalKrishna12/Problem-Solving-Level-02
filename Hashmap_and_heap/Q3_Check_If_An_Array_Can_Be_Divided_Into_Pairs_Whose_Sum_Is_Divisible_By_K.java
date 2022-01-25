import java.util.*;
public class Q3_Check_If_An_Array_Can_Be_Divided_Into_Pairs_Whose_Sum_Is_Divisible_By_K {
    public static void solution(int[] arr, int k){
		//write your code here
        HashMap<Integer, Integer> freqRem = new HashMap<>();
        for(int val : arr){
            int rem = val % k;
            int oldFreq = freqRem.getOrDefault(rem, 0);
            freqRem.put(rem, oldFreq + 1);
        }

        for(int val : arr){
            int rem = val % k;
            if(rem == 0){
                int freq = freqRem.get(rem);
                if(freq % 2 == 1){
                    System.out.println(false);
                    return;
                }
            }
            else if(2 * rem == k){
                int freq = freqRem.get(rem);
                if(freq % 2 == 1){
                    System.out.println(false);
                    return;
                }
            }
            else{
                int freq = freqRem.get(rem);
                int ofreq = freqRem.getOrDefault(k - rem, 0);
                if(freq != ofreq){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
        scn.close();
		solution(arr,k);
	}
}
