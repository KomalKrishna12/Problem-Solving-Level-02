import java.util.Scanner;

public class Q7_Construct_Binary_Tree_From_Preorder_and_Inorder_Traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree_(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(isi > iei || psi > pei) return null;
        TreeNode node = new TreeNode(preorder[psi]);
        int idx = isi;
        while (inorder[idx] != preorder[psi]) idx++;
        int count = idx - isi;
        node.left = buildTree_(preorder, psi + 1, psi + count, inorder, isi, idx - 1);
        node.right = buildTree_(preorder, psi + count + 1, pei, inorder, idx + 1, iei);
        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode node = buildTree_(preorder, 0, n - 1, inorder, 0, n - 1);
        return node;
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}