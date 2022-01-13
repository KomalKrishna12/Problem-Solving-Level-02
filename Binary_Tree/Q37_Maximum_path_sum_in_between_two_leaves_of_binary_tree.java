import java.util.*;

public class Q37_Maximum_path_sum_in_between_two_leaves_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        int LTLmax = -(int) 1e9 - 1; // leave to leave max sum
        int NTLmax = -(int) 1e9 - 1; // node to leave max sum
    }

    // we're required to calculate max path sum between two leaves
    // so there are three possibilities
    // first : max sum exists on left subtree
    // second : max sum exists on right subtree
    // third : in left there is one max root to leave path and in right another path
    // and merging these two so actual max will be (left max path + right max path +
    // root.val)
    // so we've manage two varaibles one is leave to leave max sum (LTLmax) and
    // another is root to leave
    // max sum (NTLmax)
    // if root is null then no max exists
    // if root is leave then node to leave path will be root.val but there will be
    // no leave to leave path
    // suppose left subtree LTLmax = 10 and NTLmax = 5, right subtre LTLmax = 20 and
    // NTLmax = 15, curr = 12
    // so for current LTLmax will be
    // Max of (max of(left LTLmax, right LTLmax),left NTLmax + curr.val + right
    // NTLmax)
    // Max of (max of (10, 20), 5 + 12 + 15)
    // Max of (20, 32) = 32 so here max sum will be left node to leave path +
    // curr.val + right node to leave path
    // so we're using this approach to find the max path sum between two leave
    // for LTLmax and NTLmax we have created a class which contain these two
    // variables
    public static Pair maxPathSum_(TreeNode root) {

        Pair myAns = new Pair();
        if (root == null)
            return myAns;

        if (root.left == null && root.right == null) {
            myAns.NTLmax = root.val;
            return myAns;
        }

        Pair left = maxPathSum_(root.left);
        Pair right = maxPathSum_(root.right);

        myAns.LTLmax = Math.max(left.LTLmax, right.LTLmax);
        // here we check the condition that left and right exists or not
        // if right not exists then no need to check LTLmax for right
        if (root.left != null && root.right != null) {
            myAns.LTLmax = Math.max(myAns.LTLmax, left.NTLmax + root.val + right.NTLmax);
        }

        // and here we're also storing NTLmax for root
        myAns.NTLmax = Math.max(left.NTLmax, right.NTLmax) + root.val;
        return myAns;

    }

    // this is the second approach to solve this problem using static varaiable
    // it's not much reable but it takes less time to code
    // basically in this approch we've created a static variable and in max(root) 
    // we're finding the root to leave path
    // if left and right both child is null then it's leave and return root.val it'll the max sum
    // now for both left and right not null we comapre max and left + right + root.val and store max
    // into max varaible and return max of root to leave path with addition of root.val
    public static int max = 0;

    public static int max(TreeNode root) {
        if (root == null)
            return -(int) 1e9 - 1;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int lm = max(root.left);
        int rm = max(root.right);

        if (root.left != null && root.right != null) {
            max = Math.max(max, lm + root.val + rm);
        }

        return Math.max(lm, rm) + root.val;
    }

    // if don't want to use static variable then we can create an array of size 1 and in compare of max
    // use max[0]
    public static int max2(TreeNode root, int[] max) {
        if (root == null)
            return -(int) 1e9 - 1;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int lm = max2(root.left, max);
        int rm = max2(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], lm + root.val + rm);
        }

        return Math.max(lm, rm) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        // return maxPathSum_(root).LTLmax;
        // max(root);
        // return max;

        int[] max = new int[1];
        max[0] = -(int) 1e9 - 1;
        max2(root, max);
        return max[0];
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

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}