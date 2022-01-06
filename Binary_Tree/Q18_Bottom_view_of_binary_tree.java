import java.util.*;
public class Q18_Bottom_view_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static class vPair{
        TreeNode node = null; int hl = 0;
        vPair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }

    public static void width(TreeNode node, int hl, int[] minmax){
        if(node == null) return;
        minmax[0] = Math.min(minmax[0], hl);
        minmax[1] = Math.max(minmax[1], hl);

        width(node.left, hl - 1, minmax);
        width(node.right, hl + 1, minmax); 
    }

    // in this question we are required to print all nodes which will be shown from bottom
    // we use same concept of vertical order traversal
    // in that question we were creating a sepatae array list for all level
    // but here we'll only create a single list to add bottom view nodes
    // so in single array list when other node come it'll override previous node value
    public static ArrayList<Integer> BottomView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        int[] minmax = new int[2];
        width(root, 0, minmax);
        int len = minmax[1] - minmax[0] + 1;
        for(int i = 0; i < len; i++){
            list.add(0);
        }
        LinkedList<vPair> queue = new LinkedList<>();
        queue.add(new vPair(root, Math.abs(minmax[0])));
        while(queue.size() != 0){
            int size = queue.size();
            while(size-- > 0){
                vPair rp = queue.removeFirst();
                TreeNode node = rp.node;
                int hl = rp.hl;
                list.set(hl, node.val);
                if(node.left != null) queue.addLast(new vPair(node.left, hl - 1));
                if(node.right != null) queue.addLast(new vPair(node.right, hl + 1));
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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
