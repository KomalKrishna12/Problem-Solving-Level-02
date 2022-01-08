import java.util.*;
public class Q23_Vertical_order_sum_of_binary_tree_using_recursive_method {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void width(TreeNode node, int hl, int[] minmax){
        if(node == null) return;

        minmax[0] = Math.min(minmax[0], hl);
        minmax[1] = Math.max(minmax[1], hl);
        
        width(node.left, hl - 1, minmax);
        width(node.right, hl + 1, minmax); 
    }

    // this is the second approach of vertical order sum
    public static void dfs(TreeNode root, int hl, ArrayList<Integer> ans) {
        if(root == null) return;

        ans.set(hl, ans.get(hl) + root.val);
        dfs(root.left, hl - 1, ans);
        dfs(root.right, hl + 1, ans);
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        int[] minmax = new int[2];
        width(root, 0, minmax);
        int len = minmax[1] - minmax[0] + 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++) ans.add(0);
        dfs(root, Math.abs(minmax[0]), ans);
        return ans;
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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}
