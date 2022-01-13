import java.util.*;
public class Q37_Maximum_path_sum_in_between_two_leaves_of_binary_tree{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
  
      TreeNode(int val) {
        this.val = val;
      }
    }

    public static class Pair{
        int LTLmax = - (int)1e9 - 1; // leave to leave max sum
        int NTLmax = - (int)1e9 - 1; // node to leave max sum
    }

    public static Pair maxPathSum_(TreeNode root) {

        Pair myAns = new Pair();
        if(root == null) return myAns;

        if(root.left == null && root.right == null){
            myAns.NTLmax = root.val;
            return myAns;
        }
        
        Pair left = maxPathSum_(root.left);
        Pair right = maxPathSum_(root.right);

        myAns.LTLmax = Math.max(left.LTLmax, right.LTLmax);
        if(root.left != null && root.right != null){
            myAns.LTLmax = Math.max(myAns.LTLmax, left.NTLmax + root.val + right.NTLmax);
        }

        myAns.NTLmax = Math.max(left.NTLmax, right.NTLmax) + root.val;
        return myAns;
        
    }
  
    public static int maxPathSum(TreeNode root) {
      return maxPathSum_(root).LTLmax;
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