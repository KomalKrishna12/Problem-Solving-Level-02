import java.util.*;
public class Q3_Preorder_Morris_traversal_in_binary_tree {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode getRightMostNode(TreeNode leftnode, TreeNode curr) {
      while(leftnode.right != null && leftnode.right != curr) leftnode = leftnode.right;
      return leftnode;
  }

  public static ArrayList<Integer> morrisPreTraversal(TreeNode node) {
      // when leftnode is null print the curr.val and set curr to its right
      // else find right most node(rms)
      // if rms.right == null then create a thred so connect rms.right to curr and set curr to its left
      // else cutt down the thread set curr to its right
      // whenever we create the thread add the curr.val in list
      ArrayList<Integer> ans = new ArrayList<>();
      TreeNode curr = node;
      while(curr != null){
          TreeNode leftnode = curr.left;
          if(leftnode == null){
              ans.add(curr.val);
              curr = curr.right;
          }
          else{
              TreeNode rightmostnode = getRightMostNode(leftnode, curr);
              if(rightmostnode.right == null){
                  
                  ans.add(curr.val);
                  rightmostnode.right = curr;
                  curr = curr.left;
              }
              else{
                  rightmostnode.right = null;
                  curr = curr.right;
              }
          }
      }
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

    ArrayList<Integer> ans = morrisPreTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
