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

    // levelorder array contain root of binary tree as first element so use the same logic which we use in 
    // construct binary tree from preorder and inorder traversal
    // now create a TreeNode root and insert levelorder[0] as data
    // now check the length of levelorder or isi and iei index
    // if levelorder.length == 1 || isi == iei that means there is only one element in the array
    // so after creating root node return root
    // now create a int idx so set it at the root val of inorder array
    // Now create a HashSet set and add all values of inorder[] from [isi, idx) (including isi, excluding idx)
    // now create two array for leftlevelordertraversal and rightlevelordertraversal
    // leftorder contain all elements which are in set and rightorder contain all elements which are not in set
    // so start a for loop from 0 to levelorder.length, loop start from 1 because 0th index is the root
    // create a variable element which store all values of array levelorder[i] i -> [1, levelorder.length)
    // now for node.left pass leftorder in place of levelorder and rightorder for node.right
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
