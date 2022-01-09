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

  public static void markParents(TreeNode root, TreeNode target, HashMap<TreeNode, TreeNode> parent_target) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode remNode = queue.poll();
      if (remNode.left != null) {
        parent_target.put(remNode.left, remNode);
        queue.offer(remNode.left);
      }
      if (remNode.right != null) {
        parent_target.put(remNode.right, remNode);
        queue.offer(remNode.right);
      }
    }
  }

  public static ArrayList<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    HashMap<TreeNode, TreeNode> parent_target = new HashMap<>();
    HashMap<TreeNode, Boolean> visited = new HashMap<>();
    markParents(root, target, parent_target);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(target);
    visited.put(target, true);
    int curr_level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      if (curr_level == k)
        break;
      curr_level++;

      while (size-- > 0) {
        TreeNode curr = queue.poll();
        if (curr.left != null && visited.containsKey(curr.left) == false) {
          queue.offer(curr.left);
          visited.put(curr.left, true);
        }
        if (curr.right != null && visited.containsKey(curr.right) == false) {
          queue.offer(curr.right);
          visited.put(curr.right, true);
        }
        if (parent_target.get(curr) != null && visited.get(parent_target.get(curr)) == null) {
          queue.offer(parent_target.get(curr));
          visited.put(parent_target.get(curr), true);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
          ans.add(curr.val);
        }
        return ans;
      }

    }

    return null;
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
    TreeNode targett = new TreeNode(target);

    ArrayList<Integer> ans = distanceK(root, targett, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
