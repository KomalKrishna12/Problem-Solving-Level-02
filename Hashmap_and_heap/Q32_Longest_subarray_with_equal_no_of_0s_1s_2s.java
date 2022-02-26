import java.util.*;
// in this ques we've given an array of elements 0's 1's and 2's
// we're required to find out the length of longest subarray with equal no of 0s 1s and 2s
public class Q32_Longest_subarray_with_equal_no_of_0s_1s_2s {
    public static int solution(int[] arr) {
        int ans = 0;

        // this is same ques like Q30, the only diff he here that we've 2's also
        // so use the concept like
        // suppose we've three variable x0, x1, x2
        // if x1 - x0 == x2 - x1 that means we've equal no of all 0's 1's and 2's
        int countz = 0; // count of zero's
        int counto = 0; // count of one's
        int countt = 0; // count of two's
        int delta10 = counto - countz;
        int delta21 = countt - counto;
        String key = delta10 + "#" + delta21;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(key, -1);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) countz++;
            else if(arr[i] == 1) counto++;
            else countt++;
            delta10 = counto - countz;
            delta21 = countt - counto;
            key = delta10 + "#" + delta21;

            if(map.containsKey(key)){
                int idx = map.get(key);
                int len = i - idx;
                if(len > ans) ans = len;
            }
            else{
                map.put(key, i);
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
