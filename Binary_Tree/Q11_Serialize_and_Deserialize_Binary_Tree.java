import java.util.ArrayList;
import java.util.Scanner;

public class Q11_Serialize_and_Deserialize_Binary_Tree{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // we use StringBuilder instead of string because when we concatenate string then it'll create 
    // a copy of previous string then add new string and return new ref
    // and in stringbuilder it'll directly add new string and return same ref
    public static void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static int idx = 0;
    public static TreeNode deserialize(String[] arr) {
        if(idx == arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);
        return node;
    }
    public static TreeNode deserialize(String str) {
        String[] arr = str.split(",");
        return deserialize(arr);
    }

    static int index = 0;
    public static TreeNode deserial(ArrayList<Integer> list){
        if(index == list.size()) return null;
        if(list.get(index).equals(null)){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(list.get(index++));
        node.left = deserial(list);
        node.right = deserial(list);
        return node;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

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

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}