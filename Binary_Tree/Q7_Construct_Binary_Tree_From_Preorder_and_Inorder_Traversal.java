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

    // preorder LRN, inorder LNR
    // psi : preorder start index.
    // pei : preorder end index.
    // isi : inorder start index.
    // iei : inorder end index.    
    // in preorder root will be our first node
    // in inorder root will be there is mid so in inorder before mid every node is left node
    // create a var idx initialize it with isi
    // now increase idx by 1 till inorder[idx] == preorder[psi]
    // basically here we want to find our root in inorder so we can calculate total no of left node
    // so using that count we can traverse in preorder till count
    // create a node with preorder[psi] that will be our root node
    // now call same function using recursion to find its left and right node
    // left preorder will be (psi + 1, psi + count), left inorder will be (isi, idx - 1)
    // right preorder will be (psi + count + 1, pei), right inorder will be (idx + 1, iei)
    // this will create a node for left then right and add them with root using recursion
    public static TreeNode buildTree_(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        // if start index is greater than end index then return null 
        if(isi > iei || psi > pei) return null;
        TreeNode node = new TreeNode(preorder[psi]);
        // firstly store isi in idx now traverse in inorder array to find index of root which is at preorder[psi]
        int idx = isi;
        while (inorder[idx] != preorder[psi]) idx++;
        // now idx is at root position
        // count stores the total no of elements in left side except root
        int count = idx - isi;
        // now call for left and right
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