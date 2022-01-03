import java.util.Scanner;

public class Q3_Construct_BST_From_Preorder_Traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // for constructing BST using preorder we use a range
    // for first we use lr(left range) as -infinity and rr will be +infinity
    // now create a static variable idx initialize it as 0
    // if idx is greater than or equal to length of preorder then return null
    // if pre[idx] is less than lr or greater than rr then also return null
    // so if pre[idx] is between lr and rr then create a treenode node with pre[idx++] so idx value 
    // node will created and idx will increase
    // now for left pass lr same but rr will be node.val
    // for right pass node.val as lr and rr same 
    private static int idx = 0;
    private static TreeNode bstFromPreorder(int[] pre, int lr, int rr){
        if(idx >= pre.length || pre[idx] < lr || pre[idx] > rr) return null;
        TreeNode node = new TreeNode(pre[idx++]);
        node.left = bstFromPreorder(pre, lr, node.val);
        node.right = bstFromPreorder(pre, node.val, rr);
        return node;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        int lr = -(int) 10e9 - 1;
        int rr = (int) 10e9;
        return bstFromPreorder(preorder, lr, rr);
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
