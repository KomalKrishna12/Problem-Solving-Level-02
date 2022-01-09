import java.util.*;
public class Q29_Count_all_single_child_parent_using_return_tupe_method {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
 
  // there is a problem with static variable approach
  // when we create a static varaible it'll be in memory very long till program not ended
  // so in this approach we use return type method or backtracking
  // make a faith that this method given correct count for it's left child and right child
  // base case will be node null and leaf node whenever leaf node or null node encounter then return 0
  // now their is a possibility that the root for which we want to calculate single child parent is also a 
  // single child parent and in that case left or right call return 0
  // so add a check for that also if left is null or right is null then add 1 in ans and return ans
  public static int countExactlyOneChild(TreeNode node) {
      if(node == null ||(node.left == null && node.right == null)) return 0;
      int left = countExactlyOneChild(node.left);
      int right = countExactlyOneChild(node.right);
      int ans = left + right;
      if(node.left == null || node.right == null) ans++;
      return ans;
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
