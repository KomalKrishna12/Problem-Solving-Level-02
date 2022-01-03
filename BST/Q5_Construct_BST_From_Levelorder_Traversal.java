import java.util.*;
public class Q5_Construct_BST_From_Levelorder_Traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair{
        TreeNode parent = null;
        int lb = Integer.MIN_VALUE;
        int rb = Integer.MAX_VALUE;
        Pair(TreeNode parent, int lb, int rb){
            this.parent = parent;
            this.lb = lb;
            this.rb = rb;
        }
        Pair(){}
    }

    // to construct BST using Level order traversal we use queue
    // for queue we use Linked List
    // Linked List will be of class Pair which is having parent node and its left an right bound
    // firstly add first element as null and left bound as -infinity and right bound as +infinity
    // create a root node assign it null
    // now run a while loop till queue size is not become 0 and idx is less then n, idx is index to
    // traverse in levelorder and n is the size of levelorder
    // remove pair from first so use removeFirst function
    // element will store levelorder[idx]
    // if element is less than lb or greater than rb then use continue
    // create a TreeNode node with value as element
    // increase idx by 1
    // if removepair.parent is null then set node as root
    // else if element is less than removepair.parent.val then assign it as left node else right node
    // now add node left and right in queue
    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        int n = LevelOrder.length;
        int idx = 0;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair());
        TreeNode root = null;
        while(queue.size() != 0 && idx < n){
            Pair removedPair = queue.removeFirst();
            int element = LevelOrder[idx];
            if(element < removedPair.lb || removedPair.rb < element) continue;
            TreeNode node = new TreeNode(element);
            idx++;
            if(removedPair.parent == null) root = node;
            else{
                if(removedPair.parent.val > element){
                    removedPair.parent.left = node;
                }
                else{
                    removedPair.parent.right = node;
                }
            }
            queue.addLast(new Pair(node, removedPair.lb, node.val));
            queue.addLast(new Pair(node, node.val, removedPair.rb));
        }
        return root;
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

    public static void solve() {
        int n = scn.nextInt();
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
