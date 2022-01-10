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

  // if root is null or block then return
  // update maxTime
  // call left with time + 1
  public static void burnDown(TreeNode root, TreeNode block, int time) {
      if(root == null || root == block) return;

      maxTime = Math.max(maxTime, time);

      burnDown(root.left, block, time + 1);
      burnDown(root.right, block, time + 1);
  }

  // in this problem we use the same approach of All nodes at distance K
  // we have given root and fireNode
  // at fireNode tree start burning so we've to calculate the min time in which whole tree burns
  // it'll take 1 second to burn it's left or right node
  // here we use same concept of root to node path
  // start searching fireNode
  // if root is null then return -1 that means we've not found the fire node
  // when root.val == fireNode call burn down and return 1 to it's parent that means burning starts and it'll
  // burn it's parent in 1 second of time
  // now check if left burn is not equal to -1 that means tree is burning in left side so call burn down
  // and pass block node as left becoz left is already burning so return from left and burn right and return
  // lb + 1 that means left burn in lb time and now add 1
  // same with right burn and if left and right both is -1 then return -1
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
