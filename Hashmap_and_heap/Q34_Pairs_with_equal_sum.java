import java.util.*;
// in this ques we have given an array we're required to check that is there any pair whose sum
// is present in the array, if yes then return true else return false
public class Q34_Pairs_with_equal_sum {
    public static boolean solution(int[] arr) {
        // if array size is n then possible pairs is nC2
        // use hashset to solve this
        // create a for loop which will traverse from 0 to n
        // second loop will traverse from i + 1
        // calculate sum as arr[i] + arr[j]
        // if set contains sum then return true else add sum into set
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)) return true;
                else set.add(sum);
            }
        }

        return false;
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
