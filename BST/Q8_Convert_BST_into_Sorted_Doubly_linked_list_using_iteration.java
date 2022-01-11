import java.util.*;

public class Q8_Convert_BST_into_Sorted_Doubly_linked_list_using_iteration {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    // this function will add all the left node of curr into stack if that is not null
    private static void addAllLeftNodes(Node curr, LinkedList<Node> st) {
        while (curr != null) {
            st.addFirst(curr);
            curr = curr.left;
        }
    }

    // this is the second approach in which we use iteration approach 
    // firstly add all left nodes
    // craeate a dummy node and prev, prev point to dummy here prev will traverse the tree and act like tail
    // of linked list
    // now run a while loop till stack size is not zero
    // inside loop removeFirst node and store it as curr node
    // now prev right point to curr and curr left point to prev and prev will set to curr
    // and now add all it's left nodes and repeat 
    public static Node bToDLL(Node root) {
        LinkedList<Node> st = new LinkedList<>();
        addAllLeftNodes(root, st);
        Node dummy = new Node(-1);
        Node prev = dummy;

        while (st.size() != 0) {
            Node curr = st.removeFirst();

            prev.right = curr;
            curr.left = prev;
            prev = curr;

            addAllLeftNodes(curr.right, st);
        }

        Node head = dummy.right;
        dummy.right = head.left = null;

        // for circular connect head with prev(tail of list)
        prev.right = head;
        head.left = prev;
        return head;
    }

    // input_section=================================================

    public static void display(Node node) {
        Node head = node;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
            if (node == head)
                break;
        }

    }

    public static Node constructFromInOrder_(int[] in, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        Node node = new Node(in[mid]);

        node.left = constructFromInOrder_(in, si, mid - 1);
        node.right = constructFromInOrder_(in, mid + 1, ei);

        return node;
    }

    public static Node constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder_(inOrder, 0, n - 1);
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        Node root = constructFromInOrder(in);
        root = bToDLL(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
