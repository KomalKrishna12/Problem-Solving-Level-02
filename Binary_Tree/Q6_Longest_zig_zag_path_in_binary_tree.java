import java.util.*;
public class Q6_Longest_zig_zag_path_in_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // this is first approach
    // we create a pair class which contain 3 variables forwslop, backwardslop and maxlen
    // by default forwslop and backwardslop will be -1 bcoz we're counting path
    // assume forwslop for left child
    // backslop for right child 
    static class Pair{
        int forwardslop = -1, backwardslop = -1, maxlen = 0;
    }

    // if root is null simply create a object of Pair class and return it
    // left and right contain all three variables
    // create myans object
    // myans.maxlen contain max of left.maxlen or right.mexlen or max of left.backslop and right.forwslo + 1
    // myans.forwslop = left.backslop + 1
    // myslop.backslop = right.forwslop + 1
    // public static Pair longestZigZagPath_(TreeNode root) {
    //     if(root == null) return new Pair();
        
    //     Pair left = longestZigZagPath_(root.left);
    //     Pair right = longestZigZagPath_(root.right);
    //     Pair myans = new Pair();
    //     myans.maxlen = Math.max(Math.max(left.maxlen, right.maxlen), 
    //                    Math.max(left.backwardslop, right.forwardslop) + 1);
    //     myans.forwardslop = left.backwardslop + 1;
    //     myans.backwardslop = right.forwardslop + 1;
    //     return myans;
    // }

    // public static int longestZigZagPath(TreeNode root) {
    //     Pair res = longestZigZagPath_(root);
    //     return res.maxlen;
    // }

    // now this is the second approach
    // first one is more readable but second one is easy and fast
    
    static int maxlen = 0;
    public static int[] longestZigZagPath_(TreeNode root) {
        if(root == null) return new int[]{-1, -1};
        int[] left = longestZigZagPath_(root.left);
        int[] right = longestZigZagPath_(root.right);

        maxlen = Math.max(maxlen, Math.max(left[1], right[0]) + 1);
        return new int[]{left[1] + 1, right[0] + 1};
    }

    public static int longestZigZagPath(TreeNode root) {
        longestZigZagPath_(root);
        return maxlen;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
