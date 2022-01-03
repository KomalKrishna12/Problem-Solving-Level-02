import java.util.*;
public class Q5_Construct_BST_From_Levelorder_Traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        return null;
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

    public static void solve() {
        int n = scn.nextInt();
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
