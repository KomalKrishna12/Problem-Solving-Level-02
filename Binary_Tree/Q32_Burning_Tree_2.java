import java.util.*;
public class Q32_Burning_Tree_2 {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void burnDown(TreeNode root, TreeNode block, ArrayList<ArrayList<Integer>> ans, int time){
      if(root == null || root == block) return;

      if(ans.size() == time) ans.add(new ArrayList<>());
      ans.get(time).add(root.val);

      burnDown(root.left, block, ans, time + 1);
      burnDown(root.right, block, ans, time + 1);
  }

  public static int burningTree_(TreeNode root, int data, ArrayList<ArrayList<Integer>> ans){
      if(root == null) return -1;
      if(root.val == data){
          burnDown(root, null, ans, 0);
          return 1;
      }

      int lb = burningTree_(root.left, data, ans);
      if(lb != -1){
          burnDown(root, root.left, ans, lb);
          return lb + 1;
      }

      int rb = burningTree_(root.right, data, ans);
      if(rb != -1){
          burnDown(root, root.right, ans, rb);
          return rb + 1;
      }

      return -1;
  }

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    burningTree_(root, data, ans);
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
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
