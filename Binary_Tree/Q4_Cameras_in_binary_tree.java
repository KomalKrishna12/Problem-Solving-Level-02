import java.util.*;

public class Q4_Cameras_in_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int camera = 0;

    // 1 == covered with camera
    // 0 == installed camera
    // -1 == required camera
    public static int MinCamerasInBT_(TreeNode root) {
        if(root == null) return 1;
        int leftchild = MinCamerasInBT_(root.left);
        int rightchild = MinCamerasInBT_(root.right);
        if(leftchild == -1 || rightchild == -1){
            // when left child or rightchild is -1 that means any child is requesting for camera so increse
            // camera and return 0
            camera++;
            return 0;
        }
        // if leftchild or rightchild is 0 that means my child having camera so i'm already covered so return 1
        if(leftchild == 0 || rightchild == 0) return 1;

        // else my child is covered so return -1

        return -1;
    }

    public static int MinCamerasInBT(TreeNode root) {
        if (MinCamerasInBT_(root) == -1)
            camera++;
        return camera;
    }

    // input_Section_====================================================================

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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}
