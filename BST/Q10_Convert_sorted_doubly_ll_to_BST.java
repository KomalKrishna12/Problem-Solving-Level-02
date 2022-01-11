import java.util.*;

public class Q10_Convert_sorted_doubly_ll_to_BST {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    // left : prev
    // right : next
    public static Node getMidNode(Node node) {

        if (node == null || node.right == null)
            return node;
        Node fast = node, slow = node;

        while (fast.right != null && fast.right.right != null) {
            fast = fast.right.right;
            slow = slow.right;
        }

        return slow;

    }

    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        // if node is null or only node exists then return node 
        if (head == null || head.right == null)
            return head;

        // get middle node using getMidNode() that will be our root node    
        Node midNode = getMidNode(head);
        Node root = midNode; 
        
        // now call this method using recursion for left side of list and right side of list
        // for right side of list midNode.right will become our new head
        // prev will store midNode.left so we can check that left node exists or not
        Node nhead = midNode.right;
        Node prev = midNode.left;

        // now set midnode's right and left as null so their link will be break and we can pass left and right
        // tree for left binary tree and right binary tree
        // if prev is not null then break prev's left node also
        midNode.left = midNode.right = nhead.left = null;
        if(prev != null) prev.right = null;

        // if prev is not null then head will be our leftnode
        // for right nhead will be our new right head
        // now pass both leftnode and rightnode for making binary tree and connect it with root.left
        // and root.right
        // at end return root
        Node leftNode = prev != null ? head : null;
        Node rightNode = nhead;

        root.left = SortedDLLToBST(leftNode);
        root.right = SortedDLLToBST(rightNode);
        return root;
    }

    // Input_code===================================================

    public static void display(Node node) {
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

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            Node node = new Node(scn.nextInt());
            prev.right = node;
            node.left = prev;
            prev = prev.right;
        }

        Node head = dummy.right;
        head.left = dummy.right = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = makeList(scn.nextInt());

        head = SortedDLLToBST(head);
        display(head);
    }
}
