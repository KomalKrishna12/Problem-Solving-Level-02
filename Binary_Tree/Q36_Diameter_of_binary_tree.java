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

  // in this second approach we're not craeting a height method separtely becoz of that it is taking o(n^2)
  // time complexity so here we use an array of size 2 at index 0 we store diameter value and at index 1
  // we store height value
  public static int[] diameter_2(TreeNode node){
      if(node == null) return new int[]{0, -1};

      int[] ldia = diameter_2(node.left);
      int[] rdia = diameter_2(node.right);

      int[] mydia = new int[2];
      mydia[0] = Math.max(Math.max(ldia[0], rdia[0]), ldia[1] + rdia[1] + 2);
      mydia[1] = Math.max(ldia[1], rdia[1]) + 1;

      return mydia;
  }

  // now this is third approach here we'll use a static variable 
  // here we're calculating height and simultaneously updating our dia by comparing dia and lh + rh + 2
  public static int dia = 0;
  public static int diameter_3(TreeNode node){

      if(node == null) return -1;

      int lh = diameter_3(node.left);
      int rh = diameter_3(node.right);

      dia = Math.max(dia, lh + rh + 2);

      return Math.max(lh, rh) + 1;

  }

  public static int diameterOfBinaryTree(TreeNode root) {
      // first :
    //return diameter_1(root);

    // second :
    // int[] ans = diameter_2(root);
    // return ans[0];

    // third :
    diameter_3(root);
    return dia;
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
