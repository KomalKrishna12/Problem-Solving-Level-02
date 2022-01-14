import java.util.*;
public class Q38_Maximum_path_sum_of_binary_tree{
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // this is static class Pair in which we're using two variables NTN_maxsum(node to node max sum)
  // and RTN_maxsum(root to node max sum)
  static class Pair{
    int NTN_maxSum = Integer.MIN_VALUE;
    int RTN_maxSum = 0;
  }

  // this int... arr denotes an array like main(String... s)
  // so create a max varaible assign arr[0] as max
  // now using for each loop find max and return it
  public static int getMax(int... arr){
    int max = arr[0];
    for (int val : arr) {
      max = Math.max(max, val);
    }
    return max;
  }

  // now create a method maxPathsum_(root) which return an object of Pair class
  // if root is null return pair object which stores the default value
  // now call for it's left and right
  // now craete myans object
  // for RTN compare left pair RTN and right RTN and add root.val in max of both 
  // now for NTN comapre left NTN, right NTN, root.val, left RTN + right RTN + root.val and RTN which we calculate
  // just before
  // now for RTN compare it with root.val
  public static Pair maxPathSum_(TreeNode root) {
    if(root == null) return new Pair();

    Pair lp = maxPathSum_(root.left);
    Pair rp = maxPathSum_(root.right);

    Pair myAns = new Pair();

    myAns.RTN_maxSum = Math.max(lp.RTN_maxSum, rp.RTN_maxSum) + root.val;
    myAns.NTN_maxSum = getMax(root.val, lp.NTN_maxSum, rp.NTN_maxSum, 
                       lp.RTN_maxSum + root.val + rp.RTN_maxSum, myAns.RTN_maxSum);
    myAns.RTN_maxSum = Math.max(myAns.RTN_maxSum, root.val);
    return myAns;
  }

  public static int maxPathSum(TreeNode root) {
    if(root == null) return 0;
    return maxPathSum_(root).NTN_maxSum;
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