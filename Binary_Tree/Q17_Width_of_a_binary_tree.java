import java.util.*;
public class Q17_Width_of_a_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // here we're finding the width of a tree
    // assume that root is at 0th level
    // node.left is at hl - 1 and node.right is at hl + 1
    // now width will be righmost hl - leftmost hl + 1 beause we want to add both corner nodes
    // for this we create 2 size array ans
    // ans[0] contain min index which is at leftmost node
    // ans[1] contain max index which is at rightost node
    // if node is null then return
    // for node.left hl will be hl - 1
    // for node.right hl will be hl + 1
    public static void width(TreeNode node, int hl, int[] ans){
        if(node == null) return;

        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);

        width(node.left, hl - 1, ans);
        width(node.right, hl + 1, ans);
    }

    public static int width(TreeNode root) {
        int[] ans = new int[2];
        width(root, 0, ans);
       return ans[1] - ans[0] + 1; 
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
