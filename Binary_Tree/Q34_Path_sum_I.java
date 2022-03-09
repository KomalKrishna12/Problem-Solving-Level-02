import java.util.*;

public class Q34_Path_sum_I {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // in this question we are required to check that the tree contain any root to leaf path in which
    // their sum is equal to target sum
    // so we use recursion approach we are having a faith that if hashPathSum(root.left) is achieving
    // targetsum - root.val if yes than the left path is giving true and similar with root.right
    // if root is null then return false
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0)
                return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }    

    // input_Section=================================================

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
        int tar = scn.nextInt();
        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(hasPathSum(root, tar));
    }

    public static void main(String[] args) {
        solve();
    }
}