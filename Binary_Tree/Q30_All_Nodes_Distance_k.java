import java.util.*;

public class Q30_All_Nodes_Distance_k {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void kdown(TreeNode node, int k, TreeNode blocker, ArrayList<Integer> ans) {
    // if root is null or k is negetive or node is our blocker node then return
    // if k equal to 0 then add that node into arraylist ans and return
    // else if both condition not satisfies then call kdown with node.left and
    // node.right and decrease k by 1
    // becoz it is taking 1 path from node to it's left or right child
    if (node == null || k < 0 || node == blocker)
      return;
    if (k == 0) {
      ans.add(node.val);
      return;
    }
    kdown(node.left, k - 1, blocker, ans);
    kdown(node.right, k - 1, blocker, ans);
  }

  public static int distance(TreeNode root, int target, int k, ArrayList<Integer> ans) {
    // when root is null return -1
    // when root's val equal to target call kdown and return 1
    if (root == null)
      return -1;

      // if root.val == target then call kdown for root and here block node will be null
      // and return 1 that means this node is at 1 dustance from it's parent
    if (root.val == target) {
      kdown(root, k, null, ans);
      return 1;
    }

    // now if ld != -1 that means the target is in root.left so call kdown with root.left as blocker
    // and k will be k - ld that means from left root is ld distance aways so now rest will be k - ld
    // and return ld + 1 from left distance + 1 will our next distance
    // same for right
    int ld = distance(root.left, target, k, ans);
    if(ld != -1){
      kdown(root, k - ld, root.left, ans);
      return ld + 1;
    }

    int rd = distance(root.right, target, k, ans);
    if(rd != -1){
      kdown(root, k - rd, root.right, ans);
      return rd + 1;
    }

    return -1;
  }

  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    distance(root, target, k, ans);
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
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
