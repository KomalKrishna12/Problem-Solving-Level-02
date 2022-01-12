import java.util.*;
public class Q35_Path_sum_II {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  // this is the same question like Q34 but here we're required to add add root to leaf path
  // in res list for which target sum is same
  public static void pathSum(TreeNode root, int targetSum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> small) {
      if(root == null) return;
      if(root.left == null && root.right == null){
          if(targetSum - root.val == 0){
              // here we're creating a deep copy of small list so it'll copy all values of small into base
              ArrayList<Integer> base = new ArrayList<>(small);
              base.add(root.val);
              res.add(base);
          }
          return;
      }
      small.add(root.val);
      pathSum(root.left, targetSum - root.val, res, small);
      pathSum(root.right, targetSum - root.val, res, small);
      small.remove(small.size() -1);
  }

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      ArrayList<Integer> small = new ArrayList<>();
      pathSum(root, targetSum, res, small);
    return res;
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
    ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
    if (ans.size() == 0) System.out.println(" ");
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
