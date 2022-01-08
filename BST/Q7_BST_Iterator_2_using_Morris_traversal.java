import java.util.*;

public class Q7_BST_Iterator_2_using_Morris_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // this is the second approach for BST Iterator using morris traversal
    // same approach we use in morris inorder traversal
    // create a curr node which point to root
    // create a while loop which will run till curr != null
    // inside loop create leftnode which store curr.left
    // if leftnode is null than set res as curr node and set curr to it's right
    // if leftnode is not null cretae rmn(right most node) store this by calling getrmn(leftnode)
    // if rmn.right is null then create a thred so set curr to its right and move curr to its left
    // if thread is already created then break the thread set res at curr and move curr to it's right and break
    public static class BSTIterator {
        TreeNode curr = null;

        public BSTIterator(TreeNode root) {
            this.curr = root;
        }

        private TreeNode getrmn(TreeNode rmn){
            while(rmn.right != null && rmn.right != this.curr) rmn = rmn.right;
            return rmn;
        }

        private TreeNode morrisTraversal(){
            TreeNode res = null;
            while(this.curr != null){
                TreeNode leftNode = curr.left;
                if(leftNode == null){
                    res = this.curr;
                    this.curr = this.curr.right;
                    break;
                }
                else{
                    TreeNode rmn = getrmn(leftNode);
                    if(rmn.right == null){
                        rmn.right = this.curr;
                        this.curr = this.curr.left;
                    }
                    else{
                        res = this.curr;
                        rmn.right = null;
                        this.curr = this.curr.right;
                        break;
                    }
                }
            }
            return res;
        }

        public int next() {
            TreeNode res = morrisTraversal();
            return res.val;
        }

        public boolean hasNext() {
            return this.curr != null;
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
