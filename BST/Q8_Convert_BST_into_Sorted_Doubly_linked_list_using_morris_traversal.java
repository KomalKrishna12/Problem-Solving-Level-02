import java.util.*;

public class Q8_Convert_BST_into_Sorted_Doubly_linked_list_using_morris_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node getRightMostNode(Node left, Node curr) {
        while (left.right != null && left.right != curr) {
            left = left.right;
        }
        return left;
    }

    // now this is the third approch for converting BST to doubly linked list using morris tarversal
    // create a curr Node and create a while loop till curr not equals to null
    // now found left most node if leftmost is null than do doubly linked list work and move curr to it's right
    // else found rightmost node
    // if rightmost.right == null then craete a thread and set curr to it's left
    // else if rightmost.right == curr then break the bond do linked list work and set curr to it's right
    public static Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        Node prev = dummy;

        Node curr = root;
        while (curr != null) {
            Node leftmost = curr.left;
            if (leftmost == null) {
                prev.right = curr;
                curr.left = prev;
                prev = curr;
                curr = curr.right;
            } else {
                Node rightmost = getRightMostNode(leftmost, curr);
                if (rightmost.right == null) {
                    rightmost.right = curr;
                    curr = curr.left;
                } else {
                    rightmost.right = null;
                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }
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
