import java.util.*;
public class Q28_Ccount_all_single_child_parent {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  // in this approach we're using static varaibale count
  // whenever null node or leaf node found return
  // else if any one node is null increase the count
  // and using backtracking call all nodes left and right
  static int count = 0;
  public static void countChild_(TreeNode node){
      if(node == null ||(node.left == null && node.right == null)) return;
      if(node.left == null || node.right == null){
          count++;
      }
      countChild_(node.left);
      countChild_(node.right);
  }

  public static int countExactlyOneChild(TreeNode node) {
    countChild_(node);
    return count;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    System.out.println(countExactlyOneChild(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
