import java.util.HashSet;
import java.util.Scanner;

public class Q10_Construct_binary_tree_from_level_order_and_inorder_traversal {
    public static Scanner scn = new Scanner(System.in);

    static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int isi, int iei, int[] levelOrder) {
        if (isi > iei)
            return null;
        TreeNode node = new TreeNode(levelOrder[0]);
        if (levelOrder.length == 1)
            return node;
        int idx = isi;
        while (inorder[idx] != node.val) {
            idx++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = isi; i < idx; i++) {
            set.add(inorder[i]);
        }

        int[] leftorder = new int[idx - isi];
        int[] rightorder = new int[iei - idx];
        int li = 0, ri = 0;

        for (int i = 1; i < levelOrder.length; i++) {
            int element = levelOrder[i];
            if(set.contains(element)){
                leftorder[li++] = element;
                set.remove(element);
            }
            else{
                rightorder[ri++] = element;
            }
        }

        node.left = buildTree(inorder, isi, idx - 1, leftorder);
        node.right = buildTree(inorder, idx + 1, iei, rightorder);

        return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] levelOrder) {
        int n = inorder.length;
        return buildTree(inorder, 0, n - 1, levelOrder);
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

        int[] InOrder = new int[n];
        for (int i = 0; i < n; i++)
            InOrder[i] = scn.nextInt();

        int[] LevelOrder = new int[n];
        for (int i = 0; i < n; i++)
            LevelOrder[i] = scn.nextInt();

        TreeNode root = buildTree(InOrder, LevelOrder);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
