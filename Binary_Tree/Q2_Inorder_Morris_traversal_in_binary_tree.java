import java.util.*;

public class Q2_Inorder_Morris_traversal_in_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // to find right most node there is two parameters left and curr
    // if left.right is not null && curr then move left to its right
    // at end return left
    public static TreeNode getRightmostNode(TreeNode left, TreeNode curr) {
        while(left.right != null && left.right != curr){
            left = left.right;
        }
        return left;
    }

    public static ArrayList<Integer> morrisInTraversal(TreeNode node) {
        // create a curr node
        // run a loop till curr != null
        // create leftnode which store curr.left
        // if leftnode is null then print curr val and move curr as curr.right
        // else calculate right most node
        // if right most node.right is null then create a thred connect its right to curr and move curr to left
        // else cutt the thred make right as null print curr.val and move curr to right
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = node;
        while(curr != null){
            TreeNode leftnode = curr.left;
            if(leftnode == null){
                list.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rightmost = getRightmostNode(leftnode, curr);
                if(rightmost.right == null){ // create the thred
                    rightmost.right = curr;
                    curr = curr.left;
                }
                else{ // cut the thred
                    rightmost.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<Integer> ans = morrisInTraversal(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
