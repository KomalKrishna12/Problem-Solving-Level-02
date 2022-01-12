import java.util.*;
public class Q36_Diameter_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static int height(TreeNode node){
      if(node == null) return -1;
      int lh = height(node.left);
      int rh = height(node.right);
      return Math.max(lh, rh) + 1;
  }

  public static int diameter_1(TreeNode node){
      if(node == null) return 0;

      int ld = diameter_1(node.left);
      int rd = diameter_1(node.right);

      int lh = height(node.left);
      int rh = height(node.right);

      int mydia = lh + rh + 2;
      return Math.max(Math.max(ld, rd), mydia);
  }

  public static int diameterOfBinaryTree(TreeNode root) {
    return diameter_1(root);
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
    System.out.println(diameterOfBinaryTree(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
