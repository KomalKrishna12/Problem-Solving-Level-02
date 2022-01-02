import java.util.Scanner;

public class Q9_Construct_Binary_Tree_from_Preorder_and_Postorder_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // psi  : preorder start index,  pei  : preorder end index
    // pssi : postorder start index, psei : postorder end index
    // left pre = psi + 1, psi + count
    // left post = pssi, idx
    // right pre = psi + count + 1, pei
    // right post = idx + 1, psei - 1
    public static TreeNode constructFromPrePost_(int[] pre, int psi, int pei, int[] post, int pssi, int psei) {
        if(psi > pei) return null;
        TreeNode node = new TreeNode(pre[psi]);
        if(psi == pei) return node;
        int idx = pssi;
        while(post[idx] != pre[psi + 1]) idx++;
        int count = idx - pssi + 1;
        node.left = constructFromPrePost_(pre, psi + 1, psi + count, post, pssi, idx);
        node.right = constructFromPrePost_(pre, psi + count + 1, pei, post, idx + 1, psei - 1);
        return node;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        return constructFromPrePost_(pre, 0, n-1, post, 0, n-1);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
