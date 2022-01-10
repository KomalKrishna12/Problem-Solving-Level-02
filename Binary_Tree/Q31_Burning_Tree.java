import java.util.*;
public class Q31_Burning_Tree {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static int maxTime = 0;

  public static void burnDown(TreeNode root, TreeNode block, int size) {
      if(root == null || root == block) return;

      maxTime = Math.max(maxTime, size);

      burnDown(root.left, block, size + 1);
      burnDown(root.right, block, size + 1);
  }

  public static int burningTree_(TreeNode root, int fireNode) {
      if(root == null) return -1;
      if(root.val == fireNode){
          burnDown(root, null, 0);
          return 1;
      }
      int lb = burningTree_(root.left, fireNode);
      if(lb != -1){
          burnDown(root, root.left, lb);
          return lb + 1;
      }

      int rb = burningTree_(root.right, fireNode);
      if(rb != -1){
          burnDown(root, root.right, rb);
          return rb + 1;
      }
    return -1;
}

  public static int burningTree(TreeNode root, int fireNode) {
      burningTree_(root, fireNode);
      return maxTime;
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
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}
