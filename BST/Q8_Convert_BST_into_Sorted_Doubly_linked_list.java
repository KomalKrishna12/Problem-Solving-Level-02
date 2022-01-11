import java.util.*;

public class Q8_Convert_BST_into_Sorted_Doubly_linked_list {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }

  private static Node prev = null;

  private static void bToDLL_(Node root) {
    if(root == null) return;

    bToDLL_(root.left);

    prev.right = root;
    root.left = prev;
    prev = root;

    bToDLL_(root.right);
  }

  // here we're using a static Node prev initialize it with null
  // assume that node.left acts like node.prev and node.right acts like node.next
  // craeate a dummy Node with data -1 and assign prev to dummy
  // now like we traverse inorder we traverse for this and when left operation completed and
  // we're going to perform right then perform 
  // prev.right will point to root and root.left point to prev and prev assign to root
  // we're using static node so that prev will change with recursion
  public static Node bToDLL(Node root) {
    Node dummy = new Node(-1);
    prev = dummy;
    bToDLL_(root);

    Node head = dummy.right;

    dummy.right = head.left = null;

    // circular doubly linked list
    head.left = prev;
    prev.right = head;

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