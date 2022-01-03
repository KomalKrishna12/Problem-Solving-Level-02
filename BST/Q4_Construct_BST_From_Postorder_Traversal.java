import java.util.Scanner;

public class Q4_Construct_BST_From_Postorder_Traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode bstFromPostorder(int[] postorder) {
        idx = postorder.length - 1;
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;
        return bstFromPostorder(postorder, lr, rr);
    }

    // postorder LRN
    // in postorder root visited at end so we use same approach which we use in preorder but in reverse order
    // create idx initialize it with postorder.length - 1
    // if post[idx] is in between lr and rr
    // but call for right node then left node
    static int idx;
    public static TreeNode bstFromPostorder(int[] post, int lr, int rr) {
        if(idx < 0 || post[idx] < lr || post[idx] > rr) return null;
        TreeNode node = new TreeNode(post[idx--]);
        node.right = bstFromPostorder(post, node.val, rr);
        node.left = bstFromPostorder(post, lr, node.val);
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

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
