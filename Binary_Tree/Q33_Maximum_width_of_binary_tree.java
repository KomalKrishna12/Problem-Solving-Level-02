import java.util.*;
public class Q33_Maximum_width_of_binary_tree{
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static class Pair{
      TreeNode node;
      int idx;
      Pair(TreeNode node, int idx){
          this.node = node;
          this.idx = idx;
      }
  }
  
  // in Q17 we found shadow of width of binary tree so we were found the left most node and right most node
  // and return their difference with adding 1
  // but in this question we're finding max width of tree so we're required to found width for each level
  // and return the max width
  // here we use level order traversal approach
  // craete a queue with the help of linkedlist function removeFirst() and addLast()
  // create a max var initialize it with 0
  // now add root node with idx 0 into que
  // craete a while loop which will run till que become empty
  // now set ls and rs with first index using getFirst()
  // store size of queue using que.size() and run inner while loop till size become 0
  // update rs with rp.idx
  // because we want left most idx and right most idx
  // ls and rs is set to left most at first
  // and after loop rs will set to right most idx
  // if left or right exist then add with idx (parent = i then left = i * 2 + 1 and right = i * 2 + 2)
  // after inner loop calculate ls - rs + 1 which is the width of single level and compare it with max
  // and return max at end
  public static int widthOfBinaryTree(TreeNode root) {
      if(root == null) return 0;
      LinkedList<Pair> que = new LinkedList<>();
      que.add(new Pair(root, 0));
      int max = 0;
      while(que.size() != 0){
          int size = que.size();
          int ls = que.getFirst().idx;
          int rs = que.getFirst().idx;
          while(size-- > 0){
              Pair rp = que.removeFirst();

              rs = rp.idx;

              if(rp.node.left != null) que.add(new Pair(rp.node.left, rp.idx * 2 + 1));
              if(rp.node.right != null) que.add(new Pair(rp.node.right, rp.idx * 2 + 2));
          }
          max = Math.max(max, rs - ls + 1);
      }
      return max;
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

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}