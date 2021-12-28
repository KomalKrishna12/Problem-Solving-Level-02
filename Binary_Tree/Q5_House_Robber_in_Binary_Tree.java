import java.util.*;

public class Q5_House_Robber_in_Binary_Tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class HousePair {
        int withrobbery;
        int withoutrobbery;
    }

    public static HousePair HouseRobber_(TreeNode root) {
        if (root == null)
            return new HousePair();
        HousePair left = HouseRobber_(root.left);
        HousePair right = HouseRobber_(root.right);

        HousePair myans = new HousePair();
        myans.withrobbery = root.val + left.withoutrobbery + right.withoutrobbery;
        myans.withoutrobbery = Math.max(left.withrobbery, left.withoutrobbery) + Math.max(right.withrobbery,
                right.withoutrobbery);
        return myans;        
    }

    public static int HouseRobber(TreeNode root) {
        HousePair res = HouseRobber_(root);
        return Math.max(res.withrobbery, res.withoutrobbery);
    }

    // input_Section_====================================================================

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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
