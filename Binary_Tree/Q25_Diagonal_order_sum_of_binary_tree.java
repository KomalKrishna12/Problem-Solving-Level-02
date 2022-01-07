import java.util.*;

public class Q25_Diagonal_order_sum_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            // ArrayList<Integer> diagonal = new ArrayList<>();
            int sum = 0;
            while(size-- > 0){
                TreeNode rp = queue.removeFirst();
                while(rp != null){
                    // diagonal.add(rp.val);
                    sum += rp.val;
                    if(rp.left != null) queue.addLast(rp.left);
                    rp = rp.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<Integer> ans = diagonalOrderSum(root);
        for (Integer j : ans)
            System.out.print(j + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
