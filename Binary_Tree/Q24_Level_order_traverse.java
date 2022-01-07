import java.util.*;
public class Q24_Level_order_traverse {
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

    // public static void width(TreeNode node, int hl, int[] minmax){
    //     if(node == null) return;

    //     minmax[0] = Math.min(minmax[0], hl);
    //     minmax[1] = Math.max(minmax[1], hl);
        
    //     width(node.left, hl - 1, minmax);
    //     width(node.right, hl + 1, minmax); 
    // }

    public static int height(TreeNode node) {
        if(node == null) return 0;
        else return Math.max(height(node.left), height(node.right)) + 1;
    }
    
    // in this question we are storing sum of each level of node in the arraylist
    // len stores the height of tree
    // it'll total len no of elemnets inside res and add 0 
    // now create a queue add first pair for root which is having 0 as hl
    // now create a while loop and do same thing which we did in level order and all
    // at end return res
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {

        if(root == null) return new ArrayList<>();
        int len = height(root);
        //System.out.println("height : " + len);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(0);
        }

        LinkedList<vPair> queue = new LinkedList<>();
        queue.add(new vPair(root, 0));

        while(queue.size() != 0){
            int size = queue.size();
            
            while(size-- > 0){
                vPair rp = queue.removeFirst();

                TreeNode node = rp.node;
                int hl = rp.hl;

                res.set(hl, res.get(hl) + node.val);
                if(node.left != null){
                    queue.addLast(new vPair(node.left, hl + 1));
                }
                if(node.right != null){
                    queue.addLast(new vPair(node.right, hl + 1));
                }
            }
        }

        
        return res;
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

        // now we have an ans array list which is having there level order sum to that particular level
        // now create a hashmap and put ans.get(i) as key and i+1 as value because we want to display
        // index of max value
        // now if we're getting same ans.get(i) then don't overide it's value so check this using containsKeys()
        ArrayList<Integer> ans = verticalOrderSum(root);
        
        for (int j : ans)
            System.out.println(j);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < ans.size(); i++){
            if(map.containsKey(ans.get(i)) == false) map.put(ans.get(i), i + 1);
        }

        int max = ans.get(0);
        for(int i = 1; i < ans.size(); i++){
            if(max < ans.get(i)) max = ans.get(i);
        }
        System.out.println("max level order : " + map.get(max));
    }

    public static void main(String[] args) {
        solve();
    }
}
