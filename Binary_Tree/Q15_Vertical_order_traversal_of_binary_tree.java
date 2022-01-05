import java.util.*;
public class Q15_Vertical_order_traversal_of_binary_tree {
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

    // in this question we have to display all nodes present vertically
    // create a linkedlist for queue
    // create max and min so that at end we create all vertical nodes from min to max level
    // add root as first pair
    // create a while loop it'll run till queue becomes empty
    // inside loop create a variable size 
    // create a loop inside loop it'll run till size become zero
    // so that we can traverse in level order
    // remove first vpair
    // in max and min replace hl value if any max or min came
    // map.putIfAbsent is used to create a array list for particular key if that key is not present
    // if we use put here so it'll update value
    // now using map.get(hl) add value
    // if left or right is not null then add that child using addLast()
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        LinkedList<vPair> queue = new LinkedList<>();
        // using hashmap we're storing node in there vertical order
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int max = 0, min = 0;
        // root is having 0 hl if left then (hl - 1), if right (hl + 1)
        queue.add(new vPair(root, 0));
        while(queue.size() != 0){
            int size = queue.size();
            // this loop will run till size become 0 using this size we are traversing in level order
            while(size-- > 0){
                vPair rp = queue.removeFirst();

                max = Math.max(max, rp.hl); // update max if any rp.hl is greater than previous max 
                min = Math.min(min, rp.hl);

                map.putIfAbsent(rp.hl, new ArrayList<>()); // if key is not present in map then create using this
                map.get(rp.hl).add(rp.node.val); // now add value in that particular key

                if(rp.node.left != null) queue.addLast(new vPair(rp.node.left, rp.hl - 1));
                if(rp.node.right != null) queue.addLast(new vPair(rp.node.right, rp.hl + 1));
            }
        }
        // now create an ArrayList of ArrayList from min to max
        // now add array list availabe at particular key(i) in map
        // return ans
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = min; i <= max; i++){
            Collections.sort(map.get(i));
            ans.add(map.get(i));
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
