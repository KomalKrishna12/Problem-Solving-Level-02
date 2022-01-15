import java.util.Scanner;

public class Q40_Lowest_common_ancestor_of_Binary_tree {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  // we can found lowest common ancestor using a static Node LCA
  // we use three boolean values for this
  // first check self, if root.val == p or q then self become true
  // now check left and right
  // if left and right or self and right or self and left any two become true that means the node 
  // is our ancestor so set node as LCA
  // while finding left and right check lca != null if yes then return true and print LCA
  // at end return left && right || right && self || left && self
  // if any conction become true then return true
  static TreeNode LCA = null;
  
  public static boolean LCA_(TreeNode node, int p, int q) {
      if(node == null) return false;
      
      boolean self = (node.val == p || node.val == q);
      
      boolean left = LCA_(node.left, p, q);
      if(LCA != null) return true;
      
      boolean right = LCA_(node.right, p, q);
      if(LCA != null) return true;
      
      if((left && right) || (left && self) || (right && self)) LCA = node;
      
      return self || left || right;
  }

  public static TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
      LCA = null;
      LCA_(node, p, q);
      return LCA;
  }

  // input_section=================================================

  public static void display(TreeNode node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);
  }

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int e1 = scn.nextInt();
    int e2 = scn.nextInt();

    TreeNode ans = lowestCommonAncestor(root, e1, e2);
    System.out.println(ans == null ? null : ans.val);
  }

  public static void main(String[] args) {
    solve();
  }
}
