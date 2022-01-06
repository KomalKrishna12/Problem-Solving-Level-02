import java.util.*;
public class Q20_Circle_view_of_binary_tree {
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
    public static ArrayList<Integer> rightview(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            list.add(queue.getLast().val);
            while(size-- > 0){
                TreeNode remNode = queue.removeFirst();
                if(remNode.left != null) queue.addLast(remNode.left);
                if(remNode.right != null) queue.addLast(remNode.right);
            }
        }
        return list;

    }
    public static ArrayList<Integer> leftview(TreeNode root) {
        if(root == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            list.add(queue.getFirst().val);
            while(size-- > 0){
                TreeNode removedNode = queue.removeFirst();
                if(removedNode.left != null) queue.addLast(removedNode.left);
                if(removedNode.right != null) queue.addLast(removedNode.right);
            }
        }
        return list;

    }
    public static ArrayList<Integer> topview(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        int[] minmax = new int[2];
        width(root, 0, minmax);
        int len = minmax[1] - minmax[0] + 1;
        for(int i = 0; i < len; i++){
            list.add(null);
        }
        LinkedList<vPair> queue = new LinkedList<>();
        queue.add(new vPair(root, Math.abs(minmax[0])));
        while(queue.size() != 0){
            int size = queue.size();
            while(size-- > 0){
                vPair rp = queue.removeFirst();
                TreeNode node = rp.node;
                int hl = rp.hl;
                //list.set(hl, node.val);
                if(list.get(hl) == null) list.set(hl, node.val);
                if(node.left != null) queue.addLast(new vPair(node.left, hl - 1));
                if(node.right != null) queue.addLast(new vPair(node.right, hl + 1));
            }
        }
        return list;

    }
    public static ArrayList<Integer> bottomview(TreeNode root) {
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

    public static ArrayList<Integer> circleview(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Integer> left = leftview(root);
        ArrayList<Integer> right = rightview(root);
        ArrayList<Integer> top = topview(root);
        ArrayList<Integer> bottom = bottomview(root);

        ans.addAll(left);
        ans.addAll(right);
        ans.addAll(top);
        ans.addAll(bottom);

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

        ArrayList<Integer> ans = circleview(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
