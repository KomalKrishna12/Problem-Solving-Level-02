import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q21_Diagonal_order_of_a_binary_tree{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // in this we're required to add all diagonals in the ArrayList and and return
    // create LinkedList queue it'll work like a queue
    // add root in this queue
    // run a while loop till queue.size() != 0
    // create a variable size inside this loop which store the size of queue
    // create an arraylist diagonal which will add all diagonal in the particular order
    // create a loop which will run till size become zero
    // removefirst node check that node if it is not null then add in diagonal list
    // if it's left node exists then add that left node into queue
    // and set rp to it's right
    // when size become 0 while loop ended so all elements in one order added in diagonal so add this diagonal
    // into ans arraylist and run for rest all 
    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            ArrayList<Integer> diagonal = new ArrayList<>();
            while(size-- > 0){
                TreeNode rp = queue.removeFirst();
                while(rp != null){
                    diagonal.add(rp.val);
                    if(rp.left != null) queue.addLast(rp.left);
                    rp = rp.right;
                }
            }
            ans.add(diagonal);
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

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
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