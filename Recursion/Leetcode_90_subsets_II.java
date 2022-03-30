import java.util.*;
public class Leetcode_90_subsets_II {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(0, nums, new ArrayList<>(), res);
        
        return res;
    }

    private void helper(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr)); // add shallow copy of curr
        // bcoz in next level we start getting subset of size +1 of curr
        // start loop from idx till end
        // if i != idx andd nums[i] == nums[i-1] that means they are same so do't pick i otherwise
        // it will create duplicate subsets
        // we are checking for i and idx bcoz we don't want to check first idx that's why
        // first time we want to use that from second we check to avoid duplicates

        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
