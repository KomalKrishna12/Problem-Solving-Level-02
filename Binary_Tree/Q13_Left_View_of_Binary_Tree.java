import java.util.*;
public class Q13_Left_View_of_Binary_Tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // left view that means first node in each level will be printed
    // we create a queue using linkedlist
    // we use addLast() and removeFirst() function of linked list so that it'll behave like queue FIFO
    // firstly add root into queue
    // now run a loop till queue.size() != 0
    // create a variable size inside loop and add the first node val into array list
    // now run inside a while loop till size != 0
    // now remove node from removeFirst()
    // if it's left node exists then add left node in last
    // if right node exists then add right node 
    public static ArrayList<Integer> leftView(TreeNode root) {
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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}
