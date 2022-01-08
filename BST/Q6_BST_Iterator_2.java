import java.util.*;

public class Q6_BST_Iterator_2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // create q stack using linkedlist removeFirst() and addFirst()
    // add root in the stack
    // and add all its left node
    // now check the top of stack
    // display and add it's right node and add all it's left node
    // so it'll work like recursion stack
    public static class BSTIterator {
        LinkedList<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st = new LinkedList<>();
            addAllLeft(root);
        }

        public void addAllLeft(TreeNode node) {
            while (node != null) {
                this.st.addFirst(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode top = this.st.removeFirst();
            addAllLeft(top.right);
            return top.val;
        }

        public boolean hasNext() {
            return this.st.size() != 0;
        }
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

    public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        TreeNode node = new TreeNode(in[mid]);

        node.left = constructFromInOrder_(in, si, mid - 1);
        node.right = constructFromInOrder_(in, mid + 1, ei);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
        BSTIterator itr = new BSTIterator(root);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
