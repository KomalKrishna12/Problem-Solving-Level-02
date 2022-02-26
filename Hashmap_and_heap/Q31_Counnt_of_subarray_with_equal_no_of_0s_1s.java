import java.util.*;
public class Q31_Counnt_of_subarray_with_equal_no_of_0s_1s {
    public static int solution(int[] arr) {
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) sum += -1;
            else sum += 1;
            if(map.containsKey(sum)){
                ans += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            }
            else{
                map.put(sum, 1);
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
