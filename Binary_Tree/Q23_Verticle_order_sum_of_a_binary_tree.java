import java.util.*;
public class Q23_Verticle_order_sum_of_a_binary_tree {
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

    public static void width(TreeNode node, int hl, int[] minmax){
        if(node == null) return;

        minmax[0] = Math.min(minmax[0], hl);
        minmax[1] = Math.max(minmax[1], hl);
        
        width(node.left, hl - 1, minmax);
        width(node.right, hl + 1, minmax); 
    }

    // in this question we're required to calculate the sum of each verticle order
    // so we use verticle order conecpt
    // create an arraylist ans
    // using width function calculate length
    // add 0 in and till i become len
    // now create q queue
    // add root with its hl
    // now create a while loop it'll run till queue becomes empty
    // now create a var size which contain queue.size()
    // create another while loop till size-- > 0
    // removefirst pair
    // create a node and store rp.node and in hl store rp.hl
    // now get the prev value which is present at index hl of ans array list and add it with node.val
    // and set the added value to hl index
    // now if node.left is not null and node.right is not null than add that pair at last of queue
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        int[] minmax = new int[2];
        width(root, 0, minmax);
        int len = minmax[1] - minmax[0] + 1;

        for(int i = 0; i < len; i++) ans.add(0);

        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, Math.abs(minmax[0])));

        while(que.size() != 0){
            int size = que.size();

            while(size-- > 0){
                vPair rp = que.removeFirst();

                TreeNode node = rp.node;
                int hl = rp.hl;

                ans.set(hl, ans.get(hl) + node.val);

                if(node.left != null) que.addLast(new vPair(node.left, hl - 1));
                if(node.right != null) que.addLast(new vPair(node.right, hl + 1));
            }
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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}
