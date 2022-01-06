import java.util.*;
public class Q16_Vertical_order_traversal_II{
    
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class vPair{
        TreeNode node = null;
        int hl = 0;
        vPair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    
    public static void width(TreeNode root, int hl, int[] minmax){
        if(root == null) return;
        
        minmax[0] = Math.min(minmax[0], hl);
        minmax[1] = Math.max(minmax[1], hl);
        
        width(root.left, hl - 1, minmax);
        width(root.right, hl + 1, minmax);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        PriorityQueue<vPair> parQue = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });
        PriorityQueue<vPair> chQue = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });
        int[] minmax = new int[2];
        width(root, 0, minmax);
        int len = minmax[1] - minmax[0] + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < len; i++){
            ans.add(new ArrayList<>());
        }
        parQue.add(new vPair(root, Math.abs(minmax[0])));
        while(parQue.size() != 0){
            int size = parQue.size();
            while(size-- > 0){
                vPair rp = parQue.remove();
                TreeNode node = rp.node;
                int hl = rp.hl;

                ans.get(rp.hl).add(rp.node.val);
                if(node.left != null) chQue.add(new vPair(node.left, hl - 1));
                if(node.right != null) chQue.add(new vPair(node.right, hl + 1));
            }
            PriorityQueue<vPair> temp = parQue;
            parQue = chQue;
            chQue = temp;
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }

}