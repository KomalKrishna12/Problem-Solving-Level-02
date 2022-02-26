import java.util.HashMap;
import java.util.Scanner;

public class Q33_Count_of_subarray_with_equal_no_of_0s_1s_2s {
    public static int solution(int[] arr) {
        int ans = 0;
        int countz = 0; // count of zero's
        int counto = 0; // count of one's
        int countt = 0; // count of two's
        int delta10 = counto - countz;
        int delta21 = countt - counto;
        String key = delta10 + "#" + delta21;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(key, 1);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) countz++;
            else if(arr[i] == 1) counto++;
            else countt++;
            delta10 = counto - countz;
            delta21 = countt - counto;
            key = delta10 + "#" + delta21;

            if(map.containsKey(key)){
                ans += map.get(key);
                map.put(key, map.get(key) + 1);
            }
            else{
                map.put(key, 1);
            }
        }


        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    } 
}
