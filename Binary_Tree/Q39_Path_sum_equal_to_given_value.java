import java.util.*;
public class Q39_Path_sum_equal_to_given_value{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
  
      TreeNode(int val) {
        this.val = val;
      }
    }

    public static void pathSum_(TreeNode root, int k, int count){
        if(root == null) return;

        if(k - root.val == 0) count++;

        pathSum_(root.left, k - root.val, count);
        pathSum_(root.right, k - root.val, count);
    }
  
    public static int pathSum(TreeNode root, int K) {
        int count = 0;
        pathSum_(root, K, count);
        return count;
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
      int tar = scn.nextInt();
  
      int ans = pathSum(root, tar);
      System.out.println(ans);
    }
  
    public static void main(String[] args) {
      solve();
    }
}