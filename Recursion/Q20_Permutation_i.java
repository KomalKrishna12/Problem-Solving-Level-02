import java.util.*;
import java.io.*;

// in this question we have give a box of size nboxes and ritems
// we have to place these items in the boxes
// we can fill the box with items
public class Q20_Permutation_i {
    // suppose arr = [1,2,3] so permuattion will be 3! = 6
    // we have 3 options either we select 1 or 2 or 3
    // but check in the chekc[] arr if that element is not used then only add this into ds
    // mark is used by inseritng 1 and call for next
    // while return mark it uncheck and also remove the last insert item frome
    // base cond will be if size of ds is equal to arr.length then create a shalow copy and add it into ans 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] check = new int[nums.length];
        helper(nums, check, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int[] nums, int[] check, List<Integer> ds, List<List<Integer>> ans){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(check[i] == 0){
                ds.add(nums[i]);
                check[i] = 1;
                helper(nums, check, ds, ans);
                check[i] = 0;
                ds.remove(ds.size() - 1);
            }
        }
    }
    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int val : boxes) {
                System.out.print(val);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }
}
