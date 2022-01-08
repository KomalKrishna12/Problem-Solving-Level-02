import java.util.*;
public class Q26_Root_to_node_path_using_return_method {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  // if node is null then return null
  // if node's val is equal to data then create an arraylist of TreeNode and add node into the list and return
  // now if node's val is not equal to data call for node.left
  // if left != null then add node into it and return and same for right
  // else return null
  public static ArrayList<TreeNode> nodeToRootPath_(TreeNode node, int data) {
    if(node == null){
        return null;
    }
    if(node.val == data){
        ArrayList<TreeNode> ans = new ArrayList<>();
        ans.add(node);
        return ans;
    }
    ArrayList<TreeNode> left = nodeToRootPath_(node.left, data);
    if(left != null){
        left.add(node);
        return left;
    }
    ArrayList<TreeNode> right = nodeToRootPath_(node.right, data);
    if(right != null){
        right.add(node);
        return right;
    }
    return null;
  }

  // if data is not is in the tree
  // if it is null then create an empty arraylist and return it else return ans
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
      ArrayList<TreeNode> ans = nodeToRootPath_(node, data);
      return ans != null ? ans : new ArrayList<>();
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

    int data = scn.nextInt();
    ArrayList<TreeNode> ans = nodeToRootPath(root, data);
    if (ans.size() == 0)  System.out.println();
    for (TreeNode node : ans)
      System.out.print(node.val + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
